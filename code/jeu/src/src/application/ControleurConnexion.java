package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ControleurConnexion implements EventHandler<ActionEvent>{
    AppliJDBC AppliJDBC;

    public ControleurConnexion(AppliJDBC AppliJDBC) {
        this.AppliJDBC=AppliJDBC;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Login l=AppliJDBC.getLogin();
        ConnexionMySQL Connexion=AppliJDBC.getConnexion();

        try {
            Connexion.connecter(l.getNomServeur(),l.getNomBD(),l.getLogin(), l.getMotDePasse());
	    if (Connexion.isConnecte())
		AppliJDBC.connexionReussie();
	    else
		AppliJDBC.setMessage("Vous n'êtes pas connecté");
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Echec !!!! ");
			alert.setResizable(true);
			alert.setWidth(500);
			alert.setHeaderText("Echec de la connexion au serveur");
			alert.setContentText("Voici le message envoyé par le serveur\n"+e.getMessage());
			alert.showAndWait();
			AppliJDBC.setMessage("Vous n'êtes pas connecté");
        }

    }
}
