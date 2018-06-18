package application;

public class EmailInvalideException extends Exception {
  private String mess;
  public EmailInvalideException(String mess){
    super(mess);
  }
  public EmailInvalideException(){
    super();
  }
}
