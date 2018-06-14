package Connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class GameMenuAction implements EventHandler<ActionEvent> {
	/**
	 * Modèle du jeu
	 */
	private Puissance4 puissance4;

	/**
	 * Vue du jeu
	 */
	private LeJeu gui;

	public GameMenuAction(Puissance4 puissance4, LeJeu gui) {
		this.puissance4 = puissance4;
		this.gui = gui;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		MenuItem menu = (MenuItem) actionEvent.getSource();
		String text = menu.getText();
		if (text.equals("Leave")) {
			// TODO
			this.puissance4.toJson();
			Platform.exit();
		} else if (text.equals("Surrender")) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to surrender?");
			alert.setTitle("Surrender");
			alert.setHeaderText("Surrender");
			alert.showAndWait()
				.filter(response -> response == ButtonType.OK)
				.ifPresent(response -> this.gui.abandonner());
		} else if (text.equals("Score tab")) {
			// TODO
			System.out.println("Score tab");
		}
	}

	/**
	 * Affiche les gagnants de chaque manche
	 */
	public void afficheManches() {
		// TODO
	}
}
