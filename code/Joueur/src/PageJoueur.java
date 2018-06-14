import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonBar;

public abstract class PageJoueur extends BorderPane{

    public PageJoueur() {
        super();

        Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);

        this.setBackground(new Background(new BackgroundFill(lg2, null, null)));

    }

    public Label titlePageJouer(String titre) {

        Font fonttitre = new Font("Arial", 25);
        Label title = new Label(titre);
        title.setTextFill(Color.rgb(179, 71, 91));
        title.setPadding(new Insets(10, 0, 10, 10));
        title.setFont(fonttitre);
        title.setAlignment(Pos.TOP_LEFT);

        return title;
    }

    public Label labelTypePageJoueur(String nom) {

        Label label = new Label(nom);
        label.setTextFill(Color.rgb(196, 196, 196));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10, 0, 10, 10));

        return label;

    }

    public CheckBox checkBoxTypePageJoueur(String nom) {

        CheckBox cb = new CheckBox(nom);
        cb.setTextFill(Color.rgb(179, 71, 91));
        cb.setPadding(new Insets(10, 0, 10, 10));

        return cb;
    }

    public Hyperlink lienTypePageJoueur(String nom) {
        Hyperlink lien = new Hyperlink(nom);
        lien.setTextFill(Color.rgb(179, 71, 91));
        lien.setPadding(new Insets(10, 0, 10, 10));

        return lien;
    }

    public HBox hboxTypePageJoueur(String nom){
        HBox hbox = new HBox();
        Label label = this.labelTypePageJoueur(nom);
        TextField text = new TextField();

        hbox.getChildren().addAll(label, text);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        return hbox;
    }

    public HBox hBoxTypetextBouton(String nom){
        HBox hbox = new HBox();
        TextField text = new TextField();
        Button bouton = this.buttonTypePageJoueur("Demander en ami");

        hbox.getChildren().addAll(bouton, text);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        return hbox;



    }


    public Button buttonTypePageJoueur(String nom){
        Button bouton = new Button(nom);
        bouton.setTextFill(Color.rgb(196, 196, 196));
        bouton.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
        bouton.setPadding(new Insets(10, 50, 10, 50));

        return bouton;
    }

    public TableView tableauTypePageJouer(String... nomsColonnes){

        TableView tableau = new TableView();
        for (String nomC : nomsColonnes){
            TableColumn colonne = new TableColumn(nomC);
            colonne.setMinWidth(130);
            tableau.getColumns().add(colonne);
        }

        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return tableau;
    }

    public ButtonBar buttonBarTypePageJoueur(String... nomsBoutons){

        ButtonBar barBouton = new ButtonBar();
        for (String nomBouton : nomsBoutons){
            Button bouton = this.buttonTypePageJoueur(nomBouton);
            barBouton.setButtonData(bouton,ButtonData.LEFT);
            barBouton.getButtons().addAll(bouton);
        }
        barBouton.setPadding(new Insets(10, 0, 10, 0));
        return barBouton;
    }

    public ButtonBar buttonBarTypePageJoueur(Button... boutons){

        ButtonBar barBouton = new ButtonBar();
        for (Button bouton : boutons){
            barBouton.setButtonData(bouton,ButtonData.LEFT);
            barBouton.getButtons().add(bouton);
        }
        barBouton.setPadding(new Insets(10, 50, 10, 50));
        return barBouton;
    }

}