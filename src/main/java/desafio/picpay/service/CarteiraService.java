package desafio.picpay.service;

import org.springframework.stereotype.Service;

import desafio.picpay.infrastructure.entity.Carteira;
import desafio.picpay.infrastructure.repository.CarteiraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    protected void salvar(Carteira carteira) {
        carteiraRepository.save(carteira);
    }
    
}
