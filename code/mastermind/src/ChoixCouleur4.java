import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

import java.util.Optional;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ChoixCouleur4 implements EventHandler<ActionEvent> {


	private Mastermind partie;
	private Manche manche;


	public ChoixCouleur4(Mastermind partie,Manche manche) {
	    this.partie = partie;
	    this.manche = manche;
	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
		RadioButton rb =(RadioButton) actionEvent.getSource();
		if (rb.getText()=="rouge"){
			partie.getCombi().setP4(0);
		}
		if (rb.getText()=="bleu"){
			partie.getCombi().setP4(1);
		}
		if (rb.getText()=="vert"){
			partie.getCombi().setP4(2);
		}
		if (rb.getText()=="jaune"){
			partie.getCombi().setP4(3);
		}
		partie.majAffichage();
	}
}
