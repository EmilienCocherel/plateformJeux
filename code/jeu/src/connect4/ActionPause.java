package connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur du plateau
 */
public class ActionPause implements EventHandler<ActionEvent> {
	/**
	 * Vue du jeu
	 */
	private LeJeu gui;

	public ActionPause(LeJeu gui) {
		this.gui = gui;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Button b = (Button) actionEvent.getSource();
		this.gui.pause();
		if (this.gui.isPause())
			b.setText("Resume game");
		else
			b.setText("Pause game");
		this.gui.setEtat();
		this.gui.majAffichage();
	}
}
