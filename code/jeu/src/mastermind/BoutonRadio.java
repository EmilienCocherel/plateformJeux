package mastermind;

import javafx.scene.control.RadioButton;

public class BoutonRadio extends RadioButton{
  private int valPion;

  public BoutonRadio(String text,int val){
    this.setText(text);
    this.valPion= val;
  }

  //    Getter et Setter

  public int getValPion(){
    return this.valPion;
  }
}
