import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BorderGererJeux extends PageAdmin {

    AJEL app;

    BorderGererJeux(AJEL app) {

        this.app = app;

        Button bAccueil = this.buttonTypePageAdmin("Accueil");
        bAccueil.setOnAction(event -> this.app.passerEnModeAccueil());

        this.setTop(this.hboxTypePageAdmin("Jeu : "));
        this.setCenter(this.tableauTypePageAdmin("Nom du jeu","Prix","Actif"));
        this.setBottom(this.buttonBarTypePageAdmin(bAccueil));

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0, 20, 0, 20));
        this.setMaxSize(800, 700);


    }



}
