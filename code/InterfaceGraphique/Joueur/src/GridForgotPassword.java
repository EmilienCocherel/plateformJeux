import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridForgotPassword extends PageConnexion {

    public GridForgotPassword(){
        super();

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(600, 300);

        this.add(this.title("Mot de passe oublié"), 1, 0);
        this.add(this.labelType("Email : "), 0, 1);
        this.add(new TextField(),1,1);
        this.add(this.labelType("Nouveau mot de passe : "), 0, 2);
        this.add(new TextField(),1,2);
        this.add(this.labelType("Confirmer mot de passe : "), 0, 3);
        this.add(new TextField(),1,3);
        this.add(this.labelType(""), 0, 4);
        this.add(this.buttonType("Changer mot de passe"), 1, 6);

    }
}
