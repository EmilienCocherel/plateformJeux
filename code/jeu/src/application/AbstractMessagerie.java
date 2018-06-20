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
import java.sql.SQLException;
import java.util.Date;

public abstract class AbstractMessagerie extends PageJoueur {
    protected AppliJDBC appli;
	protected TableView<Message> tableau;

    public AbstractMessagerie(AppliJDBC appli) {
        super();
        this.appli = appli;

        Button recus = this.buttonTypePageJoueur("Reçus");
        recus.setOnAction(event -> this.appli.passerEnModeMessagerieRecus());

        Button envoyes = this.buttonTypePageJoueur("Envoyés");
        envoyes.setOnAction(event -> this.appli.passerEnModeMessagerieEnvoyes());

        Button supprimer = this.buttonTypePageJoueur("Supprimer");
        supprimer.setOnAction(event -> this.appli.passerEnModeMessagerieRecus());

        Button redigerMessage = this.buttonTypePageJoueur("Rédiger un nouveau message");
        redigerMessage.setOnAction(event -> this.appli.passerEnModeRedigerMessage());

        this.setStyle("-fx-background-color: transparent;");
        this.setMaxSize(800, 700);

        this.tableau = new TableView<>();
		ObservableList<Message> liste;
		try {
			liste = FXCollections.observableList(
					this.appli.getMessageBD().listeDesMessagesRecusParJoueur(
						this.appli.getClient()
						));
		} catch (SQLException ex) {
			liste = FXCollections.emptyObservableList();
		}
		tableau.setItems(liste);

		TableColumn<Message,Date> date = new TableColumn<>("Date");
		date.setCellValueFactory(new PropertyValueFactory("date"));
		TableColumn<Message,String> objet = new TableColumn<>("Objet");
		objet.setCellValueFactory(new PropertyValueFactory("objet"));
		TableColumn<Message,String> lu = new TableColumn<>("Lu");
		lu.setCellValueFactory(new PropertyValueFactory("luTexte"));

		tableau.getColumns().setAll(date, objet, lu);

        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		//tableau.getOnMouseClicked(event -> lireMessage());

        this.setTop(this.buttonBarTypePageJoueur(recus,envoyes));
        this.setCenter(tableau);
        this.setBottom(this.buttonBarTypePageJoueur(supprimer, redigerMessage));
    }

	public TableView<Message> getTableau() {
		return this.tableau;
	}
	public AppliJDBC getAppli() {
		return this.appli;
	}
}
