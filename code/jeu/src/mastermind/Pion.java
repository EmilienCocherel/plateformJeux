package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Pion extends Circle{
  private int val;

  public Pion(Paint couleur,int val){
    this.setRadius(10.0);
    this.setFill(couleur);
  }

  public Pion(String coul,int val){
    this.setRadius(10.0);
    if(coul.equals("rouge")){
      this.setFill(Color.RED);
    }
    if(coul.equals("bleu")){
      this.setFill(Color.BLUE);
    }
    if(coul.equals("vert")){
      this.setFill(Color.GREEN);
    }
    if(coul.equals("jaune")){
      this.setFill(Color.YELLOW);
    }
  }

  public int getVal(){
    return this.val;
  }

  public Paint getCouleur(){
    return this.getFill();
  }


  @Override
  public boolean equals(Object o){
      Pion p2=(Pion)o;
      return this.getCouleur().equals(p2.getCouleur());
  }

  @Override
  public String toString(){
    if(this.getCouleur().equals(Color.RED)){
      return "rouge";
    }
    if(this.getCouleur().equals(Color.BLUE)){
      return "bleu";
    }
    if(this.getCouleur().equals(Color.GREEN)){
      return "vert";
    }
    if(this.getCouleur().equals(Color.YELLOW)){
      return "jaune";
    }
    return "";
  }

	public void setCouleur(String coul) {
		if(coul.equals("rouge")){
		  this.setFill(Color.RED);
		}
		if(coul.equals("bleu")){
		  this.setFill(Color.BLUE);
		}
		if(coul.equals("vert")){
		  this.setFill(Color.GREEN);
		}
		if(coul.equals("jaune")){
		  this.setFill(Color.YELLOW);
		}
	}
}
