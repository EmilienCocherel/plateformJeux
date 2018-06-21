package application;
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
import java.util.Date;
import java.sql.SQLException;

public class BorderPartieHistorique extends PageJoueur{
    private AppliJDBC appli;
	private TableView<Partie> tableau;

    public BorderPartieHistorique(AppliJDBC appli){

        super();
        this.appli = appli;

        Button enCours = this.buttonTypePageJoueur("En cours");
        enCours.setOnAction(event -> this.appli.passerEnModePartieEnCours());

        Button historique = this.buttonTypePageJoueur("Historique");
        historique.setOnAction(event -> this.appli.passerEnModePartieHistorique());

        this.setStyle("-fx-background-color: transparent;");
        this.setMaxSize(800, 700);

        this.setTop(this.buttonBarTypePageJoueur(enCours,historique));

        this.tableau = new TableView<>();
		ObservableList<Partie> liste;
		try {
			liste = FXCollections.observableList(
					this.appli.getPartieBD().listeDesPartiesDuJoueurHistorique(
						this.appli.getClient(),
						this.appli
						));
		} catch (SQLException ex) {
			liste = FXCollections.emptyObservableList();
		}
		tableau.setItems(liste);

		TableColumn<Partie,Date> date = new TableColumn<>("Date de début");
		date.setCellValueFactory(new PropertyValueFactory("debut"));
		TableColumn<Partie,String> objet = new TableColumn<>("Adversaire");
		objet.setCellValueFactory(new PropertyValueFactory("adversaire"));
		TableColumn<Partie,String> lu = new TableColumn<>("Jeu");
		lu.setCellValueFactory(new PropertyValueFactory("nomJeu"));
		TableColumn<Partie,String> vainqueur = new TableColumn<>("Vainqueur");
		vainqueur.setCellValueFactory(new PropertyValueFactory("vainqueur"));

		tableau.getColumns().setAll(date, objet, lu, vainqueur);
        this.setCenter(this.tableauTypePageJouer("Jeu","Adversaire","Date début partie","Date fin partie","Vainqueur"));
    }
}
