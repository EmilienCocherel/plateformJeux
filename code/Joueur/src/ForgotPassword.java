import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

import java.awt.*;

public class ForgotPassword extends BorderPane {
    private BorderPane sceneForgotPass;
    private ApplicationAJEL app;

    public ForgotPassword(ApplicationAJEL app){

        this.app = app;

        GridPane res2 = new GridPane();

        javafx.scene.text.Font fonttitre = new Font("Arial", 25);

        javafx.scene.control.Label title = new javafx.scene.control.Label("Mot de pass Oublié");
        title.setTextFill(Color.rgb(179, 71, 91));
        title.setPadding(new Insets(5, 0, 20, 10));
        title.setFont(fonttitre);
        title.setAlignment(Pos.TOP_LEFT);

        HBox Hemail = new HBox();
        javafx.scene.control.Label Lemail = new javafx.scene.control.Label("Email : ");
        Lemail.setTextFill(Color.rgb(196, 196, 196));
        javafx.scene.control.TextField Temail = new javafx.scene.control.TextField();
        Hemail.getChildren().addAll(Lemail, Temail);
        Hemail.setPadding(new Insets(20, 0, 10, 20));

        HBox Hbouton = new HBox();
        javafx.scene.control.Button bconnect = new javafx.scene.control.Button("Changer mot de passe");
        bconnect.setTextFill(Color.rgb(196, 196, 196));
        bconnect.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
        bconnect.setPadding(new Insets(5, 50, 5, 50));
        Hbouton.setPadding(new Insets(40, 0, 0, 100));
        Hbouton.getChildren().addAll(bconnect);

        res2.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        res2.setMaxSize(400, 300);

        res2.add(title,0,0);
        res2.add(Hemail,0,1);
        res2.add(Hbouton,0,2);


        BorderPane cont = new BorderPane();
        cont.setTop(res2);
        cont.setCenter(res2);
        Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);

        cont.setBackground(new Background(new BackgroundFill(lg2, null, null)));
        this.sceneForgotPass = cont;

    }
}
