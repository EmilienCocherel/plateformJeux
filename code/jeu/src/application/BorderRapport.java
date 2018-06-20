package application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderRapport extends PageAdmin {

    AppliJDBC app;

    public BorderRapport(AppliJDBC app){
        super();
        this.app = app;

        Button bAccueil = this.buttonTypePageAdmin("Accueil");
        bAccueil.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bLire = this.buttonTypePageAdmin("Lire");
        bLire.setOnAction(event -> this.app.passerEnModeRapportLire());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0,20,0,20));
        this.setMaxSize(800, 700);

        this.setTop(this.hboxTypeGrosPageAdmin("Nom du rapport : "));
        this.setCenter(this.tableauTypePageAdmin("Titre", "Auteur", "Sujet", "Date publication"));
        this.setBottom(this.buttonBarTypePageAdmin(bAccueil, bLire));
    }
}
