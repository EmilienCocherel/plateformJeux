package connect4;

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
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Vue du Puissance 4
 */
public class LeJeu extends application.Jeu {
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
	 * La partie (pour récupérer les informations de la partie et des joueurs)
	 */
	private application.Partie partie;
	/**
	 * Pour interagir avec la base de données
	 */
	private application.PartieBD partieBD;

	/**
	 * @return le clavier avec les 27 caractères et le controleur des touches
	 */
	private PlateauGUI lePlateau() {
		this.plateau = new PlateauGUI(this.puissance4.getPlateau(), this, new ActionJouer(this.puissance4, this));
		return this.plateau;
	}

	@Override
	public void setPartie(application.Partie partie, int idJoueur) {
		this.partie = partie;
		application.Joueur joueur1 = partie.getJoueur1(), joueur2 = partie.getJoueur2();
		if (!this.getEtat(idJoueur)) {
			this.puissance4 = new Puissance4(
					new Joueur(joueur1.getIdentifiant(), joueur1.getPseudo(), 1, 18),
					new Joueur(joueur2.getIdentifiant(), joueur2.getPseudo(), 2, 18),
					idJoueur
				);
		}
	}

	@Override
	public void setPartieBD(application.PartieBD partieBD) {
		this.partieBD = partieBD;
	}

	/**
	 * @return Les joueurs
	 */
	private VBox lesJoueurs() {
		Joueur j1 = this.puissance4.getJoueur1(), j2 = this.puissance4.getJoueur2();
		Circle p1 = new Circle(30), p2 = new Circle(30);
		Button pause;
		if (this.pause)
			pause = new Button("Resume game");
		else
			pause = new Button("Pause game");
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
		System.out.println(this.cont);
		if (this.pause && !this.cont.getStylesheets().contains("pause"))
			this.cont.getStyleClass().add("pause");
		else
			this.cont.getStyleClass().remove("pause");
		if (!this.puissance4.isTour() && !this.cont.getStylesheets().contains("autre-tour"))
			this.cont.getStyleClass().add("autre-tour");
		else
			this.cont.getStyleClass().remove("autre-tour");
		this.plateau.maj();
	}

	public PlateauGUI getPlateau() {
		return this.plateau;
	}

	/**
	 * Créer le graphe de scène et lance le jeu
	 */
	public void run() {
		// Gestion de la mise à jour de l'état de la partie
		Timeline timeline = new Timeline(new KeyFrame(
					Duration.millis(2000),
					ae -> this.getEtatEtMaj()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		Stage stage = new Stage();

		stage.setTitle("Connect 4");

		stage.setScene(this.laScene());
		stage.getScene().getStylesheets().add("connect4/style/style.css");
		stage.show();
		this.majAffichage();
	}

    @Override
    public void creerPartie(int idJeu, int idJoueur1, int idJoueur2, Object partage){
    }

    @Override
    public void jouerCoup(int idPartie, int joueur, Object partage){
    }

	/**
	 * Si la partie est finie
	 */
	public boolean finie() { // À IMPLÉMENTER
		return false;
	}

	/**
	 * Abandonner la partie. Le joueur qui abandonne a perdu
	 */
	public void abandonner() {
		this.puissance4.abandonner();
		this.perdre();
		this.setEtat();
	}

	/**
	 * Annoncer au joueur courant sa victoire.
	 */
	public void gagner() {
		Alert alert = new Alert(AlertType.INFORMATION, "You've won the game! Good job.");
		alert.setTitle("Victory");
		alert.setHeaderText("Victory");
		alert.showAndWait();
	}

	/**
	 * Annoncer au joueur courant sa défaite.
	 */
	public void perdre() {
		Alert alert = new Alert(AlertType.INFORMATION, "You've lost the game.");
		alert.setTitle("Defeat");
		alert.setHeaderText("Defeat");
		alert.showAndWait();
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
		System.out.println(json);
		try {
			this.partieBD.majEtat(this.partie.getId(), json.toString());
			System.out.println(this.puissance4.getJoueurCourant().getId()+" insert màj OK");
		} catch (SQLException ex) {
			if (this.puissance4 != null)
				System.out.println(this.puissance4.getJoueurCourant().getId()+" insert màj FAIL");
		}
	}

	/**
	 * Charger l'état actuel depuis l'application
	 * @param actuel L'id du joueur actuel
	 * @return si l'opération a réussie
	 */
	public boolean getEtat(int actuel) {
		JSONParser parser = new JSONParser();
		try {
			int id = this.partie.getId();
			String etat = this.partieBD.getEtat(id);
			JSONObject obj = (JSONObject) parser.parse(etat);
			this.puissance4 = Puissance4.fromJson(obj, actuel);
			this.pause = (boolean) obj.get("pause");
			System.out.println(this.puissance4.getJoueurCourant().getId()+" get màj OK");
			return true;
		} catch (ParseException ex) {
			if (this.puissance4 != null)
				System.out.println(this.puissance4.getJoueurCourant().getId()+" get màj FAIL");
			return false;
		} catch (SQLException ex) {
			if (this.puissance4 != null)
				System.out.println(this.puissance4.getJoueurCourant().getId()+" get màj FAIL");
			return false;
		}
	}

	public void getEtatEtMaj() {
		if (this.getEtat(this.puissance4.getJoueurCourant().getId()))
			this.majAffichage();
	}
}
