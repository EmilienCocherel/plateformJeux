package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import java.sql.*;
import java.util.Optional;

public class ActionAccesFicheJeu implements EventHandler<ActionEvent> {

	private ListeJeux jeu;
  private AppliJDBC app;


	public ActionAccesFicheJeu(ListeJeux jeu,AppliJDBC app) {
	    this.jeu = jeu ;
      this.app = app;

	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
		if (this.jeu.getNom().equals("mastermind")){

    }
	}
}
