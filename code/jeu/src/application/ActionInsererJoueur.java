package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ActionInsererJoueur implements EventHandler<ActionEvent> {

	private GridInscrire grid;


	public ActionInsererJoueur(GridInscrire grid) {
	    this.grid = grid ;

	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
		try{
			this.grid.insertionDeJoueur();
		}
		catch(EmailInvalideException e){
			System.out.println("Exception email");
		}
		catch(SQLException e){
			System.out.println("SQL exception");
		}
	}
}
