public class Joueur {

    private String nom;
    private Integer pion;
    private int nbPions;

    public Joueur(String nom, Integer pion, int nbPions){
        this.nom = nom;
        this.pion = pion;
        this.nbPions = nbPions;
    }

    public boolean retirerPion(){ // À IMPLÉMENTER
        return true;
    }

//    Getter et Setter

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPion() {
        return pion;
    }

    public void setPion(Integer pion) {
        this.pion = pion;
    }

    public int getNbPions() {
        return nbPions;
    }

    public void setNbPions(int nbPions) {
        this.nbPions = nbPions;
    }
}
