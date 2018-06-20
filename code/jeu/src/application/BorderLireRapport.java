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
import javafx.stage.Stage;

public class BorderLireRapport extends PageAdmin {

    AppliJDBC app;

    BorderLireRapport(AppliJDBC app){
        super();
        this.app = app;

        GridPane grid = new GridPane();

        Button bAccueil = this.buttonTypePageAdmin("Accueil");
        bAccueil.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bRetour = this.buttonTypePageAdmin("Retour");
        bRetour.setOnAction(event -> this.app.passerEnModeRapport());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0, 20, 0, 20));
        this.setMaxSize(800, 700);

        TextArea tMessage = new TextArea();
        tMessage.setMinSize(500, 400);
        tMessage.setEditable(false);

        grid.setPadding(new Insets(50, 0, 0, 0));

        grid.add(this.labelTypePageAdmin("Nom du rapport :  "), 0, 0);
        grid.add(this.labelTypePageAdmin(" ...  "), 1, 0);
        grid.add(this.labelTypePageAdmin("Message : "), 1, 1);
        grid.add(tMessage, 1, 2);
        this.setCenter(grid);
        this.setBottom(this.buttonBarTypePageAdmin(bAccueil, bRetour));



    }
}
