import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BorderChgmntInfo extends PageJoueur{

    private AJEL app;

    public BorderChgmntInfo(AJEL app) {
        super();
        this.app = app;

        GridPane infoCentre = new GridPane();

        ComboBox infoSexe = new ComboBox();
        infoSexe.getItems().setAll("Homme","Femme","Autre");

        infoCentre.add(this.labelGrosPageJoueur("Pseudo : "),0,0);
        infoCentre.add(new TextField(),1,0);
        infoCentre.add(this.labelGrosPageJoueur("Sexe : "),0,1);
        infoCentre.add(infoSexe,1,1);
        infoCentre.add(this.labelGrosPageJoueur("Mot de passe : "),0,2);
        infoCentre.add(new TextField(),1,2);
        infoCentre.add(this.labelGrosPageJoueur("Prenium : "),0,3);
        infoCentre.add(this.lienTypePageJoueur("Acheter un compte prenium"),1,3);
        infoCentre.setPadding(new Insets(30, 30, 10, 10));

        Button sauvegarder = this.buttonTypePageJoueur("Sauvegarder");

        Button annuler = this.buttonTypePageJoueur("Annuler");

        ButtonBar barBot = this.buttonBarTypePageJoueur(sauvegarder,annuler);

        this.setCenter(infoCentre);
        this.setBottom(barBot);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);



    }


}
