import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;

public class BorderMesAmis extends PageJoueur {

    AJEL app;

    public BorderMesAmis(AJEL app) {
        super();
        this.app = app;

        GridPane sceneTop = new GridPane();

        sceneTop.add(this.buttonTypePageJoueur("Demander en ami"),0,0);
        sceneTop.add(new TextField(),1,0);
        sceneTop.setPadding(new Insets(10, 30, 10, 10));

        GridPane sceneCentre = new GridPane();

        sceneCentre.add(this.buttonBarTypePageJoueur("Mes amis","Mes demandes"),0,0);
        sceneCentre.add(this.tableauTypePageJouer("Nom","Niveau","Pourcentage victoire"),0,1);
        sceneCentre.setPadding(new Insets(10, 30, 10, 10));
        sceneCentre.setMinWidth(600);

        this.setTop(sceneTop);
        this.setCenter(sceneCentre);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);

    }
}
