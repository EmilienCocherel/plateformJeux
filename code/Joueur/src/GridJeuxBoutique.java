import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.control.ButtonBar;

public class GridJeuxBoutique extends PageJoueur{

    private AJEL appli;

    public GridJeuxBoutique(AJEL appli){
        super();
        this.appli = appli;

        Button mesJeux = this.buttonTypePageJoueur("Mes jeux");
        //mesJeux.setOnAction(event -> this.appli.passerEnModeJeuxPossede());

        Button boutique = this.buttonTypePageJoueur("Boutique");
        //boutique.setOnAction(event -> this.appli.passerEnModeJeuxBoutique());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);


        this.add(this.buttonBarTypePageJoueur(mesJeux,boutique),0,0);
        this.add(this.tableauTypePageJouer("Nom","Type","Description"),0,1);
        
    }

}
