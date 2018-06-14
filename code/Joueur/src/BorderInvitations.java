import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BorderInvitations extends PageJoueur {

    AJEL app;

    public BorderInvitations(AJEL app){
        super();
        this.app = app;

        GridPane recues = new GridPane();

        recues.add(this.titlePageJouer("Reçues"), 0, 0);
        recues.add(this.tableauTypePageJouer("Jeu", "Joueur", "Date"),0,1);
        recues.add(this.buttonBarTypePageJoueur("Accepter", "Refuser"),0,2);

        GridPane envoyees = new GridPane();

        envoyees.add(this.titlePageJouer("Envoyées"), 1, 0);
        envoyees.add(this.tableauTypePageJouer("Jeu", "Joueur", "Date"), 1, 1);
        envoyees.add(this.titlePageJouer("Inviter des amis"), 1, 2);
        envoyees.add(this.hboxTypePageJoueur("Ami : "), 1, 3);
        envoyees.add(this.hboxTypePageJoueur("Jeu : "),1, 4);

        this.setLeft(recues);
        this.setRight(envoyees);
    }
}
