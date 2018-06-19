package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;


public class ActionTester implements EventHandler<ActionEvent> {


	private Mastermind partie;
	private Manche manche;


	public ActionTester(Mastermind partie,Manche manche) {
	    this.partie = partie;
	    this.manche = manche;
	}


	@Override
	public void handle(ActionEvent actionEvent) {
	    this.partie.getHistorique().setText(this.manche.getLog());
        ArrayList<Integer> verif = this.manche.calculBonPions();
        this.manche.incrNbCoup(verif.get(0),verif.get(1));
        if (this.partie.getATester().equals(this.manche.getCombi())){
            this.manche.finManche(true);
        }
        else{
          if(this.manche.getNbCoup()==10){
              this.manche.finManche(false);
          }
        }
	}
}
