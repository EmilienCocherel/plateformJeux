package connect4;

import java.util.ArrayList;
import java.util.List;
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
	private int tour;

	/**
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 * @param actuel Lequel des deux est le joueur actuel
	 */
    public Puissance4(Joueur j1, Joueur j2, int actuel) {
		this.plateau = new Plateau();
		this.gagnants = new ArrayList<>();
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.id = -1;
		if (actuel == joueur1.getId())
			this.actuel = 1;
		else
			this.actuel = 2;
		this.tour = this.actuel;
	}

    public Integer getPion(int ligne, int colonne) {
        return this.plateau.get(ligne, colonne);
    }

    public boolean jouer(int colonne) {
		boolean res;
		Joueur joueur = this.getJoueurCourant();
		res = this.plateau.placerPion(colonne, joueur.getPion());
		joueur.retirerPion();
		this.passerTour();
		return res;
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
		List<Integer> gagnants = new ArrayList<>();
		for (Joueur joueur : this.gagnants) {
			if (joueur == this.joueur1)
				gagnants.add(1);
			else
				gagnants.add(2);
		}
		obj.put("plateau", this.plateau.toJson());
		obj.put("joueur1", this.joueur1.toJson());
		obj.put("joueur2", this.joueur2.toJson());
		obj.put("id", this.id);
		obj.put("tour", this.tour);
		obj.put("gagnants", gagnants);
		return obj;
	}

	/**
	 * Mettre à jour les variables par rapport au JSONObject donné
	 */
	public void fromJson(JSONObject json) {
		Long id = (Long) json.get("id"),
			 tour = (Long) json.get("tour");
		JSONArray gagnants = (JSONArray) json.get("gagnants");
		this.plateau.fromJson((JSONArray) json.get("plateau"));
		this.joueur1.fromJson((JSONObject) json.get("joueur1"));
		this.joueur2.fromJson((JSONObject) json.get("joueur2"));
		if (id != null)
			this.id = id.intValue();
		if (tour != null)
			this.tour = tour.intValue();

		// Gagnants
		this.gagnants = new ArrayList<>();
		for (Object elem : gagnants) {
			id = (Long) elem;
			if (id != null) {
				if (id == 1)
					this.gagnants.add(this.joueur1);
				else
					this.gagnants.add(this.joueur2);
			}
		}
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
		int j1 = 0;
		for (Joueur gagnant : this.gagnants) {
			if (gagnant == this.joueur1)
				j1++;
		}
		if (j1 > this.gagnants.size()/2)
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
		return this.tour == this.actuel;
	}

	/**
	 * @return le joueur dont c'est le tour
	 */
	public int tourDe() {
		return this.tour;
	}

	/**
	 * Fait passer au tour du joueur suivant
	 */
	public void passerTour() {
		if (this.tour == 1)
			this.tour = 2;
		else
			this.tour = 1;
	}
}
