package application;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class ActionClicMessage implements EventHandler<MouseEvent> {
	private IMessagerie messagerie;

	public ActionClicMessage(IMessagerie messagerie) {
		this.messagerie = messagerie;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
	}
}
