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

public class BorderMessagerieRecus extends PageJoueur{

    private AJEL appli;

    public BorderMessagerieRecus(AJEL appli){

        super();
        this.appli = appli;

        Button recus = this.buttonTypePageJoueur("Reçus");
        recus.setOnAction(event -> this.appli.passerEnModeMessagerieRecus());

        Button envoyes = this.buttonTypePageJoueur("Envoyés");
        envoyes.setOnAction(event -> this.appli.passerEnModeMessagerieEnvoyes());

        Button supprimer = this.buttonTypePageJoueur("Supprimer");
        supprimer.setOnAction(event -> this.appli.passerEnModeMessagerieRecus());

        Button redigerMessage = this.buttonTypePageJoueur("Rédiger un nouveau message");
        redigerMessage.setOnAction(event -> this.appli.passerEnModeRedigerMessage());

        this.setMaxSize(800, 700);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(20, 20, 20, 20));

        this.setTop(this.buttonBarTypePageJoueur(recus,envoyes));
        this.setCenter(this.tableauTypePageJouer("Auteur","Objet","Date"));
        this.setBottom(this.buttonBarTypePageJoueur(supprimer, redigerMessage));
    }
}