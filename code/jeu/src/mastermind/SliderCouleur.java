package mastermind;

import javafx.scene.control.Slider;
import javafx.geometry.Orientation;

public class SliderCouleur extends Slider{
  private int valPion;

  public SliderCouleur(int val){
    super();
    this.setMin(0);
    this.setMax(5);
    this.setShowTickLabels(false);
    this.setShowTickMarks(false);
    this.setBlockIncrement(1);
    this.setOrientation(Orientation.VERTICAL);
    this.valPion= val;
  }

  //    Getter et Setter

  public int getValPion(){
    return this.valPion;
  }
}
