package application;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridConnexion extends PageConnexion{

    private AppliJDBC appli;
    private TextField email;
    private PasswordField mdp;
    private String login, motdepasse;
    private String type;
    private Button seConnecterButton;
    private ControleurConnexion cc;
    private Label error;


    public GridConnexion(AppliJDBC appli){
        super();
        this.appli = appli;
        this.cc = cc;

        Button seConnecterBouton = this.buttonType("Se connecter");



        Hyperlink lienMDP = this.lienType("Mot de passe oublié ?");
        lienMDP.setOnAction(event -> this.appli.passerEnModeMDPOublie());
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.email = new TextField("mario@gmail.com");
        this.mdp = new PasswordField();
        this.error = this.labelType("");

        this.add(this.title("Connexion"), 0, 0);
        this.add(this.labelType("Email : "), 0, 1);
        this.add(email,1,1);
        this.add(this.labelType("Mot de passe : "), 0, 2);
        this.add(mdp,1,2);
        this.add(this.checkBoxType("Enregistrer mot de passe"), 1, 3);
        this.add(this.labelType(""), 0, 4);
        this.add(seConnecterBouton, 1, 5);
        this.add(lienMDP, 1, 6);

        // this.seConnecterButton.setOnAction(this.cc);
        // this.seConnecterButton.setOnAction(event -> this.seConnecterBD());
        ActionConnectionJoueur action = new ActionConnectionJoueur(this);
        seConnecterBouton.setOnAction(action);


    }

    public TextField getEmail(){
      return this.email;
    }

    public PasswordField getMdp(){
      return this.mdp;
    }

    public Label getError(){
      return this.error;
    }

    public boolean connexionJoueur() throws SQLException{
        Boolean res = true;
        boolean mailInvalide = false;
        String sauvegardeMail = this.getEmail().getText();
        String sauvegardeMdp = this.getMdp().getText();
        if (this.getEmail().getText().equals("")){
          System.out.println("Rentrer un email.");
          this.getChildren().remove(this.error);
          this.error = this.labelType("Veuillez rentrer un email");
          this.add(this.error,1,7);
          res = false;
        }
        else{
          if (this.verifierEmailDansLaBase()){
            this.getChildren().remove(this.email);
            this.add(this.email = new TextField(sauvegardeMail), 1, 1);
            // this.email.isResizable(false);
            if (this.verifierMDPInvalide()){
              if (this.verifierJoueurActif()){
                if(this.verifierAdmin()){
                  this.appli.passerEnModeAccueil();
                  res = true;
                }
                else{
                  this.appli.passerEnModePartieEnCours();
                  res = true;
                }
              }
              else{   // est inactif
                System.out.println("Le compte est inactif pour le moment.");
                this.getChildren().remove(this.error);
                this.error = this.labelType("Le compte est inactif");
                this.add(this.error,1,7);
                res = false;
              }
            }
            else{ // mot de passe invalide
              System.out.println("Mot de passe incorrect");
              res = false;
              this.getChildren().remove(this.error);
              this.error = this.labelType("Email et/ou mot de passe invalide(s)");
              this.add(this.error,1,7);
            }
          }
          else{ // email pas dans la base de données
            System.out.println("Ce compte est inconnu");
            res = false;
            this.getChildren().remove(this.error);
            this.error = this.labelType("Ce compte est iconnu");
            this.add(this.error,1,7);
          }
        }
        return res;
    }


        //   this.getChildren().remove(this.nom);
        //   this.add(this.nom = new TextField(sauvegardePseudo),1,1);
        //   if (this.isValid(this.getEmail().getText())){
        //     if (!this.verifierEmailDejaInscrit()){
        //       mailInvalide = false;
        //       this.getChildren().remove(this.email);
        //       this.add(this.email = new TextField(sauvegardeMail),1,2);
        //       res = true;
        //       }
        //       else{
        //         System.out.println("Email utilisé : "+this.getEmail().getText());
        //         this.getChildren().remove(this.error);
        //         this.error = this.labelType("Email déjà utilisé");
        //         this.getEmail().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
        //         this.add(this.error,1,7);
        //       }
        //     if (this.getMdp().getText().equals(this.getConfMdp().getText()) && !mailInvalide){
        //       this.getChildren().remove(this.error);
        //       this.getChildren().remove(this.mdp);
        //       this.getChildren().remove(this.confMdp);
        //       this.add(this.mdp = new TextField(sauvegardeMdp),1,3);
        //       this.add(this.confMdp = new TextField(sauvegardeConfMdp),1,4);
        //       res = false;
        //       if (this.condiUse.isSelected()){
        //         this.getChildren().remove(this.error);
        //         this.appli.getJoueurBD().insererJoueur(this.creerJoueur());
        //         this.appli.passerEnModeConnexion();
        //       }
        //       else{
        //         this.getChildren().remove(this.error);
        //         this.error = this.labelType("Acceptez les conditions d'utilisations");
        //         this.add(this.error,1,7);
        //         throw new CondiUseException("Veuillez accepter les conditions d'utilisations");
        //       }
        //     }
        //     else{
        //       this.getChildren().remove(this.error);
        //       this.error = this.labelType("Mot de passe mal recopié");
        //       this.add(this.error,1,7);
        //   }
        // }
        //   else{
        //     if (this.getMdp().getText().equals(this.getConfMdp().getText())){
        //     this.getEmail().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
        //     this.getChildren().remove(this.error);
        //     this.error = this.labelType("Veuillez rentrer un email valide");
        //     this.add(this.error,1,7);
        //     mailInvalide = true;
        //     throw new EmailInvalideException("Email invalide");
        //     }
        //     else{
        //       this.getChildren().remove(this.error);
        //       this.error = this.labelType("Mauvais mail ET mot de passe");
        //       this.getEmail().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
        //       this.getMdp().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
        //       this.getConfMdp().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
        //       this.add(this.error,1,7);
        //       throw new MdpInvalideException("Mot de passe mal recopié");
        //     }
        //   }
        // }
        // else {
        //   this.getNom().requestFocus();
        //   System.out.println("Pseudo utilisé : "+this.getNom().getText());
        //   this.getChildren().remove(this.error);
        //   this.getNom().setStyle("-fx-border-color: red ; -fx-border-width: 1px ; -fx-text-fill: red;");
        //   this.error = this.labelType("Identifiant déjà utilisé");
        //   this.add(this.error,1,7);
        // }
      //   return res;
      // }


    public boolean seConnecterBD(){
      try{
        System.out.println("Connexion réussie");
        this.appli.getJoueurBD().seConnecter("'"+this.email.getText()+"'","'"+this.mdp.getText()+"'");
        return true;
      }
      catch (SQLException e)
      {
        System.out.println(e);
        return false;
      }
    }

    public boolean verifierAdmin() throws SQLException{

        return this.appli.getJoueurBD().estUnAdmin(this.getEmail().getText());

    }
    public boolean verifierJoueurActif() throws SQLException{

        return this.appli.getJoueurBD().estUnActif(this.getEmail().getText());

    }
    public boolean verifierEmailDansLaBase() throws SQLException{

        return this.appli.getJoueurBD().emailDansLaBase(this.getEmail().getText());

    }
    public boolean verifierMDPInvalide() throws SQLException{

        return this.appli.getJoueurBD().motDePasseInvalideConnection(this.getEmail().getText(),this.getMdp().getText());

    }
    // public Joueur connexion() throws SQLException{
    //   return new Joueur(this.appli.getJoueurBD().seConnecter(this.email.getText(), this.mdp.getText()));
    // }

}
