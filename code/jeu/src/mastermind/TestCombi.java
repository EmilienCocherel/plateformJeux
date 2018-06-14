package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

import java.util.Optional;

/**
 * Controleur du bouton "tester" dans la classe Mastermind
 */
public class TestCombi implements EventHandler<ActionEvent> {


    private Mastermind partie;
    private Manche manche;


    public TestCombi(Mastermind partie,Manche manche) {
        this.partie = partie;
        this.manche = manche;
    }

    /**
     * gère le bouton tester
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button rb =(Button) actionEvent.getSource();
        System.out.print(this.partie.getCombi());
        System.out.print(this.manche.getCombi());
        if (this.partie.getCombi().equals(this.manche.getCombi())){
            this.manche.finManche();
        }
        else{

        }
        this.partie.majAffichage();
    }
}
