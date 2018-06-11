import java.util.Date;

public class Invitation {

    private int id;
    private Date date;
    private int etat;

    public Invitation(int id, Date date) {
        this.id = id;
        this.date = date;
    }

//    Getter et Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
