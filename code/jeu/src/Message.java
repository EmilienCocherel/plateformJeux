import java.util.Date;

public class Message {

    private int id;
    private Date date;
    private String contenu;
    private boolean lu;

    public Message(int id, Date date, String contenu, boolean lu) {
        this.id = id;
        this.date = date;
        this.contenu = contenu;
        this.lu = lu;
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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public boolean isLu() {
        return lu;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }
}
