package application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderCompte extends PageAdmin {

    AppliJDBC app;

    public BorderCompte(AppliJDBC app){
        super();
        this.app = app;

        Button bMenu = this.buttonTypePageAdmin("Accueil");
        bMenu.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bEnregistrer = this.buttonTypePageAdmin("Enregistrer");
        bEnregistrer.setOnAction(event -> this.app.passerEnModeCompte());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0,20,0,20));
        this.setMaxSize(800, 700);

        this.setTop(this.hboxTypeGrosPageAdmin("Pseudo : "));
        this.setCenter(this.tableauTypePageAdmin("Joueur\n(Nom du compte)", "Pseudo", "Email", "Actif"));
        this.setBottom(this.buttonBarTypePageAdmin(bMenu, bEnregistrer));
    }
}
