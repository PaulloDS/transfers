package desafio.picpay.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.picpay.infrastructure.entity.Transacoes;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {

}
