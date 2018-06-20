package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderMesAmis extends PageJoueur {

    AppliJDBC app;

    public BorderMesAmis(AppliJDBC app) {
        super();
        this.app = app;

        HBox bartop = this.hBoxTypetextBouton("Demande en ami");

        BorderPane sceneCentre = new BorderPane();

        sceneCentre.setTop(this.buttonBarTypePageJoueur("Mes amis","Mes demandes"));
        sceneCentre.setCenter(this.tableauTypePageJouer("Nom","Niveau","Pourcentage victoire"));
        sceneCentre.setPadding(new Insets(10, 10, 10, 10));
        sceneCentre.setMinWidth(600);

        this.setTop(bartop);
        this.setCenter(sceneCentre);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);

    }
}
