package connect4;

import org.json.simple.JSONObject;

public class Joueur extends application.Joueur {
	private int id;
    private String nom;
    private Integer pion;
    private int nbPions, nbPionsInitial;

    public Joueur(int id, String nom, Integer pion, int nbPions) {
		this.id = id;
        this.nom = nom;
        this.pion = pion;
        this.nbPions = nbPions;
        this.nbPionsInitial = nbPions;
    }

	public Joueur(int id, String nom, Integer pion, int nbPions, int nbPionsInitial) {
		this.id = id;
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

	public int getId() {
		return this.id;
	}

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
		res.put("id", this.id);
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
		Long id = (Long) json.get("id"),
			 pion = (Long) json.get("pion"),
			 nbPions = (Long) json.get("nbPions"),
			 nbPionsInitial = (Long) json.get("nbPionsInitial");
		return new Joueur(id.intValue(),
				(String) json.get("nom"),
				pion.intValue(),
				nbPions.intValue(),
				nbPionsInitial.intValue());
	}
}
