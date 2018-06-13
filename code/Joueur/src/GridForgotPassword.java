import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridForgotPassword extends PageConnexion {

    public GridForgotPassword(){
        super();

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.add(this.title("Mot de passe\noublié"), 0, 0);
        this.add(this.labelType("Email : "), 0, 1);
        this.add(new TextField(),1,1);
        this.add(this.buttonType("Changer mot de passe"), 1, 2);

    }
}
