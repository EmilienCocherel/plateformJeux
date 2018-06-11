import java.util.List;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PlateauGUI extends GridPane {
	private Plateau plateau;
	private List<Button> controles;
	private List<Circle> pions;

	public PlateauGUI(Plateau plateau, EventHandler<ActionEvent> actionJouer) {
		this.plateau = plateau;
		this.controles = new ArrayList<>();
		Button b;
		for (int i=0; i < 7; i++) {
			b = new Button(""+(i+1));
			b.setOnAction(actionJouer);
			this.controles.add(b);
			this.add(b, i, 0);
		}
		this.pions = new ArrayList<>();
		Circle c;
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i%7, i/7);
			c = new Circle(10);
			PlateauGUI.setCouleur(pion, c);
			this.pions.add(c);
			this.add(c, i%7, i/7+1);
		}
	}

	public void maj() {
		for (int i=0; i < 7; i++) {
			if (this.plateau.getColonne(i).contains(null))
				this.controles.get(i).setDisable(false);
			else
				this.controles.get(i).setDisable(true);
		}
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i/7, i%7);
			PlateauGUI.setCouleur(pion, this.pions.get(i));
		}
	}

	public static void setCouleur(Integer pion, Circle cercle) {
		if (pion == null)
			cercle.setFill(Color.LIGHTGRAY);
		else if (pion == 1)
			cercle.setFill(Color.YELLOW);
		else
			cercle.setFill(Color.RED);
	}


	public List<Circle> getPions() {
		return this.pions;
	}
}
