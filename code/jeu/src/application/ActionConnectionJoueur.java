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
public class ActionConnectionJoueur implements EventHandler<ActionEvent> {

	private GridConnexion grid;


	public ActionConnectionJoueur(GridConnexion grid) {
	    this.grid = grid ;

	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
		try{
			this.grid.connexionJoueur();
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
}
