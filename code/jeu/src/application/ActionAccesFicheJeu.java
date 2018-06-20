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
public class ActionAccesFicheJeu implements EventHandler<ActionEvent> {

	private BorderFicheJeu fiche;


	public ActionAccesFicheJeu(BorderFicheJeu fiche) {
	    this.fiche = fiche ;

	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
		// try{
		// 	this.fiche.connexionJoueur();
		// }
		// catch(SQLException e){
		// 	System.out.println(e);
		// }
	}
}
