package application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Date;
import java.sql.SQLException;

public class BorderRedigerMessage extends PageJoueur {
    AppliJDBC app;
	TextField tobjet, tdestinataire, tmessage;

    public BorderRedigerMessage(AppliJDBC app){
        super();
        this.app = app;

		this.tobjet = new TextField();
        VBox vobjet = this.vboxTypePageJoueur("Objet", this.tobjet);

		this.tdestinataire = new TextField();
        VBox vdestinataire = this.vboxTypePageJoueur("Destinaire", this.tdestinataire);

        HBox haut = new HBox();
        haut.setPadding(new Insets(10, 0, 10, 0));
        haut.getChildren().addAll(vobjet, vdestinataire);

        this.tmessage = new TextField();
        this.tmessage.setMinSize(500, 200);

        VBox vmessage = this.vboxTypePageJoueur("Message", this.tmessage);

        Button bEnvoyer = this.buttonTypePageJoueur("Envoyer");
        bEnvoyer.setOnAction(event -> this.envoyerMessage());

        Button bAnnuler = this.buttonTypePageJoueur("Annuler");
        bAnnuler.setOnAction(event -> this.app.passerEnModeMessagerieRecus());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.setTop(haut);
        this.setCenter(vmessage);
        this.setBottom(this.buttonBarTypePageJoueur(bEnvoyer, bAnnuler));
    }

	public void envoyerMessage() {
		Joueur j2;
		try {
			j2 = this.app.getJoueurBD().rechercherJoueurParPseudo(this.tdestinataire.getText());
		} catch (SQLException ex) {
			Alert alert = new Alert(AlertType.INFORMATION, "Destinataire inconnu.");
			alert.setOnHidden(ev -> alert.close());
			alert.show();
			return;
		}

		try {
			Message m = new Message(-1, new Date(), this.tobjet.getText(),
					this.tmessage.getText(), false, this.app.getClient(), j2);
			this.app.getMessageBD().creerMessage(m);
			this.app.passerEnModeMessagerieEnvoyes();
		} catch (SQLException ex) {
			Alert alert = new Alert(AlertType.INFORMATION, "Impossible d'envoyer ce message.");
			alert.setOnHidden(ev -> alert.close());
			alert.show();
		}
	}
}
