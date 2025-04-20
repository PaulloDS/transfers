package desafio.picpay.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.picpay.service.TransacoesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransacaoController {

    private final TransacoesService transacoesService;

    @PostMapping
    public ResponseEntity<Void> realizarTransacao(@RequestBody TransacaoDTO transacaoDTO) throws BadRequestException {
        transacoesService.transferir(transacaoDTO);
        return ResponseEntity.ok().build();
    }
    
}
