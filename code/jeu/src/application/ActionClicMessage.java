package application;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class ActionClicMessage implements EventHandler<MouseEvent> {
	private AbstractMessagerie messagerie;

	public ActionClicMessage(AbstractMessagerie messagerie) {
		this.messagerie = messagerie;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
	}
}
