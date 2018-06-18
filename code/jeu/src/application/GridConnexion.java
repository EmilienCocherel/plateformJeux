package application;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridConnexion extends PageConnexion{

    private AppliJDBC appli;
    private TextField email, mdp;
    private String login, motdepasse;
    private String type;
    private Button seConnecterButton;
    private ControleurConnexion cc;


    public GridConnexion(AppliJDBC appli){
        super();
        this.appli = appli;
        this.cc = cc;
        Button seConnecterBouton = this.buttonType("Se connecter");



        Hyperlink lienMDP = this.lienType("Mot de passe oublié ?");
        lienMDP.setOnAction(event -> this.appli.passerEnModeMDPOublie());
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.email = new TextField("");
        this.mdp = new TextField("");

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
        seConnecterBouton.setOnAction(event -> this.seConnecterBD());


    }

    public String getLogin(){
      return this.email.getText();
    }

    public String getMdp(){
      return this.mdp.getText();
    }

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

    // public Joueur connexion() throws SQLException{
    //   return new Joueur(this.appli.getJoueurBD().seConnecter(this.email.getText(), this.mdp.getText()));
    // }

}
