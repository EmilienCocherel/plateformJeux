import java.util.List;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class PlateauGUI extends GridPane {
	private Plateau plateau;
	private List<Button> pions;

	public PlateauGUI(Plateau plateau) {
		this.plateau = plateau;
		this.pions = new ArrayList<>();
		EventHandler<ActionEvent> handler = new ActionJouer(this);
		Button b;
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i%7, i/7);
			if (pion == null)
				b = new Button("n");
			else
				b = new Button(pion.toString());
			b.setOnAction(handler);
			this.pions.add(b);
			this.add(b, i%7, i/7);
		}
	}

	public void maj() {
		Integer pion;
		for (int i=0; i < 49; i++) {
			pion = this.plateau.get(i%7, i/7);
			if (this.pions.get(i).equals("n") && pion != null)
				this.pions.get(i).setText(pion.toString());
		}
	}
}
