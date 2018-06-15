package mastermind;

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

    public void verifCombi(Combinaison test){
        if(this.combi.equals(test)){
            this.finManche();
        }
    }

    public ArrayList<Combinaison> getCombiParTour() {
        return CombiParTour;
    }

    public void setCombiParTour(ArrayList<Combinaison> combiParTour) {
        CombiParTour = combiParTour;
    }

    public void initCombiParTour(){
        for (int i=0; i<10;i++){
            this.CombiParTour.add(new Combinaison(new Pion(0),new Pion(0),new Pion(0),new Pion(0)));
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

    public void finManche(){
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
