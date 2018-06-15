package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


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
        this.manche.incrNbCoup();
        System.out.println(this.manche.getNbCoup());
        if (this.partie.getATester().equals(this.manche.getCombi())){
            this.manche.addToLog("bonne combinaison\n");
            this.manche.finManche(true);
        }
        else{
          this.manche.addToLog("mauvaise combinaison\n");
          if(this.manche.getNbCoup()==9){
              this.manche.finManche(false);
          }
        }
	}
}
