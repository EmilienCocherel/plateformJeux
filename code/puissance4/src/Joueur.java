public class Joueur {
    private String nom;
    private Integer pion;
    private int nbPions;

    public Joueur(String nom, Integer pion, int nbPions){
        this.nom = nom;
        this.pion = pion;
        this.nbPions = nbPions;
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
}
