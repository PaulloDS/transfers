package desafio.picpay.service;

import org.springframework.stereotype.Service;

import desafio.picpay.infrastructure.clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {

    private final AutorizacaoClient autorizacaoClient;

    protected boolean validarTransferencia() {
        if (autorizacaoClient.validarAutorizacao().data().authorization().equals("true")) {
            return true;
        }
        return false;
    }
    
}
