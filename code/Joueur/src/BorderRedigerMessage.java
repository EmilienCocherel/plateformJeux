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

        VBox vobjet = new VBox();

        Label lobjet = new Label("Objet");
        TextField tobjet = new TextField();

        vobjet.getChildren().addAll(lobjet, tobjet);

        VBox vdestinataire = new VBox();

        Label ldesinataire = new Label("Destinataire");
        TextField tdestinataire = new TextField("Destinataire");

        vdestinataire.getChildren().addAll(ldesinataire, tdestinataire);

        HBox haut = new HBox();
        haut.getChildren().addAll(vobjet, vdestinataire);

        VBox vmessage = new VBox();

        Label lmessage = new Label("Message");
        TextField tmessage = new TextField();

        vmessage.getChildren().addAll(lmessage, tmessage);

        Button bEnvoyer = this.buttonTypePageJoueur("Envoyer");
        bEnvoyer.setOnAction(event -> this.app.passerEnModeMessagerieEnvoyes());

        Button bAnnuler = this.buttonTypePageJoueur("Annuler");
        bAnnuler.setOnAction(event -> this.app.passerEnModeMessagerieRecus());

        this.setTop(haut);
        this.setCenter(vmessage);
        this.setBottom(this.buttonBarTypePageJoueur(bEnvoyer, bAnnuler));
    }
}
