package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.EventObject;

class ActionLesJeux implements EventHandler<ActionEvent> {
    private BoutonJouer bj;

    public ActionLesJeux(BoutonJouer bj){
      this.bj=bj;
    }

    @Override
    public void handle(ActionEvent e){
    	bj.chargerJeu();
    }
}
