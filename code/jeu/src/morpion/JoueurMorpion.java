package morpion;

import java.util.ArrayList;
import application.*;
import mastermind.Manche;

public class JoueurMorpion extends application.Joueur {
    private int score;

    public JoueurMorpion(int id){
        this.identifiant=id;
        this.score=0;
    }

    public void jouerPartie(){ // À IMPLÉMENTER

    }

//    Getter et Setter

    public int getScore(){return this.score;}

    public void setScore(int val){this.score=val;}
}
