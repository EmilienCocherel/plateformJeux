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

        this.setCenter(this.imageTypePageConnexion());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);
    }
}
