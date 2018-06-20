import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BorderAcceuilConnexion extends PageJoueur {

    AJEL app;

    public BorderAcceuilConnexion(AJEL app) {
        super();
        this.app = app;

        this.setTop(this.grosTitle("BIENVENUE"));
        this.setCenter(this.imageTypePageConnexion());
        this.setStyle("-fx-background-color: transparent;");
        this.setMaxSize(600, 500);
    }
}
