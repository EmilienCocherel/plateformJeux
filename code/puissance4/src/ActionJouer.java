package Connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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
	private LeJeu gui;

	public ActionJouer(Puissance4 puissance4, LeJeu gui) {
		this.puissance4 = puissance4;
		this.gui = gui;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Button b = (Button) actionEvent.getSource();
		Joueur courant = this.puissance4.getJoueurCourant();
		int i = Integer.parseInt(b.getText())-1;
		if (this.puissance4.jouer(i%7)) {
			this.gui.majAffichage();
			Alert alert = new Alert(AlertType.INFORMATION, "You've won round "+this.puissance4.getRound()+"!");
			alert.showAndWait();
			this.puissance4.getGagnants().add(courant);
			this.puissance4.getJoueur1().reset();
			this.puissance4.getJoueur2().reset();
			this.puissance4.getPlateau().reset();
		}
		// TODO: envoyer l'état de la partie à la bdd
		this.gui.majAffichage();
	}
}
