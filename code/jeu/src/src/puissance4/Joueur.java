package Connect4;

import org.json.simple.JSONObject;

public class Joueur {
    private String nom;
    private Integer pion;
    private int nbPions, nbPionsInitial;

    public Joueur(String nom, Integer pion, int nbPions){
        this.nom = nom;
        this.pion = pion;
        this.nbPions = nbPions;
        this.nbPionsInitial = nbPions;
    }

	public Joueur(String nom, Integer pion, int nbPions, int nbPionsInitial) {
        this.nom = nom;
        this.pion = pion;
        this.nbPions = nbPions;
        this.nbPionsInitial = nbPionsInitial;
	}

	/**
	 * Retire un pion au joueur
	 */
    public boolean retirerPion() {
		if (this.nbPions > 0) {
			this.nbPions --;
			return true;
		} else
			return false;
    }

//    Getter et Setter

    public String getNom() {
        return nom;
    }

    public Integer getPion() {
        return pion;
    }

    public int getNbPions() {
        return nbPions;
    }

	/**
	 * Remettre à zéro pour le round suivant
	 */
	public void reset() {
		this.nbPions = this.nbPionsInitial;
	}

	/**
	 * Convertir le joueur au format JSON
	 */
	public JSONObject toJson() {
		JSONObject res = new JSONObject();
		res.put("nom", this.nom);
		res.put("pion", this.pion);
		res.put("nbPions", this.nbPions);
		res.put("nbPionsInitial", this.nbPionsInitial);
		return res;
	}

	/**
	 * Importer un joueur au format JSON
	 */
	public static Joueur fromJson(JSONObject json) {
		return new Joueur((String) json.get("nom"),
				(Integer) json.get("pion"),
				(int) json.get("nbPions"),
				(int) json.get("nbPionsInitial"));
	}
}
