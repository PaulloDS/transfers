package desafio.picpay.service;

import org.springframework.stereotype.Service;

import desafio.picpay.exceptions.UserNotFound;
import desafio.picpay.infrastructure.entity.Usuario;
import desafio.picpay.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UserNotFound("Usuário não encontrado!"));
    }
    
}
