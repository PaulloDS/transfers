package desafio.picpay.exceptions;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String mensagem) {
        super("Usuário não encontrado!");
    }
    
}
