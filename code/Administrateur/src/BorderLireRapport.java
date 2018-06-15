import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderLireRapport extends PageAdmin {

    AJEL app;

    public BorderLireRapport(AJEL app){
        super();
        this.app = app;

        Button bMenu = this.buttonTypePageAdmin("Accueil");
        bMenu.setOnAction(event -> this.app.passerEnModeAccueil());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0,20,0,20));
        this.setMaxSize(800, 700);

        this.setTop(this.hboxTypePageAdmin("Nom du rapport : "));
        this.setCenter(this.tableauTypePageAdmin("Titre", "Auteur", "Sujet", "Date publication"));
        this.setBottom(this.buttonBarTypePageAdmin(bMenu));
    }
}