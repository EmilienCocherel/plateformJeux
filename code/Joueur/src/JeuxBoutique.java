import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class JeuxBoutique extends BorderPane {

//    private BorderPane cont;
//    private ApplicationAJEL app;
//
//    public JeuxBoutique(ApplicationAJEL app1) {
//
//        this.app = app1;
//        this.cont = new BorderPane();
//    }
//
//    public Button creerbouton(String nomb){
//
//        Button res = new Button(nomb);
//        res.setTextFill(Color.rgb(196, 196, 196));
//        res.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
//        return res;
//    }
//
//    public ButtonBar barJeuBoutique() {
//
//         ButtonBar bJeuBoutique = new ButtonBar();
//
//         Button bMesJeux = this.creerbouton("Mes jeux");
//         ButtonBar.setButtonData(bMesJeux, ButtonData.LEFT);
//
//         Button bBoutique = this.creerbouton("Boutique");
//         ButtonBar.setButtonData(bBoutique, ButtonData.HELP_2);
//
//         bJeuBoutique.getButtons().addAll(bMesJeux, bBoutique);
//
//         return bJeuBoutique;
//    }
//
//    public TableColumn colonneTab(String nomcol){
//
//        TableColumn res = new TableColumn(nomcol);
//        return res;
//    }
//
//    public TableView tableau(){
//
//        TableView tab = new TableView();
//
//        TableColumn nom = this.colonneTab("Nom");
//        TableColumn type = this.colonneTab("Type");
//        TableColumn dateEnLigne = this.colonneTab("Date de mise en ligne");
//
//        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        tab.getColumns().addAll(nom, type, dateEnLigne);
//
//        return tab;
//    }
//
//    public BorderPane setfenetre() {
//
//        BorderPane fenetre = new BorderPane();
//
//        fenetre.setTop(this.barJeuBoutique());
//        fenetre.setCenter(this.tableau());
//
//        return fenetre;
//
//    }
//
//    public void initCont(){
//
//        this.cont.setTop(this.app.getMenuBar());
//        this.cont.setCenter(this.setfenetre());
//        Stop[] stops = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
//        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops);
//
//        this.cont.setBackground(new Background(new BackgroundFill(lg2, null, null)));
//
//        this.cont.setPadding(new Insets(50, 50, 50, 50));
//    }
//
//    public BorderPane getCont() {
//        this.initCont();
//        return this.cont;
//    }
}
