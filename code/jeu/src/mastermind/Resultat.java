package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Resultat {
    private int nbCouleurOkPositionOk;
    private int nbCouleurOkPositionPasOk;
    private ArrayList<Circle> pionsRes;

    public Resultat(){
        this.nbCouleurOkPositionOk=0;
        this.nbCouleurOkPositionPasOk=0;
        this.pionsRes=new ArrayList<>();
        for(int i=0; i<4; i++){
            this.pionsRes.add(new Circle(5.0, Color.WHITE));
        }
    }

    public ArrayList<Circle> getPionsRes() {
        return pionsRes;
    }

    public void initPionRes(int nbCouleurOkPositionOk, int nbCouleurOkPositionPasOk){
        this.nbCouleurOkPositionOk=nbCouleurOkPositionOk;
        this.nbCouleurOkPositionPasOk=nbCouleurOkPositionPasOk;
        for(int i=0; i<this.nbCouleurOkPositionOk; i++){
            this.pionsRes.get(i).setFill(Color.GOLD);
        }
        for(int i=0; i<this.nbCouleurOkPositionPasOk; i++){
            this.pionsRes.get(i+this.nbCouleurOkPositionOk).setFill(Color.BLACK);
        }
    }

	public JSONObject toJson() {
		JSONObject res = new JSONObject();
		res.put("nbCoulOkPosOk", this.nbCouleurOkPositionOk);
		res.put("nbCoulOkPosPasOk", this.nbCouleurOkPositionPasOk);
		return res;
	}

	public void fromJson(JSONObject json) {
		Long nbCouleurOkPositionOk = (Long) json.get("nbCoulOkPosOk"),
			 nbCouleurOkPositionPasOk = (Long) json.get("nbCoulOkPosPasOk");
		this.initPionRes(nbCouleurOkPositionOk.intValue(), nbCouleurOkPositionPasOk.intValue());
	}
}
