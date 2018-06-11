import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur du plateau
 */
public class ActionJouer implements EventHandler<ActionEvent> {
	/**
	 * Modèle du jeu
	 */
	private Puissance4 puissance4;
	/**
	 * Vue du jeu
	 */
	private GUI gui;

	public ActionJouer(Puissance4 puissance4, GUI gui) {
		this.puissance4 = puissance4;
		this.gui = gui;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Button b = (Button) actionEvent.getSource();
		int i = this.gui.getPlateau().getPions().indexOf(b);
		this.puissance4.jouer(i%7);
	}
}
