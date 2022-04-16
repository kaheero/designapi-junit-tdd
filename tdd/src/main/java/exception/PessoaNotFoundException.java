package exception;

public class PessoaNotFoundException extends RuntimeException {

  public PessoaNotFoundException(){}

  public PessoaNotFoundException(String message) {
    super(message);
  }

}
