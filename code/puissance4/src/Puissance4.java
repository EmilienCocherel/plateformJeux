import java.util.List;
import java.util.Map;

public class Puissance4 {
    private List<Map<Joueur,Integer>> round;
    private int id;
	private Joueur joueur1, joueur2;
	private Plateau plateau;
	/** Le joueur dont c'est le tour. */
	private int actuel;

	/**
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 */
    public Puissance4(Joueur j1, Joueur j2){
		this.plateau = new Plateau();
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.actuel = 1;
		this.id = -1;
    }

	/**
	 * @return Si la partie est finie ou non.
	 */
    public boolean estFinie() {
		return this.plateau.aGagne(this.joueur1.getPion())
			|| this.plateau.aGagne(this.joueur2.getPion());
    }

    public Integer getPion(int ligne, int colonne){ // À IMPLÉMENTER
        return this.plateau.get(ligne, colonne);
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
