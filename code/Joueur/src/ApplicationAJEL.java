import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class ApplicationAJEL extends Application {
    Menu seconnecter,creerCompte;
    Stage window;
    Scene seco,creer;
    VBox res,res2;
    MenuItem compte;

    public VBox menuBar() {
        res = new VBox();
        res2 = new VBox();

        MenuBar menu = new MenuBar();

        this.seconnecter = new Menu("Se connecter");
        this.compte = new MenuItem("Aller");
        this.seconnecter.getItems().add(this.compte);
        this.creerCompte = new Menu("Créer un compte");

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

    public BorderPane leBorder() {
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


        res2.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        res2.setMaxSize(400, 300);

        res2.add(title, 0, 0);
        res2.add(Hlogin, 0, 1);
        res2.add(Hmdp, 0, 2);
        res2.add(cb, 0, 3);
        res2.add(Hbouton, 0, 4);
        res2.add(Hmdpoublie, 0, 5);

        BorderPane cont = new BorderPane();
        cont.setTop(this.menuBar());
        cont.setCenter(res2);
        Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);

        cont.setBackground(new Background(new BackgroundFill(lg2, null, null)));
        return cont;
    }



    @Override
    public void start(Stage stage) {
        window = stage;

        BorderPane cont = new BorderPane();
        cont.setTop(this.menuBar());
        cont.setCenter(this.creerCompte());
        Stop[] stops = new Stop[] { new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123,41,67))};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);

        cont.setBackground(new Background(new BackgroundFill(lg1,null,null)));
        this.creer = new Scene(cont,800,600);


        this.seco = new Scene(this.leBorder(),800,600);

        this.seconnecter.setOnAction(event -> window.setScene(this.creer));
        this.creerCompte.setOnAction(event -> window.setScene(this.seco));
        window.setScene(this.seco);
        window.setTitle("AJEL");
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
