public class TypeJeu {

    private int id;
    private String nom;

    public TypeJeu(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

//    Getter et Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
