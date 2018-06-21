package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import java.sql.SQLException;
import javafx.stage.Stage;

public class BorderLireRapport extends PageAdmin {

    private AppliJDBC app;
    private Label auteur,objet,sujet,date;
    private TextArea tMessage;
    private Rapport rapp;
    private JoueurBD joueurBD;

    BorderLireRapport(AppliJDBC app,Rapport rap,JoueurBD joueurBD){
        super();
        this.app = app;
        this.rapp = rap;
        this.joueurBD = joueurBD;

        GridPane grid = new GridPane();

        Button bAccueil = this.buttonTypePageAdmin("Accueil");
        bAccueil.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bRetour = this.buttonTypePageAdmin("Retour");
        bRetour.setOnAction(event -> this.app.passerEnModeRapport());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0, 20, 0, 20));
        this.setMaxSize(800, 700);
        try {
          this.auteur = labelTypePageAdmin((this.joueurBD.rechercherJoueurParNum(this.rapp.getIdJo())).getPseudo());
        }
        catch(SQLException e){
          this.auteur = labelTypePageAdmin("Problème non joueur");
        }
        this.objet = labelTypePageAdmin(this.rapp.getTitreRapport());
        this.sujet = labelTypePageAdmin(""+this.rapp.getSujetRapport());
        this.date = labelTypePageAdmin(this.rapp.getDateRapport());

        this.tMessage = new TextArea(this.rapp.getContenuRapport());
        tMessage.setMinSize(500, 400);
        tMessage.setEditable(false);

        grid.setPadding(new Insets(50, 0, 0, 0));

        grid.add(this.labelTypePageAdmin("Auteur : "), 0, 0);
        grid.add(this.auteur, 1, 0);
        grid.add(this.labelTypePageAdmin("Objet : "), 0, 1);
        grid.add(this.objet, 1, 1);
        grid.add(this.labelTypePageAdmin("Sujet : "), 0, 2);
        grid.add(this.sujet, 1, 2);
        grid.add(this.labelTypePageAdmin("Date : "), 0, 3);
        grid.add(this.date, 1, 3);
        grid.add(this.tMessage, 1, 5);
        this.setCenter(grid);
        this.setBottom(this.buttonBarTypePageAdmin(bAccueil, bRetour));



    }
}
