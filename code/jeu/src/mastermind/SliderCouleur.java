package mastermind;

import javafx.scene.control.Slider;
import javafx.geometry.Orientation;

public class SliderCouleur extends Slider{
  private int valPion;

  public SliderCouleur(int val){
    super();
    this.setMin(0);
    this.setMax(5);
    this.setBlockIncrement(1);
    this.setOrientation(Orientation.VERTICAL);
    this.setMajorTickUnit(1);
    this.setMinorTickCount(1);
    //this.setMajorTickSpacing(1);
    //this.setMinorTickSpacing(1);
    //this.setPaintTicks(true);
    //this.setPaintLabels(true);
    this.valPion= val;
  }

  //    Getter et Setter

  public int getValPion(){
    return this.valPion;
  }
}
