package application;

import java.io.*;
import java.net.*;
import javafx.scene.control.Button;
import java.sql.SQLException;
import java.util.Date;
import java.net.MalformedURLException;

public class BoutonJouer extends Button{
  private Jeu jeu;
  private ConnexionMySQL laConnexion=null;
  private String nomJeu;
  private String nomClasse;
  private String nomJar;
  private PartieBD partieBD;
  private JeuBD jeuBD;
  private JoueurBD joueurBD;
  private int idJoueur;
  private ChargeurJeu chargeur;

  public BoutonJouer(ConnexionMySQL laConnexion,String nomJeu,String nomClasse, String nomJar, PartieBD partieBD, JeuBD jeuBD, JoueurBD joueurBD, int idJoueur){
    super();
    this.jeu=jeu;
    this.nomJeu=nomJeu;
    this.nomClasse=nomClasse;
    this.nomJar=nomJar;
    this.partieBD=partieBD;
    this.jeuBD=jeuBD;
    this.joueurBD=joueurBD;
    this.chargeur = new ChargeurJeu("./jar");
    try {
      this.jeu = ((Jeu) Class.forName(nomClasse).newInstance());
    }
    catch(ClassNotFoundException e){
      System.out.println("Classe non trouvée");
    }
    catch(InstantiationException e){
      System.out.println("Problème d'instanciation");
    }
    catch(IllegalAccessException e){
      System.out.println("Accès interdit");
    }
    this.setText("Jouer");
    ActionLesJeux actionLesJeux = new ActionLesJeux(this);
    this.setOnAction(actionLesJeux);
  }

  public void chargerJeu() {
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
				partie = partieBD.rechercherPartieParNum(1);
			} catch (SQLException ex) {
				partie = new Partie(partieBD.maxId()+1, new Date(), 1, "", jeuP, joueur1, 0, joueur2, 0);
				try {
					partieBD.creerPartie(partie);
				} catch (SQLException e) {
					System.out.println("merde (partie)");
				}
			}
			try {
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
		}catch(SQLException ex){
      System.out.println("sql exception");
    }
  }
}
