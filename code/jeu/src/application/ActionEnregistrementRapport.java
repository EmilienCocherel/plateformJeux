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
public class ActionEnregistrementRapport implements EventHandler<ActionEvent> {

	private BorderRedigerRapport rapport;
	private AppliJDBC app;


	public ActionEnregistrementRapport(BorderRedigerRapport r,AppliJDBC app) {
	    this.rapport = r ;
			this.app = app;

	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
		try{
			this.rapport.ajouterRapport();
			this.app.passerEnModeRapport();
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
}
