package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Pion extends Circle{
  private Map<String, Color> couleurs = new HashMap<String, Color>() {{
		put("rouge", Color.RED);
		put("bleu", Color.BLUE);
		put("vert", Color.GREEN);
		put("jaune", Color.YELLOW);
		put("violet", Color.PURPLE);
		put("orange", Color.ORANGE);
  }};

  public Pion(Paint couleur){
    this.setRadius(15.0);
    this.setFill(couleur);
  }

  public Pion(String coul) {
    this.setRadius(15.0);
	  this.setCouleur(coul);
  }

  public Pion() {
  	this.setRadius(15.0);
  	this.setFill(Color.RED);
  }


  //    Getter et Setter

  public Paint getCouleur(){
    return this.getFill();
  }

  public void setCouleur(String coul) {
  	if (this.couleurs.containsKey(coul)){
		this.setFill(this.couleurs.get(coul));
	}
  }

  public void sufffleColor(){
	  Random random = new Random();
	  int val = random.nextInt(5);
	  if (val ==0){
	  	this.setFill(Color.RED);
	  }
	  if (val ==1){
		  this.setFill(Color.BLUE);
	  }
	  if (val ==2){
		  this.setFill(Color.GREEN);
	  }
	  if (val ==3){
		  this.setFill(Color.YELLOW);
	  }
	  if (val ==4){
		  this.setFill(Color.PURPLE);
	  }
	  if (val ==5){
		  this.setFill(Color.ORANGE);
	  }
  }



  @Override
  public boolean equals(Object o){
      Pion p2=(Pion)o;
      return this.getCouleur().equals(p2.getCouleur());
  }

	@Override
	public String toString() {
		for (Map.Entry<String,Color> entry : this.couleurs.entrySet())
			if (entry.getValue().equals(this.getCouleur()))
				return entry.getKey();
		return "";
	}
}
