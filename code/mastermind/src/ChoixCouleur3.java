import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

import java.util.Optional;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ChoixCouleur3 implements EventHandler<ActionEvent> {


	private Mastermind partie;
	private Manche manche;


	public ChoixCouleur3(Mastermind partie,Manche manche) {
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
			partie.getCombi().setP3(0);
		}
		if (rb.getText()=="bleu"){
			partie.getCombi().setP3(1);
		}
		if (rb.getText()=="vert"){
			partie.getCombi().setP3(2);
		}
		if (rb.getText()=="jaune"){
			partie.getCombi().setP3(3);
		}
		partie.majAffichage();
	}
}
