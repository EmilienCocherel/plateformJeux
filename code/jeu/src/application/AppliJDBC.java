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
import javafx.scene.Node;

public class AppliJDBC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Login Login;
    private FicheJoueur ficheJoueur;
    private FicheJeu ficheJeu;
    private FicheRapport ficheRapport;
    private JeuBD jeuBD;
    private JoueurBD joueurBD;
    private RapportBD rapportBD;
  	private PartieBD partieBD;
  	private MessageBD messageBD;
  	private InvitationBD invitationBD;
    private ConnexionMySQL Connexion;
    private Scene scene;
    private ApplicationAJEL ApplicationAJEL;
    private Label message;
    private FicheResultat ficheResultat;
    private GridInscrire inscrire;
    private ControleurConnexion cc;
    private BorderPane laBase;
  	private Joueur client;
    private BorderFicheJeu borderficheJeu;
    private BorderRapport rapport;

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
<<<<<<< HEAD
        this.rapportBD    = new RapportBD(this.Connexion,this);
		    this.partieBD     = new PartieBD(this.Connexion, this.jeuBD, this.joueurBD);
		    this.messageBD    = new MessageBD(this.Connexion, this.joueurBD);
=======
        this.rapportBD    = new RapportBD(this.Connexion);
    		this.partieBD     = new PartieBD(this.Connexion, this.jeuBD, this.joueurBD);
    		this.messageBD    = new MessageBD(this.Connexion, this.joueurBD);
    		this.invitationBD = new InvitationBD(this.Connexion, this.jeuBD, this.joueurBD);
>>>>>>> projet/test
        this.borderficheJeu     = null;
        this.rapport = null;
        this.message      = new Label("Vous n'êtes pas connecté");
        message.setFont(Font.font(24));
        message.setAlignment(Pos.CENTER);
		this.client = null;
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
        stage.setResizable(false);
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
        this.ApplicationAJEL.creerMenuConnexion();
        this.laBase.setCenter(new GridConnexion(this));
    }

    public void passerEnModeDeConnexion(){
        this.laBase.setCenter(new GridConnexion(this));
        // this.ApplicationAJEL.creerMenuConnexion();
    }

    public void passerEnModePartieEnCours(){
        this.ApplicationAJEL.creerMenuJoueur();
        this.laBase.setCenter(new BorderPartieEnCours(this));
    }

    public void passerEnModeMDPOublie(){
        this.laBase.setCenter(new GridForgotPassword());
    }

    public void passerEnModeAfficheJeu(JeuProfil profil){
        this.laBase.setCenter(new BorderFicheJeu(this,profil));
    }

    public void passerEnModeJeuxPossede(){
        this.laBase.setCenter(new BorderJeuxPossede(this,this.jeuBD));
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

    public void passerEnModeLireMessage(Message message){
        this.laBase.setCenter(new BorderLireMessage(this, message));
    }

    public void passerEnModePartieHistorique(){
        this.laBase.setCenter(new BorderPartieHistorique(this));
    }

    public void passerEnModeFicheDeJeu(JeuProfil profil){
      this.laBase.setCenter(new BorderFicheJeu(this,profil));
    }

    public void passerEnModeProfilUtilisateur(){
      this.laBase.setCenter(new BorderProfilUtilisateur(this));
    }

    public void passerEnModeChgmntInfo(){
      this.laBase.setCenter(new BorderChgmntInfo(this));
    }

    public void passerEnModeConsulterStatsJeux(){
      this.laBase.setCenter(new BorderConsutlerStatsJeux(this));
    }

    public void passerEnModeConsulterStatsAdversaire(){
      this.laBase.setCenter(new BorderConsulterStatsAdversaire(this));
    }


    //ADMIN
    public void passerEnModeAccueil(){
        this.ApplicationAJEL.creerMenuAdministrateur();
        this.laBase.setCenter(new BorderAccueil(this));

    }

    public void passerEnModeAjouterJeu(){
        this.laBase.setCenter(new BorderAjouterJeu(this));
   }

    public void passerEnModeGererJeu(){
        this.laBase.setCenter(new BorderGererJeu(this));
    }

   public void passerEnModeGererJeux(){
        this.laBase.setCenter(new BorderGererJeux(this,this.jeuBD));
   }

    public void passerEnModeCompte(){
        this.laBase.setCenter(new BorderCompte(this));
    }

    public void passerEnModeRapport(){
        this.laBase.setCenter(new BorderRapport(this,this.rapportBD));
    }

    public void passerEnModeRapportLire(Rapport rapport){
        this.laBase.setCenter(new BorderLireRapport(this,rapport));
    }

    public void passerEnModeRapportRediger(){
        this.laBase.setCenter(new BorderRedigerRapport(this,this.rapportBD));
    }

    public void passerEnModeStats(){
        this.laBase.setCenter(new BorderStatistiques(this));
    }

//    public void passerEnModeAide(){
//        this.laBase.setCenter(new BorderAide(this));
//    }

    public Login getLogin() {
        return Login;
    }

    public BorderFicheJeu getFicheBorderJeu(){
      return this.borderficheJeu;
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

	public MessageBD getMessageBD() {
		return this.messageBD;
	}

    public FicheJeu getFicheJeu(){
      return ficheJeu;
    }

    public RapportBD getRapportBD(){
      return rapportBD;
    }

	public InvitationBD getInvitationBD() {
		return this.invitationBD;
	}

	public PartieBD getPartieBD() {
		return this.partieBD;
	}

    public FicheRapport getFicheRapport(){
      return ficheRapport;
    }

	public Joueur getClient() {
		return this.client;
	}

	public void setClient(Joueur client) {
		this.client = client;
	}
}
