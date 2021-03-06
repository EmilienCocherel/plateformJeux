package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class    Manche {
    private JoueurMastermind j;
    private int num;
    private Combinaison combi;
    private Mastermind partie;
    private int nbCoup;
    private boolean fini;
    private String log;
    private ArrayList<Combinaison> CombiParTour;
    private ArrayList<Resultat> resParTour;

    public Manche(Combinaison combi,Mastermind partie, JoueurMastermind j, int num){
        this.j=j;
        this.combi=combi;
        this.partie=partie;
        this.num=num;
        this.nbCoup=0;
        this.fini=false;
        this.log="";
        this.CombiParTour=new ArrayList<>();
        this.resParTour=new ArrayList<>();
    }

    //    Getter et Setter

    public int getNum(){
        return this.num;
    }

    public String getLog(){
      return this.log;
    }

    public JoueurMastermind getJoueurMastermind(){
        return this.j;
    }

    public Combinaison getCombi() {
        return combi;
    }

    public int getNbCoup(){
        return this.nbCoup;
    }

    public void setNbCoup(int val){
        this.nbCoup = val;
    }

    public ArrayList<Combinaison> getCombiParTour() {
        return CombiParTour;
    }

    public void setCombiParTour(ArrayList<Combinaison> combiParTour) {
        this.CombiParTour = combiParTour;
    }
    public ArrayList<Resultat> getResParTour() {
        return this.resParTour;
    }

    public void setResParTour(ArrayList<Resultat> resParTour) {
        this.resParTour = resParTour;
    }

    /**
     * initialise CombiParTour en le remplissant de pions blanc
     */
    public void initCombiParTour(){
        for (int i=0; i<10;i++){
            this.CombiParTour.add(new Combinaison(new Pion(Color.WHITE),new Pion(Color.WHITE),new Pion(Color.WHITE),new Pion(Color.WHITE)));
        }
    }

    /**
     * initialise resParTour avec des resultat null
     */
    public void initResParTour(){
        for (int i=0; i<10;i++){
            this.resParTour.add(new Resultat());
        }
    }

    /**
    * @return si la manche est fini ou non
    */
    public boolean estFini(){
        if (this.getCombi().equals(this.getCombi())){
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * effectu les action après la fin d'une manche en fonction de si la manche à était remporté ou perdu
     */
    public void finManche(boolean gagne){
        if (gagne){
            this.getJoueurMastermind().setScore(this.getJoueurMastermind().getScore()+11-this.getNbCoup());
            this.partie.prochaineManche(this,gagne);
        }
        else{
            this.getJoueurMastermind().setScore(this.getJoueurMastermind().getScore()-3);
            this.partie.prochaineManche(this,gagne);
        }
    }

    /**
     * augmente le nombre de coup joué de 1 et actualisé l'historique de jeu
     */
    public void incrNbCoup(int nbCouleurOkPositionOk,int nbCouleurOkPositionPasOk){
        Combinaison combi = this.partie.getATester();
        this.CombiParTour.get(this.nbCoup).setCouleurP1(combi.getP1().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP2(combi.getP2().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP3(combi.getP3().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP4(combi.getP4().getCouleur());
        this.resParTour.get(this.nbCoup).initPionRes(nbCouleurOkPositionOk,nbCouleurOkPositionPasOk);
        this.nbCoup+=1;
    }

    /**
     * calculs le nombre de pions de la bonne couleur à la bonne position et le nombre de pions de la bonne couleur à la mauvaise position
     */
    public ArrayList<Integer> calculBonPions(){
        ArrayList res = new ArrayList<>();
        Integer nbCouleurOkPositionOk = 0;
        Integer nbCouleurOkPositionPasOk = 0;
        HashMap<Paint,Integer> dico = new HashMap<>();
        dico.put(this.partie.getATester().getCouleurP1(),dico.getOrDefault(this.partie.getATester().getCouleurP1(), 0)+1);
        dico.put(this.partie.getATester().getCouleurP2(),dico.getOrDefault(this.partie.getATester().getCouleurP2(), 0)+1);
        dico.put(this.partie.getATester().getCouleurP3(),dico.getOrDefault(this.partie.getATester().getCouleurP3(), 0)+1);
        dico.put(this.partie.getATester().getCouleurP4(),dico.getOrDefault(this.partie.getATester().getCouleurP4(), 0)+1);
        if(this.combi.getCouleurP1().equals(this.partie.getATester().getCouleurP1())){
            nbCouleurOkPositionOk+=1;
        }
        if(this.combi.getCouleurP2().equals(this.partie.getATester().getCouleurP2())){
            nbCouleurOkPositionOk+=1;
        }
        if(this.combi.getCouleurP3().equals(this.partie.getATester().getCouleurP3())){
            nbCouleurOkPositionOk+=1;
        }
        if(this.combi.getCouleurP4().equals(this.partie.getATester().getCouleurP4())){
            nbCouleurOkPositionOk+=1;
        }

        if(dico.containsKey(this.combi.getCouleurP1())){
            if(dico.get(this.combi.getCouleurP1())>0){
                nbCouleurOkPositionPasOk+=1;
                dico.replace(this.combi.getCouleurP1(), dico.get(this.combi.getCouleurP1())-1);
            }
        }

        if(dico.containsKey(this.combi.getCouleurP2())){
            if(dico.get(this.combi.getCouleurP2())>0){
                nbCouleurOkPositionPasOk+=1;
                dico.replace(this.combi.getCouleurP2(), dico.get(this.combi.getCouleurP2())-1);
            }
        }

        if(dico.containsKey(this.combi.getCouleurP3())){
            if(dico.get(this.combi.getCouleurP3())>0){
                nbCouleurOkPositionPasOk+=1;
                dico.replace(this.combi.getCouleurP3(), dico.get(this.combi.getCouleurP3())-1);
            }
        }

        if(dico.containsKey(this.combi.getCouleurP4())){
            if(dico.get(this.combi.getCouleurP4())>0){
                nbCouleurOkPositionPasOk+=1;
                dico.replace(this.combi.getCouleurP4(), dico.get(this.combi.getCouleurP4())-1);
            }
        }
        res.add(nbCouleurOkPositionOk);
        res.add(nbCouleurOkPositionPasOk-nbCouleurOkPositionOk);
        return res;
    }

	public JSONObject toJson() {
		JSONObject res = new JSONObject();
		JSONArray combiParTour = new JSONArray(), resParTour = new JSONArray();
		res.put("num", this.num);
		res.put("combi", this.combi.toJson());
		res.put("nbCoup", this.nbCoup);
		res.put("fini", this.fini);

		// CombiParTour
		for (Combinaison combi : this.CombiParTour)
			combiParTour.add(combi.toJson());
		res.put("CombiParTour", combiParTour);

		// resParTour
		for (Resultat resultat : this.resParTour)
			resParTour.add(resultat.toJson());
		res.put("resParTour", resParTour);

		return res;
	}

	public void fromJson(JSONObject json) {
		Long num = (Long) json.get("num"), nbCoup = (Long) json.get("nbCoup");
		JSONArray combiParTour = (JSONArray) json.get("CombiParTour"),
				  resParTour = (JSONArray) json.get("resParTour");
		this.num = num.intValue();
		this.combi.fromJson((JSONObject) json.get("combi"));
		this.nbCoup = nbCoup.intValue();
		this.fini = (boolean) json.get("fini");

		// CombiParTour
		JSONObject combi;
		for (int i=0; i < combiParTour.size(); i++) {
			combi = (JSONObject) combiParTour.get(i);
			if (this.CombiParTour.size() > i)
				this.CombiParTour.get(i).fromJson(combi);
		}

		// resParTour
		JSONObject res;
		for (int i=0; i < resParTour.size(); i++) {
			res = (JSONObject) resParTour.get(i);
			this.resParTour.get(i).fromJson(res);
		}
	}
}
