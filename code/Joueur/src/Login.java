import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.CheckBox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Login extends BorderPane {
    private BorderPane sceneLogin;

    public Login() {

            VBox res = new VBox();

            MenuBar menu = new MenuBar();

            Menu seconnecter = new Menu("Se connecter");

            Menu creerCompte = new Menu("Créer un compte");

            Menu quitter = new Menu("Quitter");

            menu.getMenus().addAll(seconnecter, creerCompte, quitter);

            Stop[] stops1 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
            LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops1);
            menu.setBackground(new Background(new BackgroundFill(lg1, null, null)));

            res.getChildren().addAll(menu);


            GridPane res2 = new GridPane();

            Font fonttitre = new Font("Arial", 25);


            Label title = new Label("Connexion");
            title.setTextFill(Color.rgb(179, 71, 91));
            title.setPadding(new Insets(5, 0, 20, 10));
            title.setFont(fonttitre);
            title.setAlignment(Pos.TOP_LEFT);

            HBox Hlogin = new HBox();
            Label Llogin = new Label("Email ou login : ");
            Llogin.setTextFill(Color.rgb(196, 196, 196));
            TextField Tlogin = new TextField();
            Hlogin.getChildren().addAll(Llogin, Tlogin);
            Hlogin.setPadding(new Insets(20, 0, 10, 20));

            HBox Hmdp = new HBox();
            Label Lmdp = new Label("Mot de passe :  ");
            Lmdp.setTextFill(Color.rgb(196, 196, 196));
            PasswordField Tmdp = new PasswordField();
            Hmdp.getChildren().addAll(Lmdp, Tmdp);
            Hmdp.setPadding(new Insets(10, 0, 0, 20));

            CheckBox cb = new CheckBox("Enregistrer mot de passe");
            cb.setTextFill(Color.rgb(196, 196, 196));
            cb.setPadding(new Insets(10, 0, 0, 20));


            HBox Hbouton = new HBox();
            Button bconnect = new Button("Se connecter");
            bconnect.setTextFill(Color.rgb(196, 196, 196));
            bconnect.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
            bconnect.setPadding(new Insets(5, 50, 5, 50));
            Hbouton.setPadding(new Insets(40, 0, 0, 100));
            Hbouton.getChildren().addAll(bconnect);

            HBox Hmdpoublie = new HBox();
            Label Lmdpoublie = new Label("Mot de passe oublié ?");
            Lmdpoublie.setTextFill(Color.rgb(179, 71, 91));
            Hmdpoublie.getChildren().addAll(Lmdpoublie);
            Hmdpoublie.setPadding(new Insets(10, 0, 0, 100));


            res.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
            res.setMaxSize(400, 300);

            res2.add(title, 0, 0);
            res2.add(Hlogin, 0, 1);
            res2.add(Hmdp, 0, 2);
            res2.add(cb, 0, 3);
            res2.add(Hbouton, 0, 4);
            res2.add(Hmdpoublie, 0, 5);

            BorderPane cont = new BorderPane();
            cont.setTop(res);
            cont.setCenter(res2);
            Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
            LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);

            cont.setBackground(new Background(new BackgroundFill(lg2, null, null)));
            this.sceneLogin=cont;
        }

    public BorderPane getPanelLogin() {
        return this.sceneLogin;
    }
}
