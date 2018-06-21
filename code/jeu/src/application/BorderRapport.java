package application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BorderRapport extends PageAdmin {

  private AppliJDBC app;
  private RapportBD bd;
  private ObservableList<Rapport> data;
  private JeuProfil jeuProfil;
  private String nomDuJeu;
  // private ListeJeux actionRapport;
  private TableView<Rapport> table;

    public BorderRapport(AppliJDBC app,RapportBD bd){
        super();
        this.app = app;
        this.bd = bd;

        Button bAccueil = this.buttonTypePageAdmin("Accueil");
        bAccueil.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bLire = this.buttonTypePageAdmin("Lire");
        // bLire.setOnAction(event -> this.app.passerEnModeRapportLire());

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0,20,0,20));
        this.setMaxSize(800, 700);

        this.setTop(this.hboxTypeGrosPageAdmin("Nom du rapport : "));
        // this.setCenter(this.tableauTypePageAdmin("Titre", "Auteur", "Sujet", "Date publication"));
        this.setBottom(this.buttonBarTypePageAdmin(bAccueil, bLire));

        this.table = new TableView<>();
        try {

        ArrayList<Rapport> listeJeu = this.bd.rechercherRapport();
        this.data = FXCollections.observableArrayList(listeJeu);
        }
        catch (SQLException e){
          System.out.println("Liste de jeu impossible");
        }

        table.setEditable(false);

        TableColumn<Rapport,String> titre = new TableColumn("Titre");
        titre.setMinWidth(200);
        titre.setCellValueFactory(
                new PropertyValueFactory<Rapport, String>("titreRapport"));

        TableColumn<Rapport,String> auteur = new TableColumn("Auteur");
        auteur.setMinWidth(160);
        auteur.setCellValueFactory(
                new PropertyValueFactory<Rapport, String>("joueur"));

        TableColumn<Rapport,String> sujet = new TableColumn("Sujet");
        sujet.setMinWidth(150);
        sujet.setCellValueFactory(
                new PropertyValueFactory<Rapport, String>("sujetRapport"));

        TableColumn<Rapport,String> datePub = new TableColumn("Date Publication");
        datePub.setMinWidth(230);
        datePub.setCellValueFactory(
                new PropertyValueFactory<Rapport, String>("dateRapport"));


        table.setItems(this.data);
        for (Rapport rapp : table.getItems()){
          List<Integer> nombreColonne = new ArrayList<>();
          for (int i=1; i<(table.getItems().size()); i++){
            nombreColonne.add(i);
          }
          // System.out.println(table.getFocusModel().getFocusedCell().getTableColumn());
          // if (nombreColonne.contains(table.getFocusModel().getFocusedCell().getColumn())){
          //   System.out.println("dans le if");
            try{
              ActionAccesRapport actionRapport = new ActionAccesRapport(rapp,this.bd,this.app,this.table);
              bLire.setOnAction(actionRapport);
            }
            catch(SQLException e){
              System.out.println("Erreur sql");
            }
          }
        table.getColumns().addAll(titre, auteur, sujet, datePub);
        this.setCenter(table);
    }
}
