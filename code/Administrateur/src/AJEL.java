import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AJEL extends Application {

    private BorderPane laBase;

    private Menu MenuConnexion(String textB,String... nomti){
        Menu menu = new Menu();
        for(String nom : nomti){
            MenuItem menuI = new MenuItem(nom);
            menu.getItems().add(menuI);
        }
        Text texteBoutonMenu = new Text(textB);
        texteBoutonMenu.setFont(new Font(14));
        menu.setStyle("-fx-background-color: transparent;");
        texteBoutonMenu.setFill(Color.WHITE);
        menu.setGraphic(texteBoutonMenu);

        return menu;

    }

    private void creerMenu(){
        VBox bar = new VBox();
        MenuBar menu = new MenuBar();

        Menu jeu = this.MenuConnexion("Jeu", "Ajouter un jeu", "Gérer un jeu");
        Menu compte = this.MenuConnexion("Compte", "Gérer un compte");
        Menu rapport = this.MenuConnexion("Rapport", "Lire un rapport", "Rédiger un rapport");
        Menu stats = this.MenuConnexion("Statistiques", "Lire des statistiques");
        Menu aide = this.MenuConnexion("Aide", "Accéder aux aides");


        menu.getMenus().addAll(jeu, compte, rapport, stats, aide);
        menu.setBackground(new Background(new BackgroundFill(this.couleurDegradeBar(), null, null)));


//        jeu.setOnAction(event -> this.passerEnModeJeu());
//        compte.setOnAction(event -> this.passerEnModeCompte());
//        rapport.setOnAction(event -> this.passerEnModeRapportLire());
//        stats.setOnAction(event -> this.passerEnModeStats());
//        aide.setOnAction(event -> this.passerEnModeAide());

        bar.getChildren().add(menu);
        this.laBase.setTop(bar);
    }

//    private void passerEnModeJeu(){
//        this.laBase.setCenter(new BorderJeu(this));
//    }
//
//    private void passerEnModeCompte(){
//        this.laBase.setCenter(new BorderCompte(this));
//    }
//
//    private void passerEnModeRapportLire(){
//        this.laBase.setCenter(new BorderRapportLire(this));
//    }
//
//    private void passerEnModeStats(){
//        this.laBase.setCenter(new BorderStats(this));
//    }
//
//    private void passerEnModeAide(){
//        this.laBase.setCenter(new BorderAide(this));
//    }

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

        this.creerMenu();
        this.colorerLaBase();

        stage.setScene( new Scene(this.laBase,1000,800));
        stage.setTitle("AJEL");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
