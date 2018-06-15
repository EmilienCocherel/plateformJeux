import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderAmisDemande extends PageJoueur {

    AJEL app;

    public BorderAmisDemande(AJEL app) {
        super();
        this.app = app;

        HBox bartop = this.hBoxTypetextBouton("Demande en ami");

        Button mesAmis = this.buttonTypePageJoueur("Mas amis");
        mesAmis.setOnAction(event -> this.app.passerEnModeMesAmis());

        Button mesDemandes= this.buttonTypePageJoueur("Mes demandes");
        mesDemandes.setOnAction(event -> this.app.passerEnModeMesDemandes());

        BorderPane sceneCentre = new BorderPane();

        sceneCentre.setTop(this.buttonBarTypePageJoueur(mesAmis,mesDemandes));
        sceneCentre.setCenter(this.tableauTypePageJouer("Nom","Niveau","Pourcentage victoire","Accepter"));
        sceneCentre.setPadding(new Insets(10, 10, 10, 10));
        sceneCentre.setMinWidth(600);

        this.setTop(bartop);
        this.setCenter(sceneCentre);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);

    }
}
