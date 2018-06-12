import javafx.scene.control.RadioButton;

public class BoutonRadio extends RadioButton{
  private Pion pion;

  public BoutonRadio(String text,int val){
    this.setText(text);
    this.pion= new Pion(val);
  }

  public Pion getPion(){
    return this.pion;
  }
}
