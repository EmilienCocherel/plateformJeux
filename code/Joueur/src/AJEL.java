import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AJEL extends Application {

    private BorderPane laBase;


    private void creerMenuConnexion(){
        VBox bar = new VBox();
        MenuBar menu = new MenuBar();

        Menu seconnecter = new Menu();
        Text texteSeConnecter = new Text("Se connecter");
        texteSeConnecter.setFont(new Font(14));
        texteSeConnecter.setFill(Color.WHITE);
        seconnecter.setGraphic(texteSeConnecter);

        MenuItem seCo = new MenuItem("Se connecter");
        seconnecter.getItems().add(seCo);

        Menu creerCompte = new Menu();
        Text texteCreerUnCompte = new Text("Créer un compte");
        texteCreerUnCompte.setFont(new Font(14));
        texteCreerUnCompte.setFill(Color.WHITE);
        creerCompte.setGraphic(texteCreerUnCompte);

        MenuItem crea = new MenuItem("Création du compte");
        creerCompte.getItems().add(crea);


        menu.getMenus().addAll(seconnecter, creerCompte);
        menu.setBackground(new Background(new BackgroundFill(this.couleurDegradeBar(), null, null)));

        creerCompte.setOnAction(event -> this.passerEnModeInscription());
        seconnecter.setOnAction(event -> this.passerEnModeConnexion());

        bar.getChildren().add(menu);
        this.laBase.setTop(bar);
    }

    private void passerEnModeInscription(){
        this.laBase.setCenter(new GridInscrire());
    }

    private void passerEnModeConnexion(){
          this.laBase.setCenter(new GridConnexion());
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
