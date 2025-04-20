package desafio.picpay.service;

import java.math.BigDecimal;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import desafio.picpay.controller.TransacaoDTO;
import desafio.picpay.infrastructure.entity.TipoUsuario;
import desafio.picpay.infrastructure.entity.Transacoes;
import desafio.picpay.infrastructure.entity.Usuario;
import desafio.picpay.infrastructure.repository.TransacoesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransacoesService {

    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;
    private final CarteiraService carteiraService;
    private final TransacoesRepository transacoesRepository;
    private final NotificacaoService notificacaoService;

    @Transactional
    public void transferir(TransacaoDTO transacaoDTO) throws BadRequestException {

        Usuario pagador = usuarioService.buscarUsuarioPorId(transacaoDTO.payer());
        Usuario recebedor = usuarioService.buscarUsuarioPorId(transacaoDTO.payee());

        validarUsuarioPagador(pagador);

        validarSaldoUsuario(pagador, transacaoDTO.value());

        validarTransferencia();

        pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoDTO.value()));
        carteiraService.salvar(pagador.getCarteira());
        recebedor.getCarteira().setSaldo(recebedor.getCarteira().getSaldo().add(transacaoDTO.value()));
        carteiraService.salvar(recebedor.getCarteira());

        Transacoes transacoes = Transacoes.builder()
                .valor(transacaoDTO.value())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();

        transacoesRepository.save(transacoes);
        enviarNotificacao();

    }

    private void validarUsuarioPagador(Usuario usuario) {
        try {
            if (usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)) {
                throw new IllegalArgumentException("Transações não autorizadas para esse tipo de usuário!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validarSaldoUsuario(Usuario usuario, BigDecimal valor) {
        try {
            if (usuario.getCarteira().getSaldo().compareTo(valor) < 0) {
                throw new IllegalArgumentException("Saldo insuficiente!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validarTransferencia() {
        try {
            if (!autorizacaoService.validarTransferencia()) {
                throw new IllegalArgumentException("Transação não autorizada pela API!");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void enviarNotificacao() throws BadRequestException {
        try {
            notificacaoService.enviarNotificacao();
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Erro ao enviar notificação!");
        }

    }
    
}
