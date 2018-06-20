import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BorderStatistiques extends PageAdmin {

    AJEL app;

    public BorderStatistiques(AJEL app){
        super();
        this.app = app;

        Button bAccueil = this.buttonTypePageAdmin("Accueil");
        bAccueil.setOnAction(event -> this.app.passerEnModeAccueil());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(10,20,0,20));
        this.setMaxSize(800, 700);

        this.setCenter(this.tableauTypePageAdmin("Intitulé", "Date de mise à jour", "Jeu"));
        this.setBottom(this.buttonBarTypePageAdmin(bAccueil));
    }
}
