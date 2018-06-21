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

public class BorderGererJeux extends PageAdmin {

    private AppliJDBC app;
    private JeuBD jeuBD;
    private ObservableList<ListeJeux> data;
    private JeuProfil jeuProfil;
    private String nomDuJeu;
    private ListeJeux jeux;
    private TableView<ListeJeux> table;

    BorderGererJeux(AppliJDBC app,JeuBD jeuBD){
        super();
        this.app = app;
        this.jeuBD = jeuBD;

        Button bAccueil = this.buttonTypePageAdmin("Accueil");
        bAccueil.setOnAction(event -> this.app.passerEnModeAccueil());

        this.setTop(this.hboxTypeGrosPageAdmin("Jeu : "));
        this.setBottom(this.buttonBarTypePageAdmin(bAccueil));

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0, 20, 0, 20));
        this.setMaxSize(800, 700);

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
        // for (ListeJeux jeux : table.getItems()){
        //   String nomJ = jeux.getNom();
        //   List<Integer> nombreColonne = new ArrayList<>();
        //   for (int i=1; i<(table.getItems().size()); i++){
        //     nombreColonne.add(i);
        //   }
        //   // System.out.println(table.getFocusModel().getFocusedCell().getTableColumn());
        //   // if (nombreColonne.contains(table.getFocusModel().getFocusedCell().getColumn())){
        //   //   System.out.println("dans le if");
        //     // try{
        //       // ActionAccesFicheJeu actionAffiche = new ActionAccesFicheJeu(jeux,this.jeuBD,this.appli,this.table);
        //       // afficheFiche.setOnAction(actionAffiche);
        //     // }
        //     // catch(SQLException e){
        //     //   System.out.println("Erreur sql");
        //     // }
        //   // }
        // }
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        this.setCenter(table);

      }
    }
