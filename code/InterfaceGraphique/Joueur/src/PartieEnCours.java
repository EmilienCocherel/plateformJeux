import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;


public class PartieEnCours extends BorderPane {

//    private BorderPane scenePartieCours;
//    private ApplicationAJEL app;
//
//    public PartieEnCours(ApplicationAJEL app){
//        this.app = app;
//        this.scenePartieCours = new BorderPane();
//    }
//
//    public Button créerBouton(String nomb){
//        Button button = new Button (nomb);
//        button.setTextFill(Color.rgb(196, 196, 196));
//        button.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
//        return button;
//    }
//
//    public ButtonBar barJeuHistorique(){
//
//        ButtonBar barJeuHistorique = new ButtonBar();
//        Button bEnCours = this.créerBouton("En cours");
//        Button bHistorique = this.créerBouton("Historique");
//
//        barJeuHistorique.setButtonData(bEnCours, ButtonData.LEFT);
//        barJeuHistorique.setButtonData(bEnCours, ButtonData.RIGHT);
//
//        barJeuHistorique.getButtons().addAll(bEnCours,bHistorique);
//
//        return barJeuHistorique;
//    }
//
//    public TableColumn colonneEnCours(String nomC){
//        return new TableColumn(nomC);
//    }
//
//    public TableView tableEnCours(){
//
//        TableView res = new TableView();
//
//        TableColumn jeu = this.colonneEnCours("Jeu");
//        TableColumn adversaire = this.colonneEnCours("Adversaire");
//        TableColumn dateDebut = this.colonneEnCours( "Date Debut");
//
//        res.getColumns().addAll(jeu,adversaire,dateDebut);
//
//        return res;
//    }
//
//    public GridPane fenetreTableauEnCours(){
//
//        GridPane fenetre = new GridPane();
//
//        fenetre.add(this.barJeuHistorique(),0,1);
//        fenetre.add(this.tableEnCours(),0,2);
//
//        return fenetre;
//    }
//
//    public void setPanel(){
//        this.scenePartieCours.setTop(this.app.getMenuBar());
//        this.scenePartieCours.setCenter(this.fenetreTableauEnCours());
//        Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
//        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);
//
//        this.scenePartieCours.setBackground(new Background(new BackgroundFill(lg2, null, null)));
//    }
//
//    public BorderPane getScenePartieCours() {
//        return this.scenePartieCours;
//    }
}
