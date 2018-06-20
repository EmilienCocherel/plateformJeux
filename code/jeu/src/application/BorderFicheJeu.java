package application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BorderFicheJeu extends PageAdmin {

    AppliJDBC app;

    public BorderFicheJeu(AppliJDBC app){
        super();
        this.app = app;

        Button bMenu = this.buttonTypePageAdmin("Accueil");
        bMenu.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bEnregistrer = this.buttonTypePageAdmin("Enregistrer");
        bEnregistrer.setOnAction(event -> this.app.passerEnModeGererJeux());

        GridPane cotegauche = new GridPane();

        cotegauche.add(this.labelTypePageAdmin("Titre :"),0,0);
        cotegauche.add(this.labelTypePageAdmin("<Titre>"),1,0);
        cotegauche.add(this.labelTypePageAdmin("Type de jeu : "),0,4);
        cotegauche.add(this.comboBoxAdmin("TpT","Simultané"),1,4);
        cotegauche.setPadding(new Insets(30, 30, 10, 10));

        GridPane cotehaut= new GridPane();

        cotehaut.add(this.imageTypePageAdmin(),0,0);
        cotehaut.add(cotegauche,1,0);
        cotehaut.setPadding(new Insets(30, 30, 10, 10));

        GridPane cotebas = new GridPane();


        cotebas.add(this.labelTypePageAdmin("Description : "),0,1);
        cotebas.add(this.textAeraHorizontalNonEditable(),1,1);
        cotebas.setPadding(new Insets(30, 30, 10, 10));



        this.setTop(cotehaut);
        this.setCenter(cotebas);
        this.setBottom(this.buttonBarTypePageAdmin(bMenu, bEnregistrer));


        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0,20,0,20));
        this.setMaxSize(800, 700);
    }
}
