package application;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.geometry.Pos;
import javafx.collections.*;
import java.util.ArrayList;
import java.net.*;
import javafx.application.Application;
import java.sql.SQLException;
import java.util.Date;


public class ChoixJeu extends GridPane {
    private ConnexionMySQL laConnexion=null;
    private ComboBox<String> lesJeux;
    private ChargeurJeu chargeur;
    TextField numJoueur,numPartie;
	private PartieBD partieBD;
	private JeuBD jeuBD;
	private JoueurBD joueurBD;

    public ChoixJeu(ConnexionMySQL laConnexion, PartieBD partieBD, JeuBD jeuBD, JoueurBD joueurBD) {
    	super();
		this.partieBD = partieBD;
		this.jeuBD = jeuBD;
		this.joueurBD = joueurBD;
    	this.chargeur = new ChargeurJeu("./jar");
    	this.laConnexion=laConnexion;
    	GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);

    	Label lNomJoueur= new Label("Numéro du Joueur");
    	numJoueur = new TextField("1");
    	Label lNumPartie= new Label("Numéro de la partie");
    	numPartie = new TextField("1");

    	Label lListeJeux= new Label("Choisissez votre jeu");

    	lesJeux = new ComboBox<String>();
    	lesJeux.setEditable(false);
    	ArrayList <String> lj=laConnexion.getJeux();
    	ObservableList<String> jeux =FXCollections.observableArrayList (lj);
    	lesJeux.setItems(jeux);
    	lesJeux.setOnAction(new ActionLesJeux(this,laConnexion));

    	this.add(lNomJoueur,0,0);
    	this.add(numJoueur,1,0);
    	this.add(lNumPartie,0,1);
    	this.add(numPartie,1,1);
    	this.numPartie.setOnAction(new ActionLesJeux(this,laConnexion));

    	this.add(lListeJeux,0,2);
    	this.add(lesJeux,1,2);
    }


	public void chargerJeu(String nomJeu) {
		Jeu jeu=null;
       String nomClasse=""+nomJeu.charAt(0);
       nomClasse=nomClasse.toUpperCase();
       nomClasse+=nomJeu.substring(1);

		int idJoueur = Integer.parseInt(this.numJoueur.getText());
		Joueur joueur1, joueur2 = new Joueur(2);
		try {
			joueur1 = joueurBD.rechercherJoueurParNum(idJoueur);
		} catch (SQLException ex) {
			joueur1 = new Joueur(idJoueur);
			try {
				joueurBD.insererJoueur(joueur1);
			} catch (SQLException e) {
				System.out.println("merde (joueur1)");
			}
		}

		JeuProfil jeuP;
		try {
			jeuP = jeuBD.rechercherJeuParNom(nomJeu);

			Partie partie;
			try {
				partie = partieBD.rechercherPartieParNum(Integer.parseInt(this.numPartie.getText()));
			} catch (SQLException ex) {
				partie = new Partie(partieBD.maxId()+1, new Date(), 1, "", jeuP, joueur1, 0, joueur2, 0);
				try {
					partieBD.creerPartie(partie);
				} catch (SQLException e) {
					System.out.println("merde (partie)");
				}
			}

			Label lListeJeux= new Label("Choisissez votre jeu");
			try {
				//jeu = this.chargeur.chargerJeu(nomJeu+".jar",nomJeu+".LeJeu");
				this.chargeur.chargerJeu(nomJeu+".jar",nomJeu+"."+nomClasse, partie, partieBD, idJoueur);
			}
			catch (ClassNotFoundException ex1) {
				System.out.println("Exception1 found for " + ex1.toString());
			}
			catch (InstantiationException ex1) {
				System.out.println("Exceptio2 found for " + ex1.toString());
			}
			catch (IllegalAccessException ex1) {
				System.out.println("Exception3 found for " + ex1.toString());
			}
			catch (MalformedURLException ex) {
				System.out.println("Probleme url " + ex.toString());
			}
			Application j;
			if (laConnexion.estUnePartie(Integer.parseInt(numPartie.getText()))){
				//jeu.jouerCoup(Integer.parseInt(numPartie.getText()),Integer.parseInt(numJoueur.getText()),new Partage(this.laConnexion,this));
			} else{
				//jeu.creerPartie(1,1,2, new Partage(this.laConnexion,this));
				//this.add(j,0,3);
			}
		} catch (SQLException ex) {
			System.out.println("die");
		}
  }
}
