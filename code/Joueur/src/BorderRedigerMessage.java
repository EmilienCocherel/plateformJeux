import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BorderRedigerMessage extends PageJoueur {

    AJEL app;

    public BorderRedigerMessage(AJEL app){
        super();
        this.app = app;

        VBox vobjet = this.vboxTypePageJoueur("Objet");

        VBox vdestinataire = this.vboxTypePageJoueur("Destinaire");

        HBox haut = new HBox();
        haut.getChildren().addAll(vobjet, vdestinataire);

        VBox vmessage = this.vboxTypePageJoueur("Message");

        Button bEnvoyer = this.buttonTypePageJoueur("Envoyer");
        bEnvoyer.setOnAction(event -> this.app.passerEnModeMessagerieEnvoyes());

        Button bAnnuler = this.buttonTypePageJoueur("Annuler");
        bAnnuler.setOnAction(event -> this.app.passerEnModeMessagerieRecus());

        this.setTop(haut);
        this.setCenter(vmessage);
        this.setBottom(this.buttonBarTypePageJoueur(bEnvoyer, bAnnuler));
    }
}
