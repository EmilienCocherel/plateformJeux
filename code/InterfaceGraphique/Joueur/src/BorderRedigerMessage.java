import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderRedigerMessage extends PageJoueur {

    AJEL app;

    public BorderRedigerMessage(AJEL app){
        super();
        this.app = app;

        VBox vobjet = this.vboxTypePageJoueur("Objet");

        VBox vdestinataire = this.vboxTypePageJoueur("Destinaire");

        HBox haut = new HBox();
        haut.setPadding(new Insets(10, 0, 10, 0));
        haut.getChildren().addAll(vobjet, vdestinataire);

        TextArea tmessage = new TextArea();
        tmessage.setWrapText(true);
        tmessage.setMinSize(500, 200);

        VBox vmessage = this.vboxTypePageJoueur("Message", tmessage);

        Button bEnvoyer = this.buttonTypePageJoueur("Envoyer");
        bEnvoyer.setOnAction(event -> this.app.passerEnModeMessagerieEnvoyes());

        Button bAnnuler = this.buttonTypePageJoueur("Annuler");
        bAnnuler.setOnAction(event -> this.app.passerEnModeMessagerieRecus());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.setTop(haut);
        this.setCenter(vmessage);
        this.setBottom(this.buttonBarTypePageJoueur(bEnvoyer, bAnnuler));
    }
}
