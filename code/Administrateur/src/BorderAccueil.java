import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BorderAccueil extends PageAdmin {

    AJEL app;

    public BorderAccueil(AJEL app){
        super();
        this.app = app;

        GridPane centre = new GridPane();

        GridPane tabGauche = new GridPane();

        GridPane tabDroit = new GridPane();

        tabGauche.add(this.titlePageAdmin("Activité"), 0, 0);
        tabGauche.add(this.textAeraVerticalNonEditable(), 0, 1);
        tabGauche.setPadding(new Insets(10,20,0,20));

        tabDroit.add(this.titlePageAdmin("Messages"), 0, 0);
        tabDroit.add(this.textAeraVerticalNonEditable(), 0, 1);
        tabDroit.setPadding(new Insets(10,20,0,20));

        centre.add(tabGauche, 0, 0);
        centre.add(tabDroit, 1, 0);

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(10,20,0,20));
        this.setMaxSize(800, 700);

        this.setCenter(centre);
    }
}
