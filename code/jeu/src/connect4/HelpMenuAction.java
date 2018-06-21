package connect4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;

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
		if (text.equals("About us")) {
			Alert alert = new Alert(AlertType.INFORMATION, "Nous somme la team AJEL,\nC'est nous qui avons codé ce jeu avec le reste de la plateforme pour notre projet de fin d'année à l'IUT informatique d'Orléans.\nRejoignez nous du côté gris de la force.\nL'équipe se compose de:\nAurélien Desprez, Emilien Cocherel\nEdwin Charlotte, Quentin Bernard\nAmélie Dauvois, Etienne Fouquet");
			alert.setTitle("About us");
			alert.setHeaderText("About us");
			alert.setGraphic(new ImageView("../img/about_us.gif"));
			((ImageView)alert.getGraphic()).setFitHeight(60.0);
			((ImageView)alert.getGraphic()).setFitWidth(60.0);
			alert.setResizable(true);
			alert.showAndWait();
		} else if (text.equals("Tutorial")) {
			Alert alert = new Alert(AlertType.INFORMATION, "Each player is assign to a disk's color.\nThe first player is the yellow one.\n\nEach player takes turns dropping one colored disc\nfrom the top into a seven-column,\nsix-row vertically suspended grid.\n\nThe pieces fall straight down, occupying\nthe next available space within the column.\n\nThe objective of the game is to be\nthe first to form a horizontal,\nvertical, or diagonal line of\nfour of one's own discs.");
			alert.setTitle("Tutorial");
			alert.setHeaderText("Tutorial");
			alert.setGraphic(new ImageView("../img/connect4.gif"));
			((ImageView)alert.getGraphic()).setFitHeight(180.0);
			((ImageView)alert.getGraphic()).setFitWidth(180.0);
			alert.showAndWait();
		}
	}
}
