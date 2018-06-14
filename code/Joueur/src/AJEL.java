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

    private Button boutonMenuConnexion(String textB){
        Button boutonMenu = new Button();
        Text texteBoutonMenu = new Text(textB);
        texteBoutonMenu.setFont(new Font(14));
        boutonMenu.setStyle("-fx-background-color: transparent;");
        texteBoutonMenu.setFill(Color.WHITE);
        boutonMenu.setGraphic(texteBoutonMenu);

        return boutonMenu;

    }

    private void creerMenuConnexion(){
        VBox bar = new VBox();
        ButtonBar menu = new ButtonBar();

        Button seConnecter = this.boutonMenuConnexion("Se connecter");
        Button creerCompte = this.boutonMenuConnexion("Créer un compte");


        menu.setButtonData(seConnecter,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(creerCompte,ButtonBar.ButtonData.LEFT);
        menu.getButtons().addAll(seConnecter, creerCompte);
        menu.setBackground(new Background(new BackgroundFill(this.couleurDegradeBar(), null, null)));


        creerCompte.setOnAction(event -> this.passerEnModeInscription());
        seConnecter.setOnAction(event -> this.passerEnModeConnexion());

        bar.getChildren().add(menu);
        this.laBase.setTop(bar);
    }

    private void creerMenuJoueur(){
        VBox bar = new VBox();
        ButtonBar menu = new ButtonBar();

        Button partie = this.boutonMenuConnexion("Partie");
        Button jeux = this.boutonMenuConnexion("Jeux");
        Button invitations = this.boutonMenuConnexion("Invitations");
        Button amis = this.boutonMenuConnexion("Amis");
        Button messagerie = this.boutonMenuConnexion("Messagerie");
        Button compte = this.boutonMenuConnexion("Compte");
        Button seDeconnecter = this.boutonMenuConnexion("Se déconnecter");

        menu.setButtonData(partie,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(jeux,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(invitations,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(amis,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(messagerie,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(invitations,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(messagerie,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(compte,ButtonBar.ButtonData.LEFT);
        menu.setButtonData(seDeconnecter,ButtonBar.ButtonData.LEFT);
        menu.getButtons().addAll(partie, jeux, invitations, amis, messagerie, compte, seDeconnecter);
        menu.setBackground(new Background(new BackgroundFill(this.couleurDegradeBar(), null, null)));

        partie.setOnAction(event -> this.passerEnModePartieEnCours());
        jeux.setOnAction(event -> this.passerEnModeJeuxBoutique());
        invitations.setOnAction(event -> this.passerEnModeInvitations());

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

    public void passerEnModeJoueur(){
        this.creerMenuJoueur();
    }

    public void passerEnModeJeuxPossede(){
        this.laBase.setCenter(new BorderJeuxPossede(this));
    }

    public void passerEnModeJeuxBoutique(){
        this.laBase.setCenter(new BorderJeuxBoutique(this));
    }

    public void passerEnModeInvitations(){
        this.laBase.setCenter(new BorderInvitations(this));
    }

    public void passerEnModePartieEnCours(){
        this.creerMenuJoueur();
        this.laBase.setCenter(new BorderPartieEnCours(this));
    }

    public void passerEnModePartieHistorique(){
        this.laBase.setCenter(new BorderPartieHistorique(this));
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

        stage.setScene( new Scene(this.laBase,1000,800));
        stage.setTitle("AJEL");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
