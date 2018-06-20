package application;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javafx.geometry.Point2D;

public class BorderJeuxPossede extends PageJoueur {

    private AppliJDBC appli;
    private JeuBD jeuBD;
    private ObservableList<ListeJeux> data;
<<<<<<< HEAD
=======
    private JeuProfil jeuProfil;
    private String nomDuJeu;
    private ListeJeux jeux;
    private TableView<ListeJeux> table;
>>>>>>> edwin/sauvergardeConflit

    public BorderJeuxPossede(AppliJDBC appli,JeuBD jeuBD){

        super();
        this.appli = appli;
        this.jeux = jeux;
        this.jeuBD = jeuBD;

        Button mesJeux = this.buttonTypePageJoueur("Mes jeux");
        mesJeux.setOnAction(event -> this.appli.passerEnModeJeuxPossede());

        Button boutique = this.buttonTypePageJoueur("Boutique");
        boutique.setOnAction(event -> this.appli.passerEnModeJeuxBoutique());

        Button afficheFiche = this.buttonTypePageJoueur("Afficher la fiche");


        this.setStyle("-fx-background-color: transparent;");
        this.setMaxSize(800, 700);

        this.setTop(this.buttonBarTypePageJoueur(mesJeux,boutique,afficheFiche));
        // TableView table = this.tableauTypePageJouer("Nom","Type","Commentaire");
        // this.setCenter(table);

        this.table = new TableView<>();
        try {

        ArrayList<ListeJeux> listeJeu = this.jeuBD.listeDesJeuxSimple();
        this.data = FXCollections.observableArrayList(listeJeu);
        }
        catch (SQLException e){
          System.out.println("Liste de jeu impossible");
        }

        table.setEditable(false);

        TableColumn<ListeJeux,String> firstNameCol = new TableColumn("Nom du jeu");
        firstNameCol.setMinWidth(200);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<ListeJeux, String>("nom"));

        TableColumn<ListeJeux,String> lastNameCol = new TableColumn("Type");
        lastNameCol.setMinWidth(200);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<ListeJeux, String>("typeString"));

        TableColumn<ListeJeux,String> emailCol = new TableColumn("Commentaire");
        emailCol.setMinWidth(400);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<ListeJeux, String>("comment"));

        table.setItems(this.data);
        for (ListeJeux jeux : table.getItems()){
<<<<<<< HEAD
          System.out.println(jeux);
=======
          String nomJ = jeux.getNom();
          List<Integer> nombreColonne = new ArrayList<>();
          for (int i=1; i<(table.getItems().size()); i++){
            nombreColonne.add(i);
          }
          // System.out.println(table.getFocusModel().getFocusedCell().getTableColumn());
          // if (nombreColonne.contains(table.getFocusModel().getFocusedCell().getColumn())){
          //   System.out.println("dans le if");
            try{
              ActionAccesFicheJeu actionAffiche = new ActionAccesFicheJeu(jeux,this.jeuBD,this.appli,this.table);
              afficheFiche.setOnAction(actionAffiche);
            }
            catch(SQLException e){
              System.out.println("Erreur sql");
            }
          // }
>>>>>>> edwin/sauvergardeConflit
        }
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        this.setCenter(table);

    }


}
