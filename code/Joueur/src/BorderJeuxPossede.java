import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BorderJeuxPossede extends PageJoueur {

    private AJEL appli;

    public BorderJeuxPossede(AJEL appli){

        super();
        this.appli = appli;

        Button mesJeux = this.buttonTypePageJoueur("Mes jeux");
        mesJeux.setOnAction(event -> this.appli.passerEnModeJeuxPossede());

        Button boutique = this.buttonTypePageJoueur("Boutique");
        boutique.setOnAction(event -> this.appli.passerEnModeJeuxBoutique());

        this.setStyle("-fx-background-color: transparent;");
        this.setMaxSize(800, 700);

        this.setTop(this.buttonBarTypePageJoueur(mesJeux,boutique));
        this.setCenter(this.tableauTypePageJouer("Nom","Type","Commentaire"));
    }


}
