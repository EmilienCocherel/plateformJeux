import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class Invitations extends BorderPane {

    ApplicationAJEL app;
    BorderPane cont;

    public Invitations(ApplicationAJEL app1){
        this.app = app1;
        this.cont = new BorderPane();
    }

    public HBox HboxLabeltextfiedl(String nom) {

        HBox res = new HBox();
        Label label = new Label(nom);
        label.setTextFill(Color.rgb(196, 196, 196));

        TextField text = new TextField();
        res.getChildren().addAll(label, text);

        res.setPadding(new Insets(20, 0, 10, 20));

        return res;

    }

    public Label title(String titre) {

        javafx.scene.text.Font fonttitre = new javafx.scene.text.Font("Arial", 25);
        Label title = new Label(titre);
        title.setTextFill(Color.rgb(179, 71, 91));
        title.setPadding(new Insets(5, 0, 20, 10));
        title.setFont(fonttitre);
        title.setAlignment(Pos.TOP_LEFT);

        return title;
    }

    public HBox inviterAmi(){

        HBox invit = new HBox();

        invit.getChildren().addAll(this.title("Inviter des amis"), this.HboxLabeltextfiedl("Ami : "), this.HboxLabeltextfiedl("Jeu : "));

        return invit;
    }


}