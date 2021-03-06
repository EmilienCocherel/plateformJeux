package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.json.simple.JSONObject;

public class Combinaison {

    private Pion p1, p2, p3, p4;

	public Combinaison() {
		this.p1 = new Pion(Color.WHITE);
		this.p2 = new Pion(Color.WHITE);
		this.p3 = new Pion(Color.WHITE);
		this.p4 = new Pion(Color.WHITE);
	}

    public Combinaison(Pion p1, Pion p2, Pion p3, Pion p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Combinaison(String p1, String p2, String p3, String p4){
        this.p1=new Pion(p1);
        this.p2=new Pion(p2);
        this.p3=new Pion(p3);
        this.p4=new Pion(p4);
    }

//    Getter et Setter

    public Pion getP1() {
      return this.p1;
    }

    public Paint getCouleurP1() {
      return this.p1.getCouleur();
    }


    public void setCouleurP1(Paint couleur) {
      this.p1.setFill(couleur);
    }

    public Pion getP2() {
      return this.p2;
    }

    public Paint getCouleurP2() {
      return this.p2.getCouleur();
    }


    public void setCouleurP2(Paint couleur) {
        this.p2.setFill(couleur);
    }

    public Pion getP3() {
      return this.p3;
    }

    public Paint getCouleurP3() {
      return this.p3.getCouleur();
    }


    public void setCouleurP3(Paint couleur) {
        this.p3.setFill(couleur);
    }

    public Pion getP4() {
      return this.p4;
    }

    public Paint getCouleurP4() {
      return this.p4.getCouleur();
    }


    public void setCouleurP4(Paint couleur) {
        this.p4.setFill(couleur);
    }

    public void shuffle(){
	    this.p1.sufffleColor();
        this.p2.sufffleColor();
        this.p3.sufffleColor();
        this.p4.sufffleColor();
    }

    @Override
    public boolean equals(Object o){
        Combinaison c2=(Combinaison)o;
        return this.p1.getCouleur().equals(c2.p1.getCouleur()) && this.p2.getCouleur().equals(c2.p2.getCouleur()) && this.p3.getCouleur().equals(c2.p3.getCouleur()) && this.p4.getCouleur().equals(c2.p4.getCouleur());
    }

    @Override
    public String toString(){
        return this.p1.toString()+" "+this.p2.toString()+" "+this.p3.toString()+" "+this.p4.toString();
    }

	public JSONObject toJson() {
		JSONObject res = new JSONObject();
		res.put("p1", this.p1.toString());
		res.put("p2", this.p2.toString());
		res.put("p3", this.p3.toString());
		res.put("p4", this.p4.toString());
		return res;
	}

	public void fromJson(JSONObject json) {
		this.p1.setCouleur((String) json.get("p1"));
		this.p2.setCouleur((String) json.get("p2"));
		this.p3.setCouleur((String) json.get("p3"));
		this.p4.setCouleur((String) json.get("p4"));
	}
}
