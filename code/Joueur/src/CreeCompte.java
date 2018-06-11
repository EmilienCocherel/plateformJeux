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
        title.setPadding(new Insets(5, 0, 20, 10));
        title.setFont(fonttitre);
        title.setAlignment(Pos.TOP_LEFT);

        return res;
    }


    private Scene laScene(){
        BorderPane cont = new BorderPane();
        cont.setTop(this.menuBar());
        Stop[] stops = new Stop[] { new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123,41,67))};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);

        cont.setBackground(new Background(new BackgroundFill(lg1,null,null)));
        return new Scene(cont,700,800);
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
