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

    private Menu MenuConnexion(String textB){
        Menu menu = new Menu();
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

        MenuItem ajouterJeu = new MenuItem("Ajouter un jeu");
        ajouterJeu.setOnAction(event -> this.passerEnModeAjouterJeu());

        MenuItem gererJeu = new MenuItem("Gérer un jeu");
        //gererJeu.setOnAction(event -> this.passerEnModeGererJeu());

        MenuItem gererCompte = new MenuItem("Gérer un compte");
        gererCompte.setOnAction(event -> this.passerEnModeCompte());

        MenuItem lireRapport = new MenuItem("Lire un rapport");
        lireRapport.setOnAction(event -> this.passerEnModeRapport());

        MenuItem redigerRapport = new MenuItem("Rédiger un rapport");
        redigerRapport.setOnAction(event -> this.passerEnModeRapportRediger());

        MenuItem lireStats = new MenuItem("Lire des statistiques");
        //lireStats.setOnAction(event -> this.passerEnModeStats());

        MenuItem accesAide = new MenuItem("Accéder aux aides");
        //accesAide.setOnAction(event -> this.laBase.passerEnModeAide());

        Menu jeu = this.MenuConnexion("Jeu");
        jeu.getItems().addAll(ajouterJeu, gererJeu);

        Menu compte = this.MenuConnexion("Compte");
        compte.getItems().addAll(gererCompte);

        Menu rapport = this.MenuConnexion("Rapport");
        rapport.getItems().addAll(lireRapport, redigerRapport);

        Menu stats = this.MenuConnexion("Statistiques");
        stats.getItems().addAll(lireStats);

        Menu aide = this.MenuConnexion("Aide");
        aide.getItems().addAll(accesAide);

        menu.getMenus().addAll(jeu, compte, rapport, stats, aide);
        menu.setBackground(new Background(new BackgroundFill(this.couleurDegradeBar(), null, null)));

        bar.getChildren().add(menu);
        this.laBase.setTop(bar);
    }

    public void passerEnModeAccueil(){
        this.laBase.setCenter(new BorderAccueil(this));
    }

    public void passerEnModeAjouterJeu(){
        this.laBase.setCenter(new BorderAjouterJeu(this));
   }
//
    public void passerEnModeCompte(){
        this.laBase.setCenter(new BorderCompte(this));
    }

    public void passerEnModeRapport(){
        this.laBase.setCenter(new BorderRapport(this));
    }
//
    public void passerEnModeRapportLire(){
        this.laBase.setCenter(new BorderLireRapport(this));
    }
//
    public void passerEnModeRapportRediger(){
        this.laBase.setCenter(new BorderRedigerRapport(this));
    }
//
//    public void passerEnModeStats(){
//        this.laBase.setCenter(new BorderStats(this));
//    }
//
//    public void passerEnModeAide(){
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
