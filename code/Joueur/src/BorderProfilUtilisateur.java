import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderProfilUtilisateur extends PageJoueur {

    AJEL app;

    public BorderProfilUtilisateur(AJEL app){
        super();
        this.app = app;



        GridPane gInfo = new GridPane();
        gInfo.add(this.titlePageJouer("Pseudo"), 0, 0);
        gInfo.add(this.labelTypePageJoueur("..."), 1, 0);
        gInfo.add(this.titlePageJouer("Niveau"), 0, 1);
        gInfo.add(this.labelTypePageJoueur("..."), 1, 1);
        gInfo.add(this.titlePageJouer("Premium"), 0, 2);
        gInfo.add(this.labelTypePageJoueur("..."), 1, 2);
        gInfo.add(this.titlePageJouer("Date d'inscription"), 0, 3);
        gInfo.add(this.labelTypePageJoueur("..."), 1, 3);
        gInfo.setPadding(new Insets(50, 0, 0, 50));

        Button changerInfo = this.buttonTypePageJoueur("Changer information compte");
        changerInfo.setOnAction(event -> this.app.passerEnModeChgmntInfo());

        Button consulterstats = this.buttonTypePageJoueur("Consutler statistiques");

        ButtonBar bar = this.buttonBarTypePageJoueur(changerInfo, consulterstats);
        bar.setPadding(new Insets(0,0,50,0));

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);

        this.setCenter(gInfo);
        this.setBottom(bar);
    }
}
