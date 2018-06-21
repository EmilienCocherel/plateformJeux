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

public class BorderPartieEnCours extends PageJoueur{
    private AppliJDBC appli;
	private ChargeurJeu chargeur;
	private TableView<Partie> tableau;

    public BorderPartieEnCours(AppliJDBC appli){

        super();
        this.appli = appli;
		this.chargeur = new ChargeurJeu("./jar");

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
					this.appli.getPartieBD().listeDesPartiesDuJoueurActuelEnCours(
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

		tableau.getColumns().setAll(date, objet, lu);
        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableau.setOnMouseClicked(event -> this.lancerPartie());
        this.setCenter(this.tableau);
    }

	public void lancerPartie() {
		Partie p = this.tableau.getSelectionModel().getSelectedItem();
		String nomJeu = p.getJeu().getNomJeu();
		String nomJar = nomJeu + ".jar",
			   nomClasse = nomJeu+"."+(nomJeu.charAt(0)+"").toUpperCase() + nomJeu.substring(1, nomJeu.length());

		try {
			this.chargeur.chargerJeu(nomJar, nomClasse, p, this.appli.getPartieBD(), this.appli.getClient().getIdentifiant());
		} catch (Exception e) {
			System.out.println("erreur");
			System.out.println(e.getMessage());
		}
	}
}
