import javafx.scene.control.RadioButton;

public class BoutonRadio extends RadioButton{
  private int pion;

  public BoutonRadio(String text,int pion){
    this.setText(text);
    this.pion=pion;
  }
}
