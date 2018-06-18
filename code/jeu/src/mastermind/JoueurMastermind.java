package mastermind;

import java.util.ArrayList;
import org.json.simple.*;

public class JoueurMastermind extends application.Joueur {
    private int score;
    private ArrayList<Manche> manches;

    public JoueurMastermind(int id){
        this.identifiant=id;
        this.score=0;
        this.manches=new ArrayList<>();
    }

    public void jouerPartie(){ // À IMPLÉMENTER

    }

    public void nouvelleManche(Manche manche){
        this.manches.add(manche);
    }

    public Manche getMancheCourante(){
        return this.manches.get(this.manches.size()-1);
    }

    public int getScore(){return this.score;}

    public void setScore(int val){this.score=val;}

    /**
     * Convertir le joueur au format JSON
     */
    public JSONObject toJson(){
        JSONObject res = new JSONObject();
        res.put("id", this.identifiant);
        res.put("score", this.score);
        return res;
    }

    /**
     * Mettre à jour les variables par rapport au JSONObject donné
     */
    public void fromJson(JSONObject json){
        Long id = (Long) json.get("id"),
                score = (Long) json.get("score");
        if (id != null){
            this.identifiant = id.intValue();
        }
        if (score != null){
            this.score = score.intValue();
        }
    }
}
