import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
