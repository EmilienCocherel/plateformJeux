package application;

import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Button;
import javafx.scene.Node;
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

import java.util.*;

import static javafx.scene.control.ButtonBar.BUTTON_ORDER_LINUX;
import static javafx.scene.control.ButtonBar.BUTTON_ORDER_NONE;

public class ApplicationAJEL extends ButtonBar{
    private List<String>  menuPrinc;
    private ArrayList<MenuItem> lesItems;
    private AppliJDBC app;
    private ControleurMenu controleurMenu;
    private VBox bar;


    ApplicationAJEL(AppliJDBC app){
        super();
        // this.menuPrinc = new ArrayList<>();
        // this.menuPrinc.add("Se connecter");
        // this.menuPrinc.add("Créer un compte");
        this.app=app;
        // this.lesItems=new ArrayList<MenuItem>();
        this.controleurMenu = new ControleurMenu(app);
        // for (String menu:this.menuPrinc){
        //     Button m = new Button(menu);
        //     // m.setDisable(true);
        //     // for (int i=1;i<listeMenu.length;i++){
        //     //     MenuItem mi=new MenuItem(listeMenu[i]);
        //     //     mi.setId(""+i);
        //     //     mi.setOnAction(controleurMenu);
        //     //     lesItems.add(mi);
        //     //     m.getItems().add(mi);
        //     // }
        //     this.getButtons().add(m);
        // }
        // this.getButtons().get(0).setDisable(false);
        // this.lesItems.get(1).setDisable(true);
    }

    public void connecter(){
        for (Node m:this.getButtons()){
            m.setDisable(false);
        }
        // lesItems.get(0).setDisable(true);
        // lesItems.get(1).setDisable(false);

    }

    public void deconnecter(){
        for (Node m:this.getButtons()){
            m.setDisable(false);
        }
        this.getButtons().get(0).setDisable(false);
        // lesItems.get(0).setDisable(false);
        // lesItems.get(1).setDisable(true);

    }

    //IHM
    public Button boutonMenuConnexion(String textB){
        Button boutonMenu = new Button();
        Text texteBoutonMenu = new Text(textB);
        texteBoutonMenu.setFont(new Font(14));
        boutonMenu.setStyle("-fx-background-color: transparent;");
        texteBoutonMenu.setFill(Color.WHITE);
        boutonMenu.setGraphic(texteBoutonMenu);

        return boutonMenu;
    }

    private Menu MenuConnexion(String textB){
        Menu menu = new Menu();
        Text texteBoutonMenu = new Text(textB);
        texteBoutonMenu.setFont(new Font(14));
        menu.setStyle("-fx-background-color: transparent;");
        texteBoutonMenu.setFill(Color.WHITE);
        menu.setGraphic(texteBoutonMenu);

        return menu;

    }


    public void creerMenuConnexion(){
        VBox bar = new VBox();
        // ButtonBar menu = new ButtonBar();

        Button seConnecter = this.boutonMenuConnexion("Se connecter");
        // Button  seConnecter = (Button) this.getButtons().get(0);
        Button creerCompte = this.boutonMenuConnexion("Créer un compte");
        // Button  creerCompte = (Button) this.getButtons().get(1);
        // this.

        this.setButtonData(seConnecter,ButtonBar.ButtonData.LEFT);
        this.setButtonData(creerCompte,ButtonBar.ButtonData.LEFT);
        this.getButtons().addAll(seConnecter, creerCompte);
        this.setBackground(new Background(new BackgroundFill(this.couleurDegradeBar(), null, null)));


        creerCompte.setOnAction(event -> this.app.passerEnModeInscription());
        seConnecter.setOnAction(event -> this.app.passerEnModeDeConnexion());

        bar.getChildren().add(this);
        this.app.getLaBase().setTop(bar);
    }

    public void creerMenuJoueur(){
        this.bar = new VBox();
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

        partie.setOnAction(event -> this.app.passerEnModePartieEnCours());
        jeux.setOnAction(event -> this.app.passerEnModeJeuxPossede());
        invitations.setOnAction(event -> this.app.passerEnModeInvitations());
        amis.setOnAction(event -> this.app.passerEnModeMesAmis());
        messagerie.setOnAction(event -> this.app.passerEnModeMessagerieRecus());
        compte.setOnAction(event -> this.app.passerEnModeProfilUtilisateur());
        seDeconnecter.setOnAction(event -> this.app.passerEnModeConnexion());

        this.bar.getChildren().add(menu);
        this.app.getLaBase().setTop(this.bar);

    }
    public VBox getBarJoueur(){
      return this.bar;
    }
    public void creerMenuAdministrateur(){
        VBox bar = new VBox();
        MenuBar menu = new MenuBar();

        MenuItem ajouterJeu = new MenuItem("Ajouter un jeu");
        ajouterJeu.setOnAction(event -> this.app.passerEnModeAjouterJeu());

        MenuItem gererJeu = new MenuItem("Gérer un jeu");
        gererJeu.setOnAction(event -> this.app.passerEnModeGererJeux());

        MenuItem gererCompte = new MenuItem("Gérer un compte");
        gererCompte.setOnAction(event -> this.app.passerEnModeCompte());

        MenuItem lireRapport = new MenuItem("Lire un rapport");
        lireRapport.setOnAction(event -> this.app.passerEnModeRapport());

        MenuItem redigerRapport = new MenuItem("Rédiger un rapport");
        redigerRapport.setOnAction(event -> this.app.passerEnModeRapportRediger());

        MenuItem lireStats = new MenuItem("Lire des statistiques");
        lireStats.setOnAction(event -> this.app.passerEnModeStats());

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
        this.app.getLaBase().setTop(bar);
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

    public void colorerLaBase(){
        this.app.getLaBase().setBackground(new Background(new BackgroundFill(this.couleurDegradeCentre(), null, null)));
    }

}
