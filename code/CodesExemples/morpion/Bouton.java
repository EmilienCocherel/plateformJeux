package morpion;
import javafx.scene.control.Button;

public class Bouton extends Button{
    public int ligne;
    public int colonne;
    Bouton(int ligne,int colonne){
	super();
	this.ligne=ligne;
	this.colonne=colonne;
    }
}
