package mastermind;

import javafx.scene.paint.Paint;

public class Pion{
  private int val;

  public Pion(int val){
    this.val=val;
  }

  public int getVal(){
    return this.val;
  }

  public void setVal(int val){
    this.val=val;
  }

  public String getCouleur(){
    if(this.val == 0){
      return "WHITE";
    }
    if(this.val == 1){
      return "RED";
    }
    if(this.val == 2){
      return "BLUE";
    }
    if(this.val == 3){
      return "GREEN";
    }
    if(this.val == 4){
      return "YELLOW";
    }
    return null;
  }

  public Paint getPeinture(){
    return Paint.valueOf(this.getCouleur());
  }

  @Override
  public boolean equals(Object o){
      Pion p2=(Pion)o;
      return this.val==p2.val;
  }
}
