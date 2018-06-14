import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class JeuxPossede extends BorderPane {

    ApplicationAJEL app;
    BorderPane cont;

    public JeuxPossede(ApplicationAJEL app1){
        this.app = app1;
        this.cont = new BorderPane();
    }

    public Button creerbouton(String nomb){

        Button res = new Button(nomb);
        res.setTextFill(Color.rgb(196, 196, 196));
        res.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), Insets.EMPTY)));
        return res;
    }

    public HBox barJeuBoutique() {

        HBox hBouton = new HBox();
        //ButtonBar bJeuBoutique = new ButtonBar();

        Button bMesJeux = this.creerbouton("Mes jeux");
        //ButtonBar.setButtonData(bMesJeux, ButtonBar.ButtonData.LEFT);

        Button bBoutique = this.creerbouton("Boutique");
        //ButtonBar.setButtonData(bBoutique, ButtonBar.ButtonData.HELP_2);

        hBouton.setAlignment(Pos.CENTER);
        hBouton.getChildren().addAll(bMesJeux, bBoutique);

        //bJeuBoutique.getButtons().addAll(bMesJeux, bBoutique);

        return hBouton;
    }

    public TableColumn colonneTab(String nomcol){

        TableColumn res = new TableColumn(nomcol);
        return res;
    }

    public TableView tableau(){

        ObservableList<Jeux> listeJeux = FXCollections.observableArrayList(
                new Jeux("Morpion", "Tour par tour", "Hilarant"),
                new Jeux("Mastermind", "Simultané", "Perso j'aime pas trop"),
                new Jeux("Puissance4", "Tour par tour", "J'suis un dieu à ce jeu")
        );

        TableView tab = new TableView();

        TableColumn nom = this.colonneTab("Nom");
        nom.setCellValueFactory(new PropertyValueFactory<Jeux,String>("Nom"));

        TableColumn type = this.colonneTab("Type");
        type.setCellValueFactory(new PropertyValueFactory<Jeux,String>("Type"));

        TableColumn description = this.colonneTab("Description");
        description.setCellValueFactory(new PropertyValueFactory<Jeux,String>("Description"));

        tab.setEditable(false);
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tab.getColumns().addAll(nom, type, description);

        tab.setItems(listeJeux);
        return tab;
    }

    public BorderPane setfenetre() {

        BorderPane fenetre = new BorderPane();

        fenetre.setTop(this.barJeuBoutique());
        fenetre.setCenter(this.tableau());

        fenetre.setPadding(new Insets(50, 50, 50, 50));

        return fenetre;

    }

    public void initCont(){

        this.cont.setTop(this.app.getMenuBarJoueur());
        this.cont.setCenter(this.setfenetre());
        Stop[] stops = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);

        this.cont.setBackground(new Background(new BackgroundFill(lg2, null, null)));
    }

    public BorderPane getCont() {
        this.initCont();
        return this.cont;
    }


}
