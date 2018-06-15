import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BorderAjouterJeu extends PageAdmin {

    AJEL app;

    public BorderAjouterJeu(AJEL app){
        super();
        this.app = app;

        GridPane cotegauche = new GridPane();

        cotegauche.add(this.labelTypePageAdmin("Titre :"),0,0);
        cotegauche.add(new TextField(),1,0);
        cotegauche.add(this.checkBoxTypePageAdmin("Payant"),0,1);
        cotegauche.add(this.labelTypePageAdmin("Prix : "),1,2);
        cotegauche.add(new TextField(),1,2);
        cotegauche.add(this.checkBoxTypePageAdmin("Actif"),0,3);
        cotegauche.add(this.labelTypePageAdmin("Type de jeu : "),0,4);
        cotegauche.add(this.comboBoxAdmin("TpT","Simultané"),1,4);
        cotegauche.setPadding(new Insets(30, 30, 10, 10));

        GridPane cotehaut= new GridPane();

        cotehaut.add(this.imageTypePageAdmin(),0,0);
        cotehaut.add(cotegauche,1,0);






        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);
    }
}