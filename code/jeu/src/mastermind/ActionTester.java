package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

import java.util.Optional;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ActionTester implements EventHandler<ActionEvent> {


	private Mastermind partie;
	private Manche manche;


	public ActionTester(Mastermind partie,Manche manche) {
	    this.partie = partie;
	    this.manche = manche;
	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
    if (this.partie.getCombi().equals(this.manche.getCombi())){
      this.manche.addToLog("bonne combinaison\n");
    }
    else{
      this.manche.addToLog("mauvaise combinaison\n");
    }
    this.partie.getHistorique().setText(this.manche.getLog());
	}
}
