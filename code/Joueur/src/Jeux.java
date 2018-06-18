import javafx.beans.property.SimpleStringProperty;

public class Jeux {

    private SimpleStringProperty nom, type, description;

    public Jeux(String nom, String type, String description){
        this.nom = new SimpleStringProperty(nom);
        this.type = new SimpleStringProperty(type);
        this.description = new SimpleStringProperty(description);
    }

    public void setNom(String nom){
        this.nom.set(nom);
    }

    public void setType(String type){
        this.type.set(type);
    }

    public void setDescription(String description){
        this.description.set(description);
    }

    public String getNom() {
        return this.nom.get();
    }

    public String getType() {
        return this.type.get();
    }

    public String getDescription() {
        return this.description.get();
    }
}
