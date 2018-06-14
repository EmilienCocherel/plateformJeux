package connect4;

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
	private LeJeu gui;
	private List<Button> controles;
	private List<Circle> pions;

	public PlateauGUI(Plateau plateau, LeJeu gui, EventHandler<ActionEvent> actionJouer) {
		this.plateau = plateau;
		this.gui = gui;
		this.controles = new ArrayList<>();
		Button b;
		for (int i=0; i < 7; i++) {
			b = new Button(""+(i+1));
			b.setOnAction(actionJouer);
			b.getStyleClass().add("bouton_jouer");
			this.controles.add(b);
			this.add(b, i, 0);
		}
		this.pions = new ArrayList<>();
		Circle c;
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i%7, i/7);
			c = new Circle(40);
			c.getStyleClass().add("pion");
			PlateauGUI.setCouleur(pion, c);
			this.pions.add(c);
			this.add(c, i%7, i/7+1);
		}
		this.setId("plateau");
	}

	public void maj() {
		for (int i=0; i < 7; i++) {
			if (this.gui.isPause() || !this.gui.isTour() || !this.plateau.getColonne(i).contains(null))
				this.controles.get(i).setDisable(true);
			else
				this.controles.get(i).setDisable(false);
		}
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i/7, i%7);
			PlateauGUI.setCouleur(pion, this.pions.get(i));
		}
	}

	public static void setCouleur(Integer pion, Circle cercle) {
		if (pion == null)
			cercle.setId("");
		else if (pion == 1)
			cercle.setId("joueur1");
		else
			cercle.setId("joueur2");
	}


	public List<Circle> getPions() {
		return this.pions;
	}
}
