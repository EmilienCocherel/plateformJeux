package mastermind;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.HashMap;

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

    public ArrayList<Combinaison> getCombiParTour() {
        return CombiParTour;
    }

    public void setCombiParTour(ArrayList<Combinaison> combiParTour) {
        this.CombiParTour = combiParTour;
    }

    public void initCombiParTour(){
        for (int i=0; i<10;i++){
            this.CombiParTour.add(new Combinaison(new Pion(Color.WHITE,1),new Pion(Color.WHITE,2),new Pion(Color.WHITE,3),new Pion(Color.WHITE,4)));
        }
    }

    public ArrayList<Resultat> getResParTour() {
        return this.resParTour;
    }

    public void setResParTour(ArrayList<Resultat> resParTour) {
        this.resParTour = resParTour;
    }

    public void initResParTour(){
        for (int i=0; i<10;i++){
            this.resParTour.add(new Resultat());
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
        if (gagne){
            this.getJoueurMastermind().setScore(this.getJoueurMastermind().getScore()+11-this.getNbCoup());
            this.partie.prochaineManche(this,gagne);
        }
        else{
            this.getJoueurMastermind().setScore(this.getJoueurMastermind().getScore()-3);
            this.partie.prochaineManche(this,gagne);
        }
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

    public void incrNbCoup(int nbCouleurOkPositionOk,int nbCouleurOkPositionPasOk){
        Combinaison combi = this.partie.getATester();
        this.CombiParTour.get(this.nbCoup).setCouleurP1(combi.getP1().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP2(combi.getP2().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP3(combi.getP3().getCouleur());
        this.CombiParTour.get(this.nbCoup).setCouleurP4(combi.getP4().getCouleur());
        this.resParTour.get(this.nbCoup).initPionRes(nbCouleurOkPositionOk,nbCouleurOkPositionPasOk);
        this.nbCoup+=1;
    }

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

    public int getNum(){
        return this.num;
    }

    public String getLog(){
      return this.log;
    }



}
