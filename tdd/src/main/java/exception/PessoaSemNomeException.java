package exception;

public class PessoaSemNomeException extends RuntimeException {

  public PessoaSemNomeException(){}

  public PessoaSemNomeException(String message){
    super(message);
  }

}
