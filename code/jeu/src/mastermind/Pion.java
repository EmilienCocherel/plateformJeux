package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Map;
import java.util.HashMap;

public class Pion extends Circle{
  private int val;
  private Map<String, Color> couleurs = new HashMap<String, Color>() {{
		put("rouge", Color.RED);
		put("bleu", Color.BLUE);
		put("vert", Color.GREEN);
		put("jaune", Color.YELLOW);
  }};

  public Pion(Paint couleur,int val){
    this.setRadius(10.0);
    this.setFill(couleur);
  }

  public Pion(String coul,int val) {
    this.setRadius(10.0);
	this.setCouleur(coul);
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
		System.out.println(coul);
		this.setFill(this.couleurs.get(coul));
	}
}
