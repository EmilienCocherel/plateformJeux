import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class ApplicationAJEL extends Application {
    private Stage window;
    private Scene seco,creer,sBoutique, sJeuxPossede;
    private JeuxBoutique boutique;
    private Login login;
    private CreeCompte creerC;
    public JeuxPossede jeuxPossede;
    private Menu seconnecter, creerCompte, quitter, partie, jeux, invitations, amis, messagerie, compte, seDeco;
    private MenuItem aller,crea,seCo;
    private MenuBar menu;
    private VBox bar, barJoueur;

    public void init(){
        this.initMenuBar();
    }

    public void initJoueur(){
        this.initMenuBarJoueur();
    }

    public void initMenuBar() {
        this.bar = new VBox();

        this.menu = new MenuBar();

        this.seconnecter = new Menu("Se connecter");
        this.seCo = new MenuItem("Se connecter");
        this.seconnecter.getItems().add(this.seCo);
        this.creerCompte = new Menu("Créer un compte");
        this.crea = new MenuItem("Création du compte");
        this.creerCompte.getItems().add(this.crea);


        this.menu.getMenus().addAll(this.seconnecter, this.creerCompte);

        Stop[] stops = new Stop[] { new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123,41,67))};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);
        this.menu.setBackground(new Background(new BackgroundFill(lg1, null, null)));

        this.creerCompte.setOnAction(event -> window.setScene(this.creer));
        this.seconnecter.setOnAction(event -> window.setScene(this.seco));

        this.bar.getChildren().add(this.menu);

    }

    public void initMenuBarJoueur() {
        this.barJoueur = new VBox();

        this.menu = new MenuBar();

        this.partie = new Menu("Partie");
        this.jeux = new Menu("Jeux");
        this.invitations = new Menu("Invitations");
        this.amis = new Menu("Amis");
        this.messagerie = new Menu("Messagerie");
        this.compte = new Menu("Compte");
        this.seDeco = new Menu("Se déconnecter");

        this.menu.getMenus().addAll(this.partie, this.jeux, this.invitations, this.amis, this.messagerie, this.compte, this.seDeco);

        Stop[] stops = new Stop[] { new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123,41,67))};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);
        this.menu.setBackground(new Background(new BackgroundFill(lg1, null, null)));

        this.creerCompte.setOnAction(event -> window.setScene(this.creer));
        this.seconnecter.setOnAction(event -> window.setScene(this.seco));

        this.barJoueur.getChildren().add(this.menu);

    }

    public VBox getMenuBarJoueur(){
        this.initMenuBarJoueur();
        return this.barJoueur;
    }

    public VBox getMenuBar(){
        this.initMenuBar();
        return this.bar;
    }


    @Override
    public void start(Stage stage) {
        this.init();
        this.initJoueur();
        this.creerC = new CreeCompte(this);
        this.login = new Login(this);
        this.boutique = new JeuxBoutique(this);
        this.jeuxPossede = new JeuxPossede(this);

        window = stage;

        this.seco = new Scene(this.login.getPanelLogin(),800,600);
        this.creer = new Scene(this.creerC.getPanelCreer(), 800, 600);
        this.sBoutique = new Scene(this.boutique.getCont(),1000,800);
        this.sJeuxPossede = new Scene(this.jeuxPossede.getCont(), 1000, 800);

        window.setScene(this.sBoutique);
        window.setTitle("AJEL");
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
