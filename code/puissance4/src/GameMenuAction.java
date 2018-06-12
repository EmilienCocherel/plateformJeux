import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.control.MenuItem;

public class GameMenuAction implements EventHandler<ActionEvent> {
	/**
	 * Modèle du jeu
	 */
	private Puissance4 puissance4;

	public GameMenuAction(Puissance4 puissance4) {
		this.puissance4 = puissance4;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		MenuItem menu = (MenuItem) actionEvent.getSource();
		String text = menu.getText();
		if (text.equals("Leave")) {
			System.out.println(this.puissance4.toJson());
			Platform.exit();
		}
	}
}
