package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

class ActionLesJeux implements EventHandler<ActionEvent> {

    private ConnexionMySQL laConnexion;
    private ChoixJeu vue;
    
    ActionLesJeux(ChoixJeu  vue, ConnexionMySQL laConnexion){
	this.vue=vue;
	this.laConnexion=laConnexion;
    }
    @Override
    public void handle(ActionEvent e) {
	ComboBox c=(ComboBox) e.getSource();
	String jeu=(String)c.getValue();
	vue.chargerJeu(jeu);
    }
}
