package desafio.picpay.service;

import org.springframework.stereotype.Service;

import desafio.picpay.infrastructure.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoClient notificacaoClient;

    public void enviarNotificacao() {
        notificacaoClient.enviarNotificacao();
    }
}
