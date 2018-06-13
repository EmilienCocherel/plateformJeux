import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.control.ButtonBar.BUTTON_ORDER_LINUX;
import static javafx.scene.control.ButtonBar.BUTTON_ORDER_NONE;

public class AJEL extends Application {

    private BorderPane laBase;


    private void creerMenuConnexion(){
        VBox bar = new VBox();
        ButtonBar menu = new ButtonBar();

        Button seConnecter = new Button();
        Text texteSeConnecter = new Text("Se connecter");
        texteSeConnecter.setFont(new Font(14));
        seConnecter.setStyle("-fx-background-color: transparent;");
        texteSeConnecter.setFill(Color.WHITE);
        seConnecter.setGraphic(texteSeConnecter);


        Button creerCompte = new Button();
        Text texteCreerUnCompte = new Text("Créer un compte");
        texteCreerUnCompte.setFont(new Font(14));
        creerCompte.setStyle("-fx-background-color: transparent;");
        texteCreerUnCompte.setFill(Color.WHITE);
        creerCompte.setGraphic(texteCreerUnCompte);

        menu.setButtonData(seConnecter,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(creerCompte,ButtonBar.ButtonData.LEFT);
        menu.getButtons().addAll(seConnecter, creerCompte);
        menu.setBackground(new Background(new BackgroundFill(this.couleurDegradeBar(), null, null)));


        creerCompte.setOnAction(event -> this.passerEnModeInscription());
        seConnecter.setOnAction(event -> this.passerEnModeConnexion());

        bar.getChildren().add(menu);
        this.laBase.setTop(bar);
    }

    private void passerEnModeInscription(){
        this.laBase.setCenter(new GridInscrire());
    }

    private void passerEnModeConnexion(){
          this.laBase.setCenter(new GridConnexion(this));
    }

    public void passerEnModeMDPOublie(){
        this.laBase.setCenter(new GridForgotPassword());
    }
    private void colorerLaBase(){
        this.laBase.setBackground(new Background(new BackgroundFill(this.couleurDegradeCentre(), null, null)));
    }

    public LinearGradient couleurDegradeCentre(){
        Stop[] stops = new Stop[] { new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123,41,67))};
        LinearGradient degradeRoseNoire = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);
        return degradeRoseNoire;
    }

    public LinearGradient couleurDegradeBar(){
        Stop[] stops = new Stop[] { new Stop(0.4, Color.rgb(70,41,67)), new Stop(1, Color.rgb(160,41,67))};
        LinearGradient degradeRoseNoire = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);
        return degradeRoseNoire;
    }
    @Override
    public void init(){
        this.laBase = new BorderPane();

    }

    @Override
    public void start(Stage stage) {

        this.creerMenuConnexion();
        this.colorerLaBase();

        stage.setScene( new Scene(this.laBase,800,600));
        stage.setTitle("AJEL");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
