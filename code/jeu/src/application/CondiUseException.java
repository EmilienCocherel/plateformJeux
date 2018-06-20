package application;

public class CondiUseException extends Exception {
  private String mess;
  public CondiUseException(String mess){
    super(mess);
  }
  public CondiUseException(){
    super();
  }
}
