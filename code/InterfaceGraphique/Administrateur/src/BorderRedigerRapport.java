import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderRedigerRapport extends PageAdmin {

    AJEL app;

    public BorderRedigerRapport(AJEL app) {
        super();
        this.app = app;

        GridPane grid = new GridPane();

        Button bMenu = this.buttonTypePageAdmin("Accueil");
        bMenu.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bEnregistrer = this.buttonTypePageAdmin("Enregistrer");
        bEnregistrer.setOnAction(event -> this.app.passerEnModeCompte());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0, 20, 0, 20));
        this.setMaxSize(800, 700);

        TextArea tMessage = new TextArea();
        tMessage.setMinSize(500, 400);

        grid.setPadding(new Insets(50, 0, 0, 0));

        grid.add(this.labelTypePageAdmin("Auteur : "), 0, 0);
        grid.add(this.labelTypePageAdmin("... "), 1, 0);
        grid.add(this.labelTypePageAdmin("Nom du rapport : "), 0, 1);
        grid.add(new TextField(), 1, 1);
        grid.add(this.labelTypePageAdmin("Message : "), 0, 2);
        grid.add(tMessage, 1, 2);
        this.setCenter(grid);
        this.setBottom(this.buttonBarTypePageAdmin(bMenu, bEnregistrer));
    }
}
