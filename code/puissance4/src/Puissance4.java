import java.util.List;
import java.util.Map;

public class Puissance4 {
    private List<Map<Joueur,Integer>> round;
    private int id;

    public Puissance4(Joueur j1, Joueur j2){

    }
    public boolean estFinie(){ // À IMPLÉMENTER
        return true;
    }

    public Integer getPion(int ligne, int colonne){ // À IMPLÉMENTER
        return null;
    }

    public boolean jouer(String joueur, int colonne){ // À IMPLÉMENTER
        return true;
    }

    private boolean retirerPion(){ // À IMPLÉMENTER
        return true;
    }

//    Getter et Setter

    private Joueur getJoueur(String nom){ // À IMPLÉMENTER
        return null;
    }

    private Integer getNbPions(String joueur){ // À IMPLÉMENTER
        return null;
    }
    public List<Map<Joueur, Integer>> getRound() {
        return round;
    }

    public void setRound(List<Map<Joueur, Integer>> round) {
        this.round = round;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
