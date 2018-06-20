package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import java.sql.*;
import java.util.Optional;

public class ActionAccesFicheJeu implements EventHandler<ActionEvent> {

	private ListeJeux jeux;
  private AppliJDBC app;
  private JeuProfil jeuProfil;


	public ActionAccesFicheJeu(ListeJeux jeux, AppliJDBC app) {
	    this.jeux = jeux;
      this.app = app;
      this.jeuProfil = null;

	}

	@Override
	public void handle(ActionEvent actionEvent) {
		if (this.jeux.getNom().equals("mastermind")){
      try{
        this.jeuProfil = this.app.getJeuBD().rechercherJeuParNom(this.jeux.getNom());
      }
      catch(SQLException e){
        System.out.println("Erreur SQL");
      }
    }
    if(this.jeux.getNom().equals("connect4")){
      try{
        this.jeuProfil = this.app.getJeuBD().rechercherJeuParNom(this.jeux.getNom());
      }
      catch(SQLException e){
        System.out.println("Erreur SQL");
      }
    // else{
    //   System.out.println("Pas de jeu");
    // }
	  }
  }
}
