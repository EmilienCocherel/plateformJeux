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
    private Scene seco,creer;
    private Login login;
    private CreeCompte creerC;
    private Menu seconnecter, creerCompte, quitter;
    private MenuItem aller,crea,seCo;
    private MenuBar menu;
    private VBox bar;

    public void init(){
        this.initMenuBar();
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
    public VBox getMenuBar(){
        this.initMenuBar();
        return this.bar;
    }


    @Override
    public void start(Stage stage) {
        this.init();
        this.creerC = new CreeCompte(this);
        this.login = new Login(this);

        window = stage;

        this.seco = new Scene(this.login.getPanelLogin(),800,600);
        this.creer = new Scene(this.creerC.getPanelCreer(), 800, 600);




        window.setScene(this.seco);
        window.setTitle("AJEL");
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
