package Connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Dialog;

import java.util.List;
import java.util.ArrayList;

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
			this.afficheManches();
		}
	}

	/**
	 * Affiche les gagnants de chaque manche
	 */
	public void afficheManches() {
		Dialog fenetre = new Dialog();
		DialogPane root = new DialogPane();
		GridPane content = new GridPane();
		List<Circle> pions = new ArrayList<>();
		fenetre.initOwner(this.gui.getPlateau().getScene().getWindow());
		fenetre.setDialogPane(root);
		root.setContent(content);
		for (int i=0; i < 3; i++) {
			pions.add(new Circle(40));
			pions.get(i).getStyleClass().addAll("pion", "no-pause");
			if (this.puissance4.getRound()-1 > i) {
				if (this.puissance4.getGagnants().get(i).getPion() == 1)
					pions.get(i).setId("joueur1");
				else
					pions.get(i).setId("joueur2");
				content.add(new Label(this.puissance4.getGagnants().get(i).getNom()), 2, i+1);
			} else
				content.add(new Label("Not yet"), 2, i+1);
			content.add(pions.get(i), 1, i+1);
		}
		fenetre.showAndWait();
		// TODO: gérer la fermeture du dialogue :(
	}
}
