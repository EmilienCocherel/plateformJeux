package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import java.sql.*;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridInscrire extends PageConnexion{

    private AppliJDBC appli;
    private TextField nom,email,mdp,confMdp;
    private Node sInscrireNode;
    private Button sInscrireButton;
    private ControleurConnexion CC;
    // private JoueurBD joueurBD;

    public GridInscrire(AppliJDBC appli){
        super();
        this.appli = appli;
        this.CC = new ControleurConnexion(appli);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.nom = new TextField("TestNom");
        this.email = new TextField("TestPrenom");
        this.mdp = new TextField("TestMdp");
        this.confMdp = new TextField("TestTest");
        this.sInscrireNode = this.buttonType("Créer mon compte");
        this.sInscrireButton = (Button) this.sInscrireNode;

        this.add(this.title("S'inscrire"),0,0);
        this.add(this.labelTypeDroite("* : Champ obligatoire"),1,0);
        this.add(this.labelType("*Nom : "),0,1);
        this.add(this.nom,1,1);
        this.add(this.labelType("*Email : "),0,2);
        this.add(this.email,1,2);
        this.add(this.labelType("*Mot de passe : "),0,3);
        this.add(this.mdp,1,3);
        this.add(this.labelType("*Confirmer : "),0,4);
        this.add(this.confMdp,1,4);
        this.add(this.checkBoxType("J'accepte les termes d'utilisation \n et la politique de confidentialité"),1,5);
        this.add(this.sInscrireButton, 1, 6);
        this.sInscrireButton.setOnAction(new ControleurConnexion(appli));

    }

    public TextField getNom() {
      return this.nom;
    }
    public TextField getEmail() {
      return this.email;
    }
    public TextField getMdp() {
      return this.mdp;
    }
    public TextField getConfMdp() {
      return this.confMdp;
    }
    public Button getsInscrire(){
      return this.sInscrireButton;
    }

    public void insertionDeJoueur(){
      System.out.println("insertion joueur");
      try{
        this.appli.getJoueurBD().insererJoueur(this.creerJoueur());
      }
      catch (SQLException e)
      {
        System.out.println(e);
      }
    }
    public Joueur creerJoueur() throws SQLException{
      byte [] b1 = new byte[1];
      JoueurBD connexion = new JoueurBD(this.appli.getConnexion());
      return new Joueur(connexion.maxNumJoueur(), this.getNom().getText(), this.getMdp().getText(), "F".charAt(0), false, 1, b1, this.getEmail().getText(), true, false);
    }




}
