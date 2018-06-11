import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Longin extends Applicationn{

    public VBox menuBar() {
        VBox res = new VBox();

        ButtonBar menu = new ButtonBar();

        Button seconnecter = new Button("Se connecter");
        ButtonBar.setButtonData(seconnecter, ButtonData.connecter);

        Button creerCompte = new Button("Créer un compte");
        ButtonBar.setButtonData(creerCompte, ButtonData.creer);

        Button quitter = new Button("Quitter");
        ButtonBar.setButtonData(quitter, ButtonData.quitter);

        menu.getButtons().addAll(seconnecter, creerCompte, quitter);

        res.setAlignement(Pos.TOP_CENTER);

        res.getChildren().addAll(menu);

        return res;

    }

    public VBox connexion() {

    }

    private Scene laScene(){
        BorderPane cont = new BorderPane();
        cont.setTop(this.menuBar());
        cont.setStyle("-fx-background-color: #000000");
        return new Scene(cont,700,800);
    }

    @Override
    public void start(Stage stage) {
        // création du modèle

        stage.setTitle("AJEL");
        stage.setScene(this.laScene());
        stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }

}