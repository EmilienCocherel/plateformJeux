import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridConnexion extends PageConnexion{

    private AJEL appli;

    public GridConnexion(AJEL appli){
        super();
        this.appli = appli;

        Button seConnecter = this.buttonType("Se connecter");
        seConnecter.setOnAction(event -> this.appli.passerEnModeJoueur());



        Hyperlink lienMDP = this.lienType("Mot de passe oublié ?");
        lienMDP.setOnAction(event -> this.appli.passerEnModeMDPOublie());
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.add(this.title("Connexion"), 0, 0);
        this.add(this.labelType("Email ou Pseudo : "), 0, 1);
        this.add(new TextField(),1,1);
        this.add(this.labelType("Mot de passe : "), 0, 2);
        this.add(new TextField(),1,2);
        this.add(this.checkBoxType("Enregistrer mot de passe"), 1, 3);
        this.add(this.labelType(""), 0, 4);
        this.add(seConnecter, 1, 5);
        this.add(lienMDP, 1, 6);

    }
}
