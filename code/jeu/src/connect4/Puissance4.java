package connect4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Puissance4 {
    private List<Joueur> gagnants;
    private int id;
	private Joueur joueur1, joueur2;
	private Plateau plateau;
	/** Joueur actuel (celui qui utilise ce client) */
	private int actuel;
	/** Si c'est le tour du joueur actuel */
	private boolean tour;

	/**
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 */
    public Puissance4(Joueur j1, Joueur j2, int actuel){
		this.plateau = new Plateau();
		this.gagnants = new ArrayList<>();
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.id = -1;
		this.actuel = actuel;
		this.tour = this.actuel == 1;
    }

	/**
	 * @param plateau Le plateau
	 * @param gagnants La liste des gagnants
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 * @param id L'id
	 * @param actuel Le joueur actuel
	 * @param tour Si c'est le tour du joueur actuel
	 */
	public Puissance4(Plateau plateau, List<Joueur> gagnants, Joueur joueur1, Joueur joueur2,
			int id, int actuel, boolean tour) {
		this.plateau = plateau;
		this.gagnants = gagnants;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.id = id;
		this.actuel = actuel;
		this.tour = tour;
	}

    public Integer getPion(int ligne, int colonne) {
        return this.plateau.get(ligne, colonne);
    }

    public boolean jouer(int colonne) {
		boolean res;
		Joueur joueur = this.getJoueurCourant();
		res = this.plateau.placerPion(colonne, joueur.getPion());
		joueur.retirerPion();
		this.tour = false;
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

    public List<Joueur> getGagnants() {
        return this.gagnants;
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

	public void setJoueur1(Joueur joueur) {
		this.joueur1 = joueur;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}

	public void setJoueur2(Joueur joueur) {
		this.joueur2 = joueur;
	}

	/**
	 * @return le joueur actuel
	 */
	public Joueur getJoueurCourant() {
		if (this.actuel == 1)
			return this.joueur1;
		else
			return this.joueur2;
	}

	/**
	 * @return l'adversaire
	 */
	public Joueur getAdversaire() {
		if (this.actuel == 1)
			return this.joueur2;
		else
			return this.joueur1;
	}

	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("plateau", this.plateau.toJson());
		obj.put("joueur1", this.joueur1.toJson());
		obj.put("joueur2", this.joueur2.toJson());
		obj.put("actuel", this.actuel);
		obj.put("id", this.id);
		obj.put("tour", this.tour);
		return obj;
	}

	public static Puissance4 fromJson(JSONObject json) {
		Long actuel = (Long) json.get("actuel"),
			 id = (Long) json.get("id");
		return new Puissance4(Plateau.fromJson((JSONArray) json.get("plateau")),
					(List<Joueur>) json.get("gagnants"),
					Joueur.fromJson((JSONObject) json.get("joueur1")),
					Joueur.fromJson((JSONObject) json.get("joueur2")),
					actuel.intValue(),
					id.intValue(),
					(boolean) json.get("tour")
					);
	}

	/**
	 * @return le round courant
	 */
	public int getRound() {
		return this.gagnants.size()+1;
	}

	/**
	 * @return le joueur gagnant dans une partie terminée
	 */
	public Joueur getGagnant() {
		int j1 = 0, j2 = 0;
		for (Joueur gagnant : this.gagnants) {
			if (gagnant == this.joueur1)
				j1++;
			else
				j2++;
		}
		if (j1 > 1)
			return this.joueur1;
		else
			return this.joueur2;
	}

	/**
	 * Abandonner la partie.
	 */
	public void abandonner() {
		this.gagnants = new ArrayList<>();
		for (int i = 0; i < 3; i++)
			this.gagnants.add(this.getAdversaire());
	}

	/**
	 * @return si c'est le tour du joueur actuel
	 */
	public boolean isTour() {
		return this.tour;
	}

	/**
	 * Fait passer au tour du joueur actuel
	 */
	public void passerTour() {
		this.tour = true;
	}
}
