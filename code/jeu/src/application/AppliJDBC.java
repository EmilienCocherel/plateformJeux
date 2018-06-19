package application;

import java.sql.*;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppliJDBC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Login Login;
    private FicheJoueur ficheJoueur;
    private FicheJeu ficheJeu;
    private FicheRapport ficheRapport;
    private ChoixJeu choixJeu;
    private JeuBD jeuBD;
    private JoueurBD joueurBD;
    private RapportBD rapportBD;
	  private PartieBD partieBD;
    private ConnexionMySQL Connexion;
    private Scene scene;
    private ApplicationAJEL ApplicationAJEL;
    private Label message;
    private FicheResultat ficheResultat;
    private GridInscrire inscrire;
    private ControleurConnexion cc;

    private BorderPane laBase;

    public void init() {
        try {
            this.cc = new ControleurConnexion(this);
            this.Connexion = new ConnexionMySQL();
            this.laBase = new BorderPane();
            this.ApplicationAJEL = new ApplicationAJEL(this);
            // this.inscrire = new GridInscrire(this,this.cc);
        }catch (ClassNotFoundException ex){
            System.out.println("Driver MySQL non trouvé!!!");
            System.exit(1);
        }
        this.Login        = new Login(this);
        try {
        this.Connexion.connecter(this.Login.getNomServeur(),this.Login.getNomBD(),this.Login.getLogin(),this.Login.getMotDePasse());
        }
        catch (SQLException e){
          System.out.print("PB de connexion"+e);
        }
        this.ficheJoueur  = new FicheJoueur(this);
        this.ficheJeu     = new FicheJeu(this);
        this.ficheRapport = new FicheRapport(this);
        //this.choixJeu     = new ChoixJeu(this.Connexion);
        this.ficheResultat= new FicheResultat(this);
        this.jeuBD        = new JeuBD(this.Connexion);
        this.joueurBD     = new JoueurBD(this.Connexion);
        this.rapportBD    = new RapportBD(this.Connexion);
		    this.partieBD     = new PartieBD(this.Connexion, this.jeuBD, this.joueurBD);
        this.message      = new Label("Vous n'êtes pas connecté");
        message.setFont(Font.font(24));
        message.setAlignment(Pos.CENTER);
    }

    public ConnexionMySQL getConnexionMySql(){
      return this.Connexion;
    }


    @Override
    public void start(Stage stage) {
        // VBox fp=new VBox(5);
        // fp.setAlignment(Pos.TOP_CENTER);
        // ApplicationAJEL=new ApplicationAJEL(this);
        // fp.getChildren().addAll(this.ApplicationAJEL,message);
        // this.scene= new Scene(fp,500,500);
        // primaryStage.setScene(this.scene);
        // primaryStage.setTitle("Application AJEL");
        // primaryStage.show();
        this.ApplicationAJEL.creerMenuConnexion();
        this.ApplicationAJEL.colorerLaBase();


        this.scene = new Scene(this.laBase,1000,800);


        stage.setScene(this.scene);
        stage.setTitle("AJEL");
        stage.show();
    }

    public BorderPane getLaBase(){
      return this.laBase;
    }
    // Anicen fichier AJEL.java
    public void passerEnModeInscription(){
        this.laBase.setCenter(new GridInscrire(this,this.cc));
    }

    public void passerEnModeConnexion(){
        this.ApplicationAJEL = new ApplicationAJEL(this);
        // this.ApplicationAJEL.creerMenuConnexion();
        this.laBase.setCenter(new GridConnexion(this));
    }

    public void passerEnModePartieEnCours(){
        // this.ApplicationAJEL.creerMenuJoueur();
        this.laBase.setCenter(new BorderPartieEnCours(this));
    }

    public void passerEnModeMDPOublie(){
        this.laBase.setCenter(new GridForgotPassword());
    }

    public void passerEnModeJoueur(){
        this.ApplicationAJEL.creerMenuJoueur();
    }

    public void passerEnModeJeuxPossede(){
        this.laBase.setCenter(new BorderJeuxPossede(this));
    }

    public void passerEnModeJeuxBoutique(){
        this.laBase.setCenter(new BorderJeuxBoutique(this));
    }

    public void passerEnModeInvitations(){
        this.laBase.setCenter(new BorderInvitations(this));
    }

    public void passerEnModeMesAmis(){
        this.laBase.setCenter(new BorderMesAmis(this));
    }

    public void passerEnModeMessagerieRecus(){
        this.laBase.setCenter(new BorderMessagerieRecus(this));
    }

    public void passerEnModeMessagerieEnvoyes(){
        this.laBase.setCenter(new BorderMessagerieEnvoyes(this));
    }

    public void passerEnModeRedigerMessage(){
        this.laBase.setCenter(new BorderRedigerMessage(this));
    }

    public void passerEnModePartieHistorique(){
        this.laBase.setCenter(new BorderPartieHistorique(this));
    }

    public Login getLogin() {
        return Login;
    }

    public void connexionReussie(){
        this.message.setText("Vous êtes connecté");
        BorderPane fp=((BorderPane)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
        // this.ApplicationAJEL.connecter();
    }

    public void deconnexionReussie(){
        this.message.setText("Vous êtes déconnecté");
        BorderPane fp=((BorderPane)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
        this.ApplicationAJEL.deconnecter();
    }
    public void showFenetreConnexion(){
        BorderPane fp=((BorderPane)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.Login);
    }
    public void showFicheJoueur(){
        BorderPane fp=((BorderPane)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.ficheJoueur);
    }

    public void showFicheJeu(){
      BorderPane fp =((BorderPane)scene.getRoot());
      fp.getChildren().remove(1);
      fp.getChildren().addAll(this.ficheJeu);
    }

    public void showFicheRapport(){
      BorderPane fp =((BorderPane)scene.getRoot());
      fp.getChildren().remove(1);
      fp.getChildren().addAll(this.ficheRapport);
    }

    public void showChoixJeu(){
      BorderPane fp =((BorderPane)scene.getRoot());
      fp.getChildren().add(this.choixJeu=new ChoixJeu(this.Connexion,this.partieBD,this.jeuBD,this.joueurBD));
      fp.getChildren().remove(1);
      // fp.getChildren().addAll(this.choixJeu);
    }

    public void showFicheResultat(String resultat){
        this.ficheResultat.setTexte(resultat);
        BorderPane fp=((BorderPane)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.ficheResultat);
    }

    public void setMessage(String message){
        this.message.setText(message);
        BorderPane fp=((BorderPane)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
    }

    public ConnexionMySQL getConnexion() {
        return Connexion;
    }

    public JoueurBD getJoueurBD() {
        return joueurBD;
    }

    public FicheJoueur getFicheJoueur() {
        return ficheJoueur;
    }

    public JeuBD getJeuBD(){
      return jeuBD;
    }

    public FicheJeu getFicheJeu(){
      return ficheJeu;
    }

    public RapportBD getRapportBD(){
      return rapportBD;
    }

    public FicheRapport getFicheRapport(){
      return ficheRapport;
    }

    public ChoixJeu getChoixJeu(){
      return choixJeu;
    }
}
