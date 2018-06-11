import java.util.ArrayList;

public class Joueur {
    private int id;
    private int score;
    private ArrayList<Manche> manches;

    public Joueur(int id){
        this.id = id;
    }

    public void jouerPartie(){ // À IMPLÉMENTER

    }

    public void nouvelleManche(Manche manche){
        this.manches.add(manche);
    }

//    Getter et Setter

    public int getScore(){return this.score;}

    public void setScore(int val){this.score=val;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

