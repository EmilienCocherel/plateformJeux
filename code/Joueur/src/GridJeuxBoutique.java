import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.control.ButtonBar;

public class GridJeuxBoutique extends PageJoueur{

    private AJEL appli;

    public GridJeuxBoutique(AJEL appli){

        super();
        this.appli = appli;

        Button mesJeux = this.buttonTypePageJoueur("Mes jeux");
        mesJeux.setOnAction(event -> this.appli.passerEnModeJeuxPossede());

        Button boutique = this.buttonTypePageJoueur("Boutique");
        boutique.setOnAction(event -> this.appli.passerEnModeJeuxBoutique());

        this.setStyle("-fx-background-color: transparent;");
        this.setMaxSize(800, 700);


        this.setTop(this.buttonBarTypePageJoueur(mesJeux,boutique));
        this.setCenter(this.tableauTypePageJouer("Nom","Type","Description"));

    }

}
