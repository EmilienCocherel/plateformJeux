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

public class BorderPartieHistorique extends PageJoueur{

    private AJEL appli;

    public BorderPartieHistorique(AJEL appli){

        super();
        this.appli = appli;

        Button enCours = this.buttonTypePageJoueur("En cours");
        enCours.setOnAction(event -> this.appli.passerEnModePartieEnCours());

        Button historique = this.buttonTypePageJoueur("Historique");
        historique.setOnAction(event -> this.appli.passerEnModePartieHistorique());

        this.setMaxSize(800, 700);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(20, 20, 20, 20));

        this.setTop(this.buttonBarTypePageJoueur(enCours,historique));
        this.setCenter(this.tableauTypePageJouer("Jeu","Adversaire","Date début partie","Date fin partie","Vainqueur"));
    }
}
