package mastermind;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class    Manche {
    private JoueurMastermind j;
    private int num;
    private Combinaison combi;
    private Mastermind partie;
    private int nbCoup;
    private boolean fini;
    private String log;
    private ArrayList<Combinaison> CombiParTour;

    public Manche(Combinaison combi,Mastermind partie, JoueurMastermind j, int num){
        this.j=j;
        this.combi=combi;
        this.partie=partie;
        this.num=num;
        this.nbCoup=0;
        this.fini=false;
        this.log="";
        this.CombiParTour=new ArrayList<>();
    }

    public ArrayList<Combinaison> getCombiParTour() {
        return CombiParTour;
    }

    public void setCombiParTour(ArrayList<Combinaison> combiParTour) {
        CombiParTour = combiParTour;
    }

    public void initCombiParTour(){
        for (int i=0; i<10;i++){
            this.CombiParTour.add(new Combinaison(new Pion(Color.WHITE,1),new Pion(Color.WHITE,2),new Pion(Color.WHITE,3),new Pion(Color.WHITE,4)));
        }
    }

    public boolean estFini(){
        if (this.getCombi().equals(this.getCombi())){
            return true;
        }

        else{
            return false;
        }
    }

    public void finManche(boolean gagne){
        this.partie.prochaineManche(this);
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

    public void incrNbCoup(){
        Combinaison combi = this.partie.getATester();
        this.CombiParTour.get(this.nbCoup).setCouleurP1(combi.getP1().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP2(combi.getP2().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP3(combi.getP3().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP4(combi.getP4().getCouleur());
        this.nbCoup+=1;
    }

    public int getNum(){
        return this.num;
    }

    public String getLog(){
      return this.log;
    }

    public void setLog(String text){
      this.log=text;
    }

    public void addToLog(String text){
      this.log+=text;
    }


}
