import java.util.Date;
import java.util.Map;

public class Partie {

    private int id;
    private Date debut;
    private int numEtape;
    private String etat;
    private Map<Joueur,Integer> dicoScore;

    public Partie(int id, Date debut, int numEtape, String etat, Map<Joueur, Integer> dicoScore) {
        this.id = id;
        this.debut = debut;
        this.numEtape = numEtape;
        this.etat = etat;
        this.dicoScore = dicoScore;
    }

//    Getter et Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getNumEtape() {
        return numEtape;
    }

    public void setNumEtape(int numEtape) {
        this.numEtape = numEtape;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Map<Joueur, Integer> getDicoScore() {
        return dicoScore;
    }

    public void setDicoScore(Map<Joueur, Integer> dicoScore) {
        this.dicoScore = dicoScore;
    }
}
