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

public class Login {
    private BorderPane cont;
    private ApplicationAJEL app;


    public Login(ApplicationAJEL app) {

            this.app = app;
            this.cont = new BorderPane();

    }

    public Label title(String titre) {

            Font fonttitre = new Font("Arial", 25);
            Label title = new Label(titre);
            title.setTextFill(Color.rgb(179, 71, 91));
            title.setPadding(new Insets(5, 0, 20, 10));
            title.setFont(fonttitre);
            title.setAlignment(Pos.TOP_LEFT);

            return title;
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

    public HBox HboxButton(String nom){

            HBox Hbouton = new HBox();
            Button bconnect = new Button(nom);

            bconnect.setTextFill(Color.rgb(196, 196, 196));
            bconnect.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
            bconnect.setPadding(new Insets(5, 50, 5, 50));

            Hbouton.setPadding(new Insets(40, 0, 0, 100));
            Hbouton.getChildren().addAll(bconnect);

            return Hbouton;
    }

        public CheckBox checkBox(String nom) {

            CheckBox cb = new CheckBox(nom);
            cb.setTextFill(Color.rgb(196, 196, 196));
            cb.setPadding(new Insets(10, 0, 0, 20));

            return cb;

        }

        public HBox HBoxlien(String nom) {
            HBox Hmdpoublie = new HBox();
            Hyperlink Lmdpoublie = new Hyperlink(nom);
            Lmdpoublie.setTextFill(Color.rgb(179, 71, 91));

            Hmdpoublie.getChildren().addAll(Lmdpoublie);
            Hmdpoublie.setPadding(new Insets(10, 0, 0, 100));

            return Hmdpoublie;
        }


    public GridPane fenetreSeConnecter(){

            GridPane fenetre = new GridPane();

            fenetre.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
            fenetre.setMaxSize(400, 300);

            fenetre.add(this.title("Connexion"), 0, 0);
            fenetre.add(this.HboxLabeltextfiedl("Email : "), 0, 1);
            fenetre.add(this.HboxLabeltextfiedl("Mot de passe : "), 0, 2);
            fenetre.add(this.checkBox("Enregistrer mot de passe"), 0, 3);
            fenetre.add(this.HboxButton("Se connecter"), 0, 4);
            fenetre.add(this.HBoxlien("Mot de passe oublié ?"), 0, 5);

            return fenetre;
    }

    public void initCont(){

            this.cont.setTop(this.app.getMenuBar());
            this.cont.setCenter(this.fenetreSeConnecter());
            Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
            LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);

            this.cont.setBackground(new Background(new BackgroundFill(lg2, null, null)));

    }


    public BorderPane getPanelLogin() {
        this.initCont();
        return this.cont;
    }
}
