public class Jeu {

    private int id;
    private String nom, regle;
    private Byte jar;
    private boolean actif;
    private String type;

    public Jeu(int id, String nom, String regle, Byte jar, boolean actif, String type) {
        this.id = id;
        this.nom = nom;
        this.regle = regle;
        this.jar = jar;
        this.actif = actif;
        this.type = type;
    }

    public void start(){

    }

//    Getter et Setter

    public void setActif(boolean b){ // À IMPLÉMENTER

    }

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

    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }

    public Byte getJar() {
        return jar;
    }

    public void setJar(Byte jar) {
        this.jar = jar;
    }

    public boolean isActif() {
        return actif;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
