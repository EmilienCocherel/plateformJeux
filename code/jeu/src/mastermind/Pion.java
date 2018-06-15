package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Pion extends Circle{
  private int val;

  public Pion(int val){
    this.val=val;
    this.setRadius(10.0);
    this.setFill(Color.WHITE);
  }

  public int getVal(){
    return this.val;
  }

  public void setVal(int val){
    this.val=val;
  }

  public Paint getCouleur(){
    return this.getFill();
  }

  @Override
  public boolean equals(Object o){
      Pion p2=(Pion)o;
      return this.getCouleur().equals(p2.getCouleur());
  }
}
