package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import java.sql.*;
import java.util.Optional;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ActionAccesRapport implements EventHandler<ActionEvent> {

	private ListeJeux jeux;
	private Rapport jeuProfil;
	private RapportBD accesBD;
	private AppliJDBC appli;
	private TableView table;

	public ActionAccesRapport(Rapport rapport, RapportBD accesBD, AppliJDBC appli,TableView table) throws SQLException{
	    this.jeux = jeux ;
			this.jeuProfil = null;
			this.accesBD = accesBD;
			this.appli = appli;
			this.table = table;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
			try{
				this.jeuProfil = this.accesBD.rechercherRapportParNum(((Rapport)this.table.getSelectionModel().getSelectedItem()).getIdRapport());
				this.appli.passerEnModeRapportLire(this.jeuProfil);
			}
			catch(SQLException e){
				System.out.println(e);
			}
		}
}
