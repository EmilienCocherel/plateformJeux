package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;

public class BorderConsutlerStatsJeux extends PageJoueur {
    private AppliJDBC app;
	private TableView<Statistique> tableau;

    public BorderConsutlerStatsJeux(AppliJDBC app){
        super();
        this.app = app;

        Button brevenir = this.buttonTypePageJoueur("Revenir au profil");
        brevenir.setOnAction(event -> this.app.passerEnModeProfilUtilisateur());

        HBox haut = this.hboxTypePageJoueur("Statistiques de "+this.app.getClient().getPseudo(), brevenir);

        Button jeux = this.buttonTypePageJoueur("Jeux");
        jeux.setOnAction(event -> this.app.passerEnModeConsulterStatsJeux());

        Button adversaire = this.buttonTypePageJoueur("Adversaire");
        adversaire.setOnAction(event -> this.app.passerEnModeConsulterStatsAdversaire());

        BorderPane centre = new BorderPane();
        centre.setTop(this.buttonBarTypePageJoueur(jeux,adversaire));


        this.tableau = new TableView<>();
		ObservableList<Statistique> liste;
		try {
			liste = FXCollections.observableList(
					this.app.getPartieBD().listeStatsParJeu(
						this.app.getClient()
						));
		} catch (SQLException ex) {
			liste = FXCollections.emptyObservableList();
		}
		tableau.setItems(liste);

		TableColumn<Statistique,String> date = new TableColumn<>("Nom du jeu");
		date.setCellValueFactory(new PropertyValueFactory("nomJeu"));
		TableColumn<Statistique,String> objet = new TableColumn<>("% de victoires");
		objet.setCellValueFactory(new PropertyValueFactory("pourcentageVictoire"));

		tableau.getColumns().setAll(date, objet);
        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        centre.setCenter(this.tableau);

        this.setMaxSize(800, 700);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(20, 20, 20, 20));

        this.setTop(haut);
        this.setCenter(centre);
    }
}
