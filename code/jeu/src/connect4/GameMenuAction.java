package connect4;

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
			this.gui.fermer();
		} else if (text.equals("Surrender")) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to surrender?");
			alert.showAndWait()
				.filter(response -> response == ButtonType.OK)
				.ifPresent(response -> this.gui.abandonner());
		} else if (text.equals("Score tab")) {
			int j1=0;
			int j2=0;
			for (Joueur gagnant : this.puissance4.getGagnants()) {
				if (gagnant == this.puissance4.getJoueur1()){
					j1++;
				}
				if (gagnant == this.puissance4.getJoueur2()){
					j2++;
				}
			}
			Alert alert = new Alert(AlertType.INFORMATION, "round win by Player1:"+j1+"\nround win by Player2:"+j2);
			alert.setTitle("Score Tab");
			alert.setHeaderText("Score Tab");
			alert.showAndWait();
			System.out.println(j1);
			System.out.println(j2);
			System.out.println(alert);
			System.out.println("Score tab");
		}
	}
}
