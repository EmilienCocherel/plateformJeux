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
		put("violet", Color.PURPLE);
		put("orange", Color.ORANGE);
  }};

  public Pion(Paint couleur){
    this.setRadius(10.0);
    this.setFill(couleur);
  }

  public Pion(String coul) {
    this.setRadius(10.0);
	  this.setCouleur(coul);
  }

  //    Getter et Setter

  public Paint getCouleur(){
    return this.getFill();
  }

  public void setCouleur(String coul) {
		System.out.println(coul);
		this.setFill(this.couleurs.get(coul));
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
