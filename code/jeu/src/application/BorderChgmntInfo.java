package application;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Hyperlink;
import javafx.scene.Node;
import java.sql.*;

public class BorderChgmntInfo extends PageJoueur{

    private AppliJDBC app;
    private String sexe;
    private TextField pseudoJoueur, motDePasseJoueur;
    private ComboBox infoSexe;
    private Hyperlink estActuellementAbonne;
    private Button sauvegarder;

    public BorderChgmntInfo(AppliJDBC app) {
        super();
        this.app = app;
        this.pseudoJoueur = new TextField(this.app.getClient().getPseudo());
        this.motDePasseJoueur = new TextField(this.app.getClient().getMotdepasse());
        this.infoSexe = new ComboBox();
        this.infoSexe.getItems().setAll("Homme","Femme","Autre");
        this.sexe = verifierSexe();
        this.infoSexe.setValue(sexe);
        this.estActuellementAbonne = new Hyperlink("");

        this.sauvegarder = this.buttonTypePageJoueur("Sauvegarder");
        // sauvegarder.setOnAction(event -> this.app.passerEnModeProfilUtilisateur());

        Button annuler = this.buttonTypePageJoueur("Annuler");
        annuler.setOnAction(event -> this.app.passerEnModeProfilUtilisateur());

        ButtonBar barBot = this.buttonBarTypePageJoueur(sauvegarder,annuler);

        ActionMettreAJourMonCompteJoueur mattremaj = new ActionMettreAJourMonCompteJoueur(this);
        this.sauvegarder.setOnAction(mattremaj);

        GridPane infoCentre = new GridPane();




        infoCentre.add(this.labelGrosPageJoueur("Pseudo : "),0,0);
        infoCentre.add(this.pseudoJoueur,1,0);
        infoCentre.add(this.labelGrosPageJoueur("Sexe : "),0,1);
        infoCentre.add(this.infoSexe,1,1);
        infoCentre.add(this.labelGrosPageJoueur("Mot de passe : "),0,2);
        infoCentre.add(this.motDePasseJoueur,1,2);
        infoCentre.add(this.labelGrosPageJoueur("Prenium : "),0,3);
        infoCentre.add(this.verifierAbo(),1,3);
        infoCentre.setPadding(new Insets(30, 30, 10, 10));




        this.setCenter(infoCentre);
        this.setBottom(barBot);
        this.setRight(this.imageTypePageJoueur());
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);



    }

    public String verifierSexe(){
      String sexeJoueur = this.app.getClient().getSexe() + "";
      if (sexeJoueur.equals("M")){
        this.sexe = "Homme";
      }
      else if(sexeJoueur.equals("F")){
        this.sexe = "Femme";
      }
      else{
        this.sexe = "Autre";
      }
      return this.sexe;
    }

    // public String verifierPseudo(){
    //   String pseudo = this.app.getClient().getPseudo();
    //   // this.pseudoJoueur.setText(this.app.getClient().getPseudo());
    //   return pseudo;
    // }
    //
    // public String verifierMotDePasse(){
    //   String mdp = this.app.getClient().getMotdepasse();
    //   // this.motDePasseJoueur.setText(this.app.getClient().getMotdepasse());
    //   return mdp;
    // }

    public Hyperlink verifierAbo(){
      if (this.app.getClient().isAbonne()){
        this.estActuellementAbonne = new Hyperlink("Vous êtes actuellement un abonné, mais pourquoi pas un deuxième abonnement ?");
      }
      else{
        this.estActuellementAbonne = new Hyperlink("Acheter un compte prenium");
      }
      return this.estActuellementAbonne;
    }


    public boolean mettreAJourProfil() throws SQLException{
        Boolean res = true;
        String sauvegardePseudo = this.pseudoJoueur.getText();
        String sauvegardeMdp = this.motDePasseJoueur.getText();
        Joueur nj = this.majJoueur();
        this.app.getJoueurBD().mettreAJourMonProfilJoueur(nj);
        this.app.setFicheJoueur(new FicheJoueur(this.app));
        System.out.println("mettreAJourProfil");

        return res;
    }

    public Joueur majJoueur() throws SQLException{
      byte [] b1 = new byte[1];
      int id = this.app.getClient().getIdentifiant();
      String nom = this.pseudoJoueur.getText();
      String mdp = this.motDePasseJoueur.getText();
      String sexe = this.infoSexe.getValue().toString();
      String nSexe = "";
      if (sexe.equals("Homme")){
        nSexe = "H";
      }
      else if (sexe.equals("Femme")){
        nSexe = "F";
      }
      else{
        nSexe = "A";
      }
      String email = this.app.getClient().getEmailJo();
      System.out.println("majJoueur");
      return new Joueur(id, nom, mdp, nSexe.charAt(0), false, 1, b1, email, true, false);
    }

    // public void setSexe{
    //
    // }


}
