package application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Date;
import java.sql.SQLException;

public class BorderLireMessage extends PageJoueur {
    AppliJDBC app;
	TextField tobjet, tdestinataire, tmessage;

    public BorderLireMessage(AppliJDBC app, Message m){
        super();
        this.app = app;

        Label titre = this.titlePageJouer(m.getObjet()+" de "+m.getJoueur2().getPseudo());

        HBox haut = new HBox();
        haut.setPadding(new Insets(10, 0, 10, 0));
        haut.getChildren().addAll(titre);

        Text tmessage = new Text();
		tmessage.setFont(new Font(20));
		tmessage.setText(m.getMessage());

        Button bEnvoyer = this.buttonTypePageJoueur("Répondre");
        bEnvoyer.setOnAction(event -> this.app.passerEnModeRedigerMessage());

        Button bAnnuler = this.buttonTypePageJoueur("Fermer");
        bAnnuler.setOnAction(event -> this.app.passerEnModeMessagerieRecus());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(400, 300);

        this.setTop(haut);
        this.setCenter(tmessage);
        this.setBottom(this.buttonBarTypePageJoueur(bEnvoyer, bAnnuler));
    }
}
