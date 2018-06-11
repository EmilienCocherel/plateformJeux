import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

/**
 * Vue du Puissance 4
 */
public class GUI extends Application {
	/*
	 * modèle du jeu
	 **/
	private Puissance4 puissance4;
	/**
	 * Les différents contrôles qui seront mis à jour
	 * ou consultés pour l'affichage
	 */
	/**
	 * Le plateau
	 */
	private PlateauGUI plateau;
	/**
	 * Les joueurs
	 */
	private List<Label> joueurs;


	/**
	 * @return le clavier avec les 27 caractères et le controleur des touches
	 */
	private PlateauGUI lePlateau() {
		this.plateau = new PlateauGUI(this.puissance4.getPlateau());
		this.plateau.setAlignment(Pos.BOTTOM_CENTER);
		this.plateau.setPadding(new Insets(15));
		this.plateau.setHgap(2);
		this.plateau.setVgap(2);
		this.plateau.setBackground(new Background(new BackgroundFill(
						Color.color(122.0/255, 203.0/255, 215.0/255),
						CornerRadii.EMPTY,
						Insets.EMPTY)));
		return this.plateau;
	}

	/**
	 * @return Les joueurs
	 */
	private VBox lesJoueurs() {
		Joueur j1 = this.puissance4.getJoueur1(), j2 = this.puissance4.getJoueur2();
		this.joueurs = new ArrayList<>();
		this.joueurs.add(new Label(j1.getNom() + " " + j1.getPion().toString() + " " + j1.getNbPions()));
		this.joueurs.add(new Label(j2.getNom() + " " + j2.getPion().toString() + " " + j2.getNbPions()));
		VBox res = new VBox(2);
		res.getChildren().addAll(this.joueurs);
		return res;
	}

	/**
	 * @return le graphe de scène de la vue à partir de methodes précédantes
	 */
	private Scene laScene() {
		BorderPane cont = new BorderPane();
		cont.setCenter(this.lePlateau());
		cont.setRight(this.lesJoueurs());
		cont.setBackground(new Background(new BackgroundFill(
						Color.color(174.0/255, 229.0/255, 237.0/255),
						CornerRadii.EMPTY,
						Insets.EMPTY)));
		return new Scene(cont,700,800);
	}

	/**
	 * raffraichit l'affichage en fonction du modèle
	 */
	public void majAffichage() {
		// A implémenter
		this.plateau.maj();
	}

	/**
	 * Crée le modèle, charge les images, créer le graphe de scène et lance le jeu
	 * @param stage la fenêtre principale
	 */
	@Override
	public void start(Stage stage) {
		// création du modèle
		this.puissance4 = new Puissance4(
				new Joueur("Nat", 1, 18),
				new Joueur("Cyber Nat", 2, 18)
				);

		stage.setScene(this.laScene());
		stage.show();
	}

	/**
	 * Si la partie est finie
	 */
	public boolean finie() { // À IMPLÉMENTER
		return false;
	}

	/**
	 * Programme principal
	 * @param args inutilisé
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
