package Connect4;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * Vue du Puissance 4
 */
public class LeJeu extends Application {
	/**
	 * Modèle du jeu
	 **/
	private Puissance4 puissance4;
	/**
	 * Si le jeu est en pause
	 */
	private boolean pause;
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
	private List<HBox> joueurs;
	/**
	 * La scène
	 */
	private BorderPane cont;


	/**
	 * @return le clavier avec les 27 caractères et le controleur des touches
	 */
	private PlateauGUI lePlateau() {
		this.plateau = new PlateauGUI(this.puissance4.getPlateau(), this, new ActionJouer(this.puissance4, this));
		return this.plateau;
	}

	/**
	 * @return Les joueurs
	 */
	private VBox lesJoueurs() {
		Joueur j1 = this.puissance4.getJoueur1(), j2 = this.puissance4.getJoueur2();
		Circle p1 = new Circle(30), p2 = new Circle(30);
		Button pause = new Button("Pause game");
		p1.getStyleClass().add("pion");
		p2.getStyleClass().add("pion");
		PlateauGUI.setCouleur(j1.getPion(), p1);
		PlateauGUI.setCouleur(j2.getPion(), p2);
		this.joueurs = new ArrayList<>();
		this.joueurs.add(new HBox());
		this.joueurs.add(new HBox());
		this.joueurs.get(0).getChildren().addAll(p1, new Label(j1.getNom()));
		this.joueurs.get(0).getStyleClass().add("joueur");
		this.joueurs.get(1).getChildren().addAll(p2, new Label(j2.getNom()));
		this.joueurs.get(1).getStyleClass().add("joueur");
		pause.setOnAction(new ActionPause(this));
		VBox res = new VBox(2);
		res.getChildren().addAll(this.joueurs);
		res.getChildren().add(pause);
		res.getStyleClass().add("joueurs");
		return res;
	}

	/**
	 * @return La barre des menus
	 */
	private MenuBar barreMenus() {
		MenuBar res = new MenuBar();
		Menu game = new Menu("Game"),
			 player = new Menu("Player"),
			 help = new Menu("Help");
		EventHandler<ActionEvent> game_handler= new GameMenuAction(this.puissance4, this),
			player_handler = new PlayerMenuAction(this.puissance4),
			help_handler = new HelpMenuAction(this.puissance4);
		game.getItems().addAll(
				new MenuItem("Surrender"),
				new MenuItem("Score tab"),
				new MenuItem("Leave")
				);
		player.getItems().addAll(
				new MenuItem("Opponent's stats"),
				new MenuItem("Send messages")
				);
		help.getItems().addAll(
				new MenuItem("About"),
				new MenuItem("Tutorial")
				);
		for (MenuItem item : game.getItems())
			item.setOnAction(game_handler);
		for (MenuItem item : player.getItems())
			item.setOnAction(player_handler);
		for (MenuItem item : help.getItems())
			item.setOnAction(help_handler);
		res.getMenus().addAll(game, player, help);
		return res;
	}

	/**
	 * @return le graphe de scène de la vue à partir de methodes précédentes
	 */
	private Scene laScene() {
		this.cont = new BorderPane();
		this.cont.setCenter(this.lePlateau());
		this.cont.setRight(this.lesJoueurs());
		this.cont.setTop(this.barreMenus());
		return new Scene(this.cont,1024,768);
	}

	/**
	 * raffraichit l'affichage en fonction du modèle
	 */
	public void majAffichage() {
		// A implémenter
		if (this.pause)
			this.cont.getStyleClass().add("pause");
		else
			this.cont.getStyleClass().remove("pause");
		if (!this.puissance4.isTour())
			this.cont.getStyleClass().add("autre-tour");
		else
			this.cont.getStyleClass().remove("autre-tour");
		this.plateau.maj();
	}

	public PlateauGUI getPlateau() {
		return this.plateau;
	}

	/**
	 * Crée le modèle, créer le graphe de scène et lance le jeu
	 * @param stage la fenêtre principale
	 */
	@Override
	public void start(Stage stage) {
		// création du modèle
		this.puissance4 = new Puissance4(
				new Joueur("Nat", 1, 18),
				new Joueur("Cyber Nat", 2, 18),
				1
				);

		stage.setTitle("Connect 4");

		stage.setScene(this.laScene());
		stage.getScene().getStylesheets().add("style/style.css");
		stage.show();
		System.out.println("?");
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

	/**
	 * Abandonner la partie. Le joueur qui abandonne a perdu
	 */
	public void abandonner() {
		this.puissance4.abandonner();
		this.perdre();
	}

	/**
	 * Annoncer au joueur courant sa victoire.
	 */
	public void gagner() {
		Alert alert = new Alert(AlertType.INFORMATION, "You've won the game! Good job.");
		alert.setTitle("Victory");
		alert.setHeaderText("Victory");
		alert.showAndWait();
		Platform.exit();
	}

	/**
	 * Annoncer au joueur courant sa défaite.
	 */
	public void perdre() {
		Alert alert = new Alert(AlertType.INFORMATION, "You've lost the game.");
		alert.setTitle("Defeat");
		alert.setHeaderText("Defeat");
		alert.showAndWait();
		Platform.exit();
	}

	/**
	 * Met le jeu en pause ou le remet en route.
	 */
	public void pause() {
		if (this.pause) {
			this.pause = false;
		} else {
			this.pause = true;
		}
	}

	/**
	 * @return si le jeu est en pause ou non
	 */
	public boolean isPause() {
		return this.pause;
	}

	/**
	 * @return si c'est le tour du joueur courant ou non
	 */
	public boolean isTour() {
		return this.puissance4.isTour();
	}

	/**
	 * Envoyer l'état actuel de la partie à l'application
	 */
	public void setEtat() {
		// TODO: envoyer l'état au format JSON
		JSONObject json = this.puissance4.toJson();
		json.put("pause", this.pause);
	}

	/**
	 * Charger l'état actuel depuis l'application
	 */
	public void getEtat() {
		// TODO: récupérer l'état en JSON et le charger
	}
}
