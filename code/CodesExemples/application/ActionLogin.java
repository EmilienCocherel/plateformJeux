package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.sql.*;

class ActionLogin implements EventHandler<ActionEvent> {

    private ConnexionMySQL laConnexion;
    private Login vue;
    
    ActionLogin(Login  vue){
	this.vue=vue;
    }
    @Override
    public void handle(ActionEvent e) {
	String login=vue.getLogin();
	String bd=vue.getBD();
	String mdp=vue.getMdp();
	String serveur=vue.getServeur();
	try{
	    laConnexion=new ConnexionMySQL(serveur,bd,login,mdp);
	     vue.setConnexion(laConnexion);
	      vue.changeScene();
	} catch (ClassNotFoundException ex){
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Problème Connexion");
	    alert.setHeaderText("La connexion a échoué");
	    alert.setContentText("Le driver de connexion n'a pas été trouvé");
	    alert.showAndWait();
	} catch (SQLException ex) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Problème Connexion");
	    alert.setHeaderText("La connexion a échoué");
	    alert.setContentText(ex.getMessage());
	    alert.showAndWait();
	}
 
    }
}
