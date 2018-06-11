import java.util.List;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PlateauGUI extends GridPane {
	private Plateau plateau;
	private List<Circle> pions;

	public PlateauGUI(Plateau plateau, EventHandler<ActionEvent> actionJouer) {
		this.plateau = plateau;
		this.pions = new ArrayList<>();
		Circle c;
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i%7, i/7);
			c = new Circle(10);
			PlateauGUI.setCouleur(pion, c);
			this.pions.add(c);
			this.add(c, i%7, i/7);
		}
	}

	public void maj() {
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i%7, i/7);
			PlateauGUI.setCouleur(pion, this.pions.get(i));
		}
	}

	public static void setCouleur(Integer pion, Circle cercle) {
		if (pion == null)
			cercle.setFill(Color.LIGHTGRAY);
		else if (pion == 1)
			cercle.setFill(Color.YELLOW);
		else
			cercle.setFill(Color.BLUE);
	}


	public List<Circle> getPions() {
		return this.pions;
	}
}
