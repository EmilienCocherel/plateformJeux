package application;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GridInscrire extends PageConnexion{

    public GridInscrire(){
        super();

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.add(this.title("S'inscrire"),0,0);
        this.add(this.labelType("*Nom : "),0,1);
        this.add(new TextField(),1,1);
        this.add(this.labelType("*Email : "),0,2);
        this.add(new TextField(),1,2);
        this.add(this.labelType("*Mot de passe : "),0,3);
        this.add(new TextField(),1,3);
        this.add(this.labelType("*Confirmer : "),0,4);
        this.add(new TextField(),1,4);
        this.add(this.checkBoxType("J'accepte les termes d'utilisation \n et la politique de confidentialité"),1,5);
        this.add(this.buttonType("Se connecter"), 1, 6);

    }
}
