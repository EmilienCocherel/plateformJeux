package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import java.sql.*;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.CheckBox;


public class GridInscrire extends PageConnexion{

    private AppliJDBC appli;
    private TextField nom,email,mdp,confMdp;
    private CheckBox condiUse;
    private Node sInscrireNode;
    private Button sInscrireButton;
    private ControleurConnexion cc;
    private boolean verifie, supression;
    private Label error;
    // private JoueurBD joueurBD;

    public GridInscrire(AppliJDBC appli, ControleurConnexion cc){
        super();
        this.appli = appli;
        this.cc = cc;
        this.verifie = false;
        this.supression = false;
        // this.CC = new ControleurConnexion(appli);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.nom = new TextField("TestNom");
        this.email = new TextField("TestPrenom");
        this.mdp = new TextField("TestMdp");
        this.confMdp = new TextField("TestTest");
        this.error = this.labelType("");
        this.condiUse = this.checkBoxType("J'accepte les termes d'utilisations");
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
        this.add(this.condiUse,1,5);
        this.add(this.sInscrireButton, 1, 6);
        ActionInsererJoueur insere = new ActionInsererJoueur(this);
        this.sInscrireButton.setOnAction(insere);

    }

    public TextField getNom() {
      return this.nom;
    }

    public Label getError(){
      return this.error;
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

    public boolean insertionDeJoueur() throws EmailInvalideException, SQLException, MdpInvalideException, CondiUseException{
        Boolean res = true;
        boolean mailInvalide = false;
        String sauvegardeMail = this.getEmail().getText();
        String sauvegardeMdp = this.getMdp().getText();
        String sauvegardeConfMdp = this.getConfMdp().getText();
        String sauvegardePseudo = this.getNom().getText();
        if (!this.verifierPseudoDejaInscrit()){
          this.getChildren().remove(this.nom);
          this.add(this.nom = new TextField(sauvegardePseudo),1,1);
          if (this.isValid(this.getEmail().getText())){
            if (!this.verifierEmailDejaInscrit()){
              mailInvalide = false;
              this.getChildren().remove(this.email);
              this.add(this.email = new TextField(sauvegardeMail),1,2);
              res = true;
              }
              else{
                System.out.println("Email utilisé : "+this.getEmail().getText());
                this.getChildren().remove(this.error);
                this.error = this.labelType("Email déjà utilisé");
                this.getEmail().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
                this.add(this.error,1,7);
              }
            if (this.getMdp().getText().equals(this.getConfMdp().getText()) && !mailInvalide){
              this.getChildren().remove(this.error);
              this.getChildren().remove(this.mdp);
              this.getChildren().remove(this.confMdp);
              this.add(this.mdp = new TextField(sauvegardeMdp),1,3);
              this.add(this.confMdp = new TextField(sauvegardeConfMdp),1,4);
              res = false;
              if (this.condiUse.isSelected()){
                this.getChildren().remove(this.error);
                this.appli.getJoueurBD().insererJoueur(this.creerJoueur());
                this.appli.passerEnModeConnexion();
              }
              else{
                this.getChildren().remove(this.error);
                this.error = this.labelType("Acceptez les conditions d'utilisations");
                this.add(this.error,1,7);
                throw new CondiUseException("Veuillez accepter les conditions d'utilisations");
              }
            }
            else{
              this.getChildren().remove(this.error);
              this.error = this.labelType("Mot de passe mal recopié");
              this.add(this.error,1,7);
          }
        }
          else{
            if (this.getMdp().getText().equals(this.getConfMdp().getText())){
            this.getEmail().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
            this.getChildren().remove(this.error);
            this.error = this.labelType("Veuillez rentrer un email valide");
            this.add(this.error,1,7);
            mailInvalide = true;
            throw new EmailInvalideException("Email invalide");
            }
            else{
              this.getChildren().remove(this.error);
              this.error = this.labelType("Mauvais mail ET mot de passe");
              this.getEmail().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
              this.getMdp().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
              this.getConfMdp().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
              this.add(this.error,1,7);
              throw new MdpInvalideException("Mot de passe mal recopié");
            }
          }
        }
        else {
          this.getNom().requestFocus();
          System.out.println("Pseudo utilisé : "+this.getNom().getText());
          this.getChildren().remove(this.error);
          this.getNom().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
          this.error = this.labelType("Identifiant déjà utilisé");
          this.add(this.error,1,7);
        }
        return res;
      }

    public boolean verifierEmailDejaInscrit() throws SQLException, EmailInvalideException{
      boolean inscrit = false;
      if (this.isValid(this.getEmail().getText())){
        inscrit = this.appli.getJoueurBD().mailDejaInscrit(this.getEmail().getText());
      }
      return inscrit;
    }

    public boolean verifierPseudoDejaInscrit() throws SQLException{

        return this.appli.getJoueurBD().joueurDejaInscrit(this.getNom().getText());

    }


    public Joueur creerJoueur() throws SQLException, EmailInvalideException{
      byte [] b1 = new byte[1];
      if (this.isValid(this.getEmail().getText())){
        return new Joueur(this.appli.getJoueurBD().maxNumJoueur(), this.getNom().getText(), this.getMdp().getText(), "F".charAt(0), false, 1, b1, this.getEmail().getText(), true, false);
      }
      else{
        throw new EmailInvalideException("Email invalide");
      }
    }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    @Override
    public boolean equals(Object o){
      if (o == null){
        return false;
      }
      else{
        return this.getMdp().equals(this.getConfMdp());
      }
    }


}
