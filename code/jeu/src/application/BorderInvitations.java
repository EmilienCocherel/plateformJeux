package application;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.control.ButtonBar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;
import java.util.Date;

public class BorderInvitations extends PageJoueur {
    AppliJDBC app;
	private TableView<Invitation> trecues;
	private TableView<Invitation> tenvoyees;
	private TextField pseudo, jeu;

    public BorderInvitations(AppliJDBC app){
        super();
        this.app = app;

        GridPane recues = new GridPane();
		Button accepter = new Button("Accepter"),
			   refuser = new Button("Refuser");
		accepter.setOnAction(event -> this.accepter());
		refuser.setOnAction(event -> this.refuser());

		this.trecues = new TableView<>();
		ObservableList<Invitation> liste;
		try {
			liste = FXCollections.observableList(
					this.app.getInvitationBD().listeInvitationsRecuesEnAttente(
						this.app.getClient()
						));
		} catch (SQLException ex) {
			liste = FXCollections.emptyObservableList();
		}
		trecues.setItems(liste);

		TableColumn<Invitation,Date> date = new TableColumn<>("Jeu");
		date.setCellValueFactory(new PropertyValueFactory("nomJeu"));
		TableColumn<Invitation,String> objet = new TableColumn<>("Joueur");
		objet.setCellValueFactory(new PropertyValueFactory("nomJoueur2"));
		TableColumn<Invitation,String> lu = new TableColumn<>("Date");
		lu.setCellValueFactory(new PropertyValueFactory("date"));

		this.trecues.getColumns().setAll(date, objet, lu);
        this.trecues.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        recues.add(this.titlePageJouer("Reçues"), 0, 0);
        recues.add(this.trecues,0,1);
        recues.add(this.buttonBarTypePageJoueur(accepter, refuser),0,2);
        recues.setPadding(new Insets(10, 10, 10, 30));

        GridPane envoyees = new GridPane();
		Button envoyer = new Button("Envoyer");
		envoyer.setOnAction(event -> this.envoyer());
		this.pseudo = new TextField();
		this.jeu = new TextField();

		this.tenvoyees = new TableView<>();
		ObservableList<Invitation> liste2;
		try {
			liste2 = FXCollections.observableList(
					this.app.getInvitationBD().listeInvitationsEnvoyeesEnAttente(
						this.app.getClient()
						));
		} catch (SQLException ex) {
			liste2 = FXCollections.emptyObservableList();
		}
		tenvoyees.setItems(liste2);

		date = new TableColumn<>("Jeu");
		date.setCellValueFactory(new PropertyValueFactory("nomJeu"));
		objet = new TableColumn<>("Joueur");
		objet.setCellValueFactory(new PropertyValueFactory("nomJoueur2"));
		lu = new TableColumn<>("Date");
		lu.setCellValueFactory(new PropertyValueFactory("date"));

		this.tenvoyees.getColumns().setAll(date, objet, lu);
        this.tenvoyees.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        envoyees.add(this.titlePageJouer("Envoyées"), 1, 0);
        envoyees.add(this.tenvoyees, 1, 1);
        envoyees.add(this.titlePageJouer("Inviter des amis"), 1, 2);
        envoyees.add(this.hboxTypePageJoueur("Ami : ", this.pseudo), 1, 3);
        envoyees.add(this.hboxTypePageJoueur("Jeu : ", this.jeu),1, 4);
		envoyees.add(this.buttonBarTypePageJoueur(envoyer),1, 5);
        envoyees.setPadding(new Insets(10, 30, 10, 10));

        GridPane sceneCentre = new GridPane();
        sceneCentre.add(recues,0,0);
        sceneCentre.add(envoyees,1,0);

        this.setCenter(sceneCentre);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);
    }

	public void envoyer() {
		Joueur j2;
		JeuProfil jeu;
		try {
			j2 = this.app.getJoueurBD().rechercherJoueurParPseudo(this.pseudo.getText());
		} catch (SQLException e) {
			System.out.println("Joueur inconnu : "+this.pseudo.getText());
			return;
		}

		try {
			jeu = this.app.getJeuBD().rechercherJeuParNom(this.jeu.getText());
		} catch (SQLException e) {
			System.out.println("Jeu inconnu : "+this.jeu.getText());
			return;
		}
		Invitation inv = new Invitation(-1, new Date(), "en attente", this.app.getClient(), j2, jeu);
		try {
			this.app.getInvitationBD().creerInvitation(inv);
		} catch (SQLException e) {
			System.out.println("Impossible d'envoyer l'invitation."+e.getMessage());
		}
	}

	public void accepter() {
		Invitation inv = this.trecues.getSelectionModel().getSelectedItem();
		inv.setEtat("acceptée");
		try {
			this.app.getInvitationBD().majInvitation(inv);
		} catch (SQLException e) {
			System.out.println("Impossible de mettre à jour l'invitation n°"+inv.getId()+" : "+e.getMessage());
			return;
		}

		try {
			Partie p = new Partie(-1, new Date(), 0, "", inv.getJeu(), inv.getJoueur1(), 0, inv.getJoueur2(), 0);
			this.app.getPartieBD().creerPartie(p);
		} catch (SQLException e) {
			System.out.println("Impossible de créer la partie : "+e.getMessage());
		}

		this.trecues.getItems().remove(inv);
	}

	public void refuser() {
		Invitation inv = this.trecues.getSelectionModel().getSelectedItem();
		inv.setEtat("refusée");
		try {
			this.app.getInvitationBD().majInvitation(inv);
		} catch (SQLException e) {
			System.out.println("Impossible de mettre à jour l'invitation n°"+inv.getId()+" : "+e.getMessage());
		}
	}
}
