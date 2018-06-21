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

public class BorderPartieEnCours extends PageJoueur{
    private AppliJDBC appli;
	private ChargeurJeu chargeur;

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
        this.setCenter(this.tableauTypePageJouer("Jeu","Adversaire","Date début partie"));
    }

	public void lancerPartie() {
		Partie p = this.tableau.getSelectionModel().getSelectedItem();
		String nomJeu = p.getJeu().getNomJeu();
		String nomJar = nomJeu + ".jar",
			   nomClasse = (nomJeu.charAt(0)+"").toUpperCase() + nomJeu.substring(1, nomJeu.length());
		this.chargeur.chargerJeu(nomJar, nomClasse, p, this.appli.getPartieBD(), this.appli.getClient().getIdentifiant());
	}
}
