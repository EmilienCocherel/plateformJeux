package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import java.sql.*;
import java.util.Optional;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ActionMettreAJourMonCompteJoueur implements EventHandler<ActionEvent> {

	private BorderChgmntInfo border;


	public ActionMettreAJourMonCompteJoueur(BorderChgmntInfo border) {
	    this.border = border;

	}

	@Override
	public void handle(ActionEvent actionEvent) {
		try{
			System.out.println("handle");
			this.border.mettreAJourProfil();
		}

		catch(SQLException e){
			System.out.println(e);
		}
	}
}
