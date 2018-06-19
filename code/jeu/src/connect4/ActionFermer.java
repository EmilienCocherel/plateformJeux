package connect4;

import javafx.stage.WindowEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur de la fermeture
 */
public class ActionFermer implements EventHandler<WindowEvent> {
	/**
	 * Vue du jeu
	 */
	private LeJeu gui;

	public ActionFermer(LeJeu gui) {
		this.gui = gui;
	}

	@Override
	public void handle(WindowEvent windowEvent) {
		this.gui.fermer();
	}
}
