import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;

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
		if (rb.getPion().getVal()==1){
			if (rb.getText()=="rouge"){
				partie.getCombi().setP1(0);
			}
			if (rb.getText()=="bleu"){
				partie.getCombi().setP1(1);
			}
			if (rb.getText()=="vert"){
				partie.getCombi().setP1(2);
			}
			if (rb.getText()=="jaune"){
				partie.getCombi().setP1(3);
			}
		}

		if (rb.getPion().getVal()==2){
			if (rb.getText()=="rouge"){
				partie.getCombi().setP2(0);
			}
			if (rb.getText()=="bleu"){
				partie.getCombi().setP2(1);
			}
			if (rb.getText()=="vert"){
				partie.getCombi().setP2(2);
			}
			if (rb.getText()=="jaune"){
				partie.getCombi().setP2(3);
			}
		}

		if (rb.getPion().getVal()==3){
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
		}

		if (rb.getPion().getVal()==4){
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
		}
		partie.majAffichage();
	}
}
