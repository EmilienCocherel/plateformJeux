package connect4;


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
			this.gui.gagnerManche(this.puissance4.getRound());
			this.puissance4.getGagnants().add(courant);

			// Si la partie est finie
			if (this.puissance4.getRound() > 3) {
				if (this.puissance4.getGagnant() == courant) {
					this.gui.gagner();
				} else {
					this.gui.perdre();
				}
			}

			// Remettre tout à zéro
			this.puissance4.getJoueur1().reset();
			this.puissance4.getJoueur2().reset();
			this.puissance4.getPlateau().reset();
		}
		this.gui.setEtat();
		this.gui.majAffichage();
	}
}
