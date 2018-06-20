package application;

public class MdpInvalideException extends Exception {
  private String mess;
  public MdpInvalideException(String mess){
    super(mess);
  }
  public MdpInvalideException(){
    super();
  }
}
