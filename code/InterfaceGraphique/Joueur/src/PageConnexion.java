import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

public abstract class PageConnexion extends GridPane{


    public PageConnexion() {
        super();

        Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);

        this.setBackground(new Background(new BackgroundFill(lg2, null, null)));

    }

    public Label title(String titre) {

        Font fonttitre = new Font("Arial", 25);
        Label title = new Label(titre);
        title.setTextFill(Color.rgb(179, 71, 91));
        title.setPadding(new Insets(10, 0, 10, 10));
        title.setFont(fonttitre);
        title.setAlignment(Pos.TOP_LEFT);

        return title;
    }




    public Label labelType(String nom) {

        Label label = new Label(nom);
        label.setTextFill(Color.rgb(196, 196, 196));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10, 0, 10, 10));

        return label;

    }

    public CheckBox checkBoxType(String nom) {

        CheckBox cb = new CheckBox(nom);
        cb.setTextFill(Color.rgb(179, 71, 91));
        cb.setPadding(new Insets(10, 0, 10, 10));

        return cb;
    }

    public Hyperlink lienType(String nom) {
        Hyperlink lien = new Hyperlink(nom);
        lien.setTextFill(Color.rgb(179, 71, 91));
        lien.setPadding(new Insets(10, 0, 10, 10));

        return lien;
    }

    public Button buttonType(String nom){
        Button bouton = new Button(nom);
        bouton.setTextFill(Color.rgb(196, 196, 196));
        bouton.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
        bouton.setPadding(new Insets(10, 50, 10, 50));

        return bouton;
    }

    public HBox imageTypePageConnexion(){

        Image test = new Image("inconnu.png");

        ImageView iv1 = new ImageView();
        iv1.setImage(test);
        iv1.setFitWidth(200);
        iv1.setFitHeight(200);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);

        Button imageClicable = new Button();
        imageClicable.setGraphic(iv1);
        imageClicable.setStyle("-fx-background-color: transparent;");

        HBox res = new HBox();
        res.getChildren().add(imageClicable);
        res.setStyle("-fx-background-color: transparent;");
        res.setPadding(new Insets(75, 75, 10, 50));


        return res;
    }




}
