import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderMesAmis extends PageJoueur {

    AJEL app;

    public BorderMesAmis(AJEL app) {
        super();
        this.app = app;

        BorderPane sceneTop = new BorderPane();

        sceneTop.setLeft(this.buttonTypePageJoueur("Demander en ami"));
        sceneTop.setCenter(new TextField());
        sceneTop.setPadding(new Insets(10, 30, 10, 10));

        BorderPane sceneCentre = new BorderPane();

        sceneCentre.setTop(this.buttonBarTypePageJoueur("Mes amis","Mes demandes"));
        sceneCentre.setCenter(this.tableauTypePageJouer("Nom","Niveau","Pourcentage victoire"));
        sceneCentre.setPadding(new Insets(10, 10, 10, 10));
        sceneCentre.setMinWidth(600);

        this.setTop(sceneTop);
        this.setCenter(sceneCentre);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);

    }
}
