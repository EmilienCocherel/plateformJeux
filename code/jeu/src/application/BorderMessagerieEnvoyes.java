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

public class BorderMessagerieEnvoyes extends AbstractMessagerie {
    public BorderMessagerieEnvoyes(AppliJDBC appli) {
        super(appli);

		TableColumn<Message,String> auteur = new TableColumn<>("Destinataire");
		auteur.setCellValueFactory(new PropertyValueFactory("nomJoueur1"));

		tableau.getColumns().add(auteur);
    }
}
