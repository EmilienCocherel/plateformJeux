package morpion;

import java.util.ArrayList;
import application.*;

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

//    Getter et Setter

    public Manche getMancheCourante(){
        return this.manches.get(this.manches.size()-1);
    }

    public int getScore(){return this.score;}

    public void setScore(int val){this.score=val;}
}
