package application;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderConsutlerStatsJeux extends PageJoueur {

    AppliJDBC app;

    public BorderConsutlerStatsJeux(AppliJDBC app){
        super();
        this.app = app;

        Button brevenir = this.buttonTypePageJoueur("Revenir au profil");
        brevenir.setOnAction(event -> this.app.passerEnModeProfilUtilisateur());

        HBox haut = this.hboxTypePageJoueur("Statistiques de <Nom joueur>     ", brevenir);

        Button jeux = this.buttonTypePageJoueur("Jeux");
        jeux.setOnAction(event -> this.app.passerEnModeConsulterStatsJeux());

        Button adversaire = this.buttonTypePageJoueur("Adversaire");
        adversaire.setOnAction(event -> this.app.passerEnModeConsulterStatsAdversaire());

        BorderPane centre = new BorderPane();
        centre.setTop(this.buttonBarTypePageJoueur(jeux,adversaire));
        centre.setCenter(this.tableauTypePageJouer("Nom jeu","% de victoires","Score Moyen"));

        this.setMaxSize(800, 700);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(20, 20, 20, 20));

        this.setTop(haut);
        this.setCenter(centre);


    }
}
