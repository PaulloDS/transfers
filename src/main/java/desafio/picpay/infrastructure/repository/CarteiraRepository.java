package desafio.picpay.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.picpay.infrastructure.entity.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}
