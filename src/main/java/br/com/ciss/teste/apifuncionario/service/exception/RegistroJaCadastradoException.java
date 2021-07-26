package br.com.ciss.teste.apifuncionario.service.exception;

public class RegistroJaCadastradoException extends RuntimeException {
    public RegistroJaCadastradoException() {
    }

    public RegistroJaCadastradoException(String message) {
        super(message);
    }
}
