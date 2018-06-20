package mastermind;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

public class PartieFinie {
	Integer score1, score2;
	Label message, score2Label;
	Scene scene;

	public PartieFinie(Mastermind mastermind) {
		this.score1 = 3033;
		this.score2 = null;
		this.score2Label = new Label();
		this.message = new Label();
		this.setScore2Label();
		this.setMessage();
		GridPane tableau = new GridPane();
		tableau.add(new Label("Vous"), 1, 1);
		tableau.add(new Label("Votre adversaire"), 2, 1);
		tableau.add(new Label(this.score1.toString()), 1, 2);
		tableau.add(this.score2Label, 2, 2);

		VBox pane = new VBox();
		pane.getChildren().add(this.message);
		pane.getChildren().add(tableau);
		this.scene = new Scene(pane, 500, 600);
	}

	private void setMessage() {
		if (this.score2 == null)
			message.setText("Votre adversaire n'a pas encore terminé.");
		else if (this.score1 == this.score2)
			message.setText("Égalité.");
		else if (this.score1 > this.score2)
			message.setText("Vous avez gagné ! Bravo.");
		else
			message.setText("Vous avez perdu.");
	}

	private void setScore2Label() {
		if (this.score2 == null)
			this.score2Label.setText("En attente...");
		else
			this.score2Label.setText(this.score2.toString());
	}

	public Scene getScene() {
		return this.scene;
	}
}
