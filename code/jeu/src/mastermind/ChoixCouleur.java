package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

import java.util.Optional;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ChoixCouleur implements EventHandler<ActionEvent> {


	private Mastermind partie;
	private Manche manche;


	public ChoixCouleur(Mastermind partie,Manche manche) {
	    this.partie = partie;
	    this.manche = manche;
	}

	/**
	 * gère le changement de niveau
	 * @param actionEvent
	 */
	@Override
	public void handle(ActionEvent actionEvent) {
		BoutonRadio rb =(BoutonRadio) actionEvent.getSource();
		if (rb.getPion().getVal()==0){
			if (rb.getText()=="rouge"){
				partie.getATester().getP1().setFill(Color.RED);
			}
			if (rb.getText()=="bleu"){
				partie.getATester().getP1().setFill(Color.BLUE);
			}
			if (rb.getText()=="vert"){
				partie.getATester().getP1().setFill(Color.GREEN);
			}
			if (rb.getText()=="jaune"){
				partie.getATester().getP1().setFill(Color.YELLOW);
			}
		}

		if (rb.getPion().getVal()==1){
			if (rb.getText()=="rouge"){
				partie.getATester().getP2().setFill(Color.RED);
			}
			if (rb.getText()=="bleu"){
				partie.getATester().getP2().setFill(Color.BLUE);
			}
			if (rb.getText()=="vert"){
				partie.getATester().getP2().setFill(Color.GREEN);
			}
			if (rb.getText()=="jaune"){
				partie.getATester().getP2().setFill(Color.YELLOW);
			}
		}

		if (rb.getPion().getVal()==2){
			if (rb.getText()=="rouge"){
				partie.getATester().getP3().setFill(Color.RED);
			}
			if (rb.getText()=="bleu"){
				partie.getATester().getP3().setFill(Color.BLUE);
			}
			if (rb.getText()=="vert"){
				partie.getATester().getP3().setFill(Color.GREEN);
			}
			if (rb.getText()=="jaune"){
				partie.getATester().getP3().setFill(Color.YELLOW);
			}
		}

		if (rb.getPion().getVal()==3){
			if (rb.getText()=="rouge"){
				partie.getATester().getP4().setFill(Color.RED);
			}
			if (rb.getText()=="bleu"){
				partie.getATester().getP4().setFill(Color.BLUE);
			}
			if (rb.getText()=="vert"){
				partie.getATester().getP4().setFill(Color.GREEN);
			}
			if (rb.getText()=="jaune"){
				partie.getATester().getP4().setFill(Color.YELLOW);
			}
		}
		partie.majAffichage();
	}
}
