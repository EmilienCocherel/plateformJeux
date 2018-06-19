package connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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
		MenuItem menu = (MenuItem) actionEvent.getSource();
		String text = menu.getText();
		if (text.equals("About")) {
			Alert alert = new Alert(AlertType.INFORMATION, "");
			alert.showAndWait();
		} else if (text.equals("Tutorial")) {
			Alert alert = new Alert(AlertType.INFORMATION, "each player is assign to a disk's color.\nThe first player is the yellow one.\n\nEach palyer takes turns dropping one colored disc\nfrom the top into a seven-column,\nsix-row vertically suspended grid.\n\nThe pieces fall straight down, occupying\nthe next available space within the column.\n\nThe objective of the game is to be\nthe first to form a horizontal,\nvertical, or diagonal line of\nfour of one's own discs.");
			alert.setTitle("Tutorial");
			alert.setHeaderText("Tutorial");
			alert.showAndWait();
		}
	}
}
