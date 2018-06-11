import java.util.List;
import java.util.Map;

public class Puissance4 {
    private List<Joueur> gagnants;
    private int id;
	private Joueur joueur1, joueur2;
	private Plateau plateau;
	/** Joueur actuel */
	private int actuel;

	/**
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 */
    public Puissance4(Joueur j1, Joueur j2){
		this.plateau = new Plateau();
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.id = -1;
		this.actuel = 1;
    }

    public Integer getPion(int ligne, int colonne) {
        return this.plateau.get(ligne, colonne);
    }

    public boolean jouer(int colonne) {
		int res;
		Joueur joueur;
		if (this.actuel == 1) {
			joueur = this.joueur1;
			this.actuel = 2;
		} else {
			joueur = this.joueur2;
			this.actuel = 1;
		}
		res = this.plateau.placerPion(joueur.getPion(), colonne);
		if (res == 1) {
			this.gagnants.add(joueur);
			joueur1.reset();
			joueur2.reset();
			plateau.reset();
		}
		if (res == 0)
			joueur.retirerPion();
		return res;
    }

    private boolean retirerPion() { // À IMPLÉMENTER
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

	public Plateau getPlateau() {
		return this.plateau;
	}

	public Joueur getJoueur1() {
		return this.joueur1;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}
}
