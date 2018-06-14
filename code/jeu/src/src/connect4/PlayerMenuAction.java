package connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class PlayerMenuAction implements EventHandler<ActionEvent> {
	/**
	 * Modèle du jeu
	 */
	private Puissance4 puissance4;

	public PlayerMenuAction(Puissance4 puissance4) {
		this.puissance4 = puissance4;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		MenuItem menu = (MenuItem) actionEvent.getSource();
		String text = menu.getText();
		if (text.equals("Opponent's stats")) {
			// TODO
			System.out.println("Opponent's stats");
		} else if (text.equals("Send messages")) {
			// TODO
			System.out.println("Send messages");
		}
	}
}
