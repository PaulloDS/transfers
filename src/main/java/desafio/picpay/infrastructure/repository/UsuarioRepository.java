package desafio.picpay.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio.picpay.infrastructure.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
