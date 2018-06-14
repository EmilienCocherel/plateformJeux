package connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HelpMenuAction implements EventHandler<ActionEvent> {
	/**
	 * Modèle du jeu
	 */
	private Puissance4 puissance4;

	public HelpMenuAction(Puissance4 puissance4) {
		this.puissance4 = puissance4;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
	}
}
