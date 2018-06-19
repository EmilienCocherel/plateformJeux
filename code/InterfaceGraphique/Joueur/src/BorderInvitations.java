import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BorderInvitations extends PageJoueur {

    AJEL app;

    public BorderInvitations(AJEL app){
        super();
        this.app = app;



        GridPane recues = new GridPane();

        recues.add(this.titlePageJouer("Reçues"), 0, 0);
        recues.add(this.tableauTypePageJouer("Jeu", "Joueur", "Date"),0,1);
        recues.add(this.buttonBarTypePageJoueur("Accepter", "Refuser"),0,2);
        recues.setPadding(new Insets(10, 10, 10, 30));

        GridPane envoyees = new GridPane();

        envoyees.add(this.titlePageJouer("Envoyées"), 1, 0);
        envoyees.add(this.tableauTypePageJouer("Jeu", "Joueur", "Date"), 1, 1);
        envoyees.add(this.titlePageJouer("Inviter des amis"), 1, 2);
        envoyees.add(this.hboxTypePageJoueur("Ami : "), 1, 3);
        envoyees.add(this.hboxTypePageJoueur("Jeu : "),1, 4);
        envoyees.setPadding(new Insets(10, 30, 10, 10));

        GridPane sceneCentre = new GridPane();
        sceneCentre.add(recues,0,0);
        sceneCentre.add(envoyees,1,0);

        this.setCenter(sceneCentre);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);
    }
}
