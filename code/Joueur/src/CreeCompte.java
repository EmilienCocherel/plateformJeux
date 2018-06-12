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

public class CreeCompte extends Application {

    public VBox menuBar() {
        VBox res = new VBox();

        MenuBar menu = new MenuBar();

        Menu seconnecter = new Menu("Se connecter");

        Menu creerCompte = new Menu("Créer un compte");

        Menu quitter = new Menu("Quitter");

        menu.getMenus().addAll(seconnecter, creerCompte, quitter);

        Stop[] stops = new Stop[] { new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123,41,67))};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);
        menu.setBackground(new Background(new BackgroundFill(lg1, null, null)));

        res.getChildren().addAll(menu);

        return res;

    }

    public GridPane creerCompte(){

        GridPane res = new GridPane();

        Font fonttitre = new Font("Arial", 25);

        Label title = new Label("S'incrire");
        title.setTextFill(Color.rgb(179, 71, 91));
        title.setPadding(new Insets(5, 0, 10, 10));
        title.setFont(fonttitre);
        title.setAlignment(Pos.TOP_LEFT);

        HBox Hnom = new HBox();
        Label Lnom = new Label("* Nom :   ");
        Lnom.setTextFill(Color.rgb(196, 196, 196));
        Lnom.setPadding(new Insets(0,0,0,56));
        TextField Tnom = new TextField();
        Hnom.getChildren().addAll(Lnom, Tnom);
        Hnom.setPadding(new Insets(20, 0, 0, 10));

        HBox Hemail = new HBox();
        Label Lemail = new Label("* Email :   ");
        Lemail.setTextFill(Color.rgb(196, 196, 196));
        Lemail.setPadding(new Insets(0,0,0,50));
        TextField Temail = new TextField();
        Hemail.getChildren().addAll(Lemail, Temail);
        Hemail.setPadding(new Insets(20, 0, 10, 10));

        HBox Hmdp = new HBox();
        Label Lmdp = new Label("* Mot de passe :   ");
        Lmdp.setTextFill(Color.rgb(196, 196, 196));
        PasswordField Tmdp = new PasswordField();
        Hmdp.getChildren().addAll(Lmdp, Tmdp);
        Hmdp.setPadding(new Insets(10, 0, 10, 10));

        HBox Hmdp2 = new HBox();
        Label Lmdp2 = new Label("* Confirmez :   ");
        Lmdp2.setTextFill(Color.rgb(196, 196, 196));
        Lmdp2.setPadding(new Insets(0,0,0,20));
        PasswordField Tmdp2 = new PasswordField();
        Hmdp2.getChildren().addAll(Lmdp2, Tmdp2);
        Hmdp2.setPadding(new Insets(10, 0, 0, 10));

        CheckBox cb = new CheckBox("J'accepte les termes d'utilisation \n et la politique de confidentialité");
        cb.setTextFill(Color.rgb(196, 196, 196));
        cb.setPadding(new Insets(10, 0, 0, 20));

        HBox Hbouton = new HBox();
        Button bconnect = new Button("S'inscrire");
        bconnect.setTextFill(Color.rgb(196, 196, 196));
        bconnect.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
        bconnect.setPadding(new Insets(5, 50, 5,50));
        Hbouton.setPadding(new Insets(40, 0, 0, 100));
        Hbouton.getChildren().addAll(bconnect);


        res.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        res.setMaxSize(500, 400);

        res.add(title,0,0);
        res.add(Hnom,0,1);
        res.add(Hemail,0,2);
        res.add(Hmdp,0,3);
        res.add(Hmdp2,0,4);
        res.add(cb,0,5);
        res.add(Hbouton,0,6);
        return res;
    }


    private Scene laScene(){
        BorderPane cont = new BorderPane();
        cont.setTop(this.menuBar());
        cont.setCenter(this.creerCompte());
        Stop[] stops = new Stop[] { new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123,41,67))};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);

        cont.setBackground(new Background(new BackgroundFill(lg1,null,null)));
        return new Scene(cont,800,600);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("AJEL");
        stage.setScene(this.laScene());
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
