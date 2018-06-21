package application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonBar;

import javafx.scene.image.ImageView;

public abstract class PageAdmin extends BorderPane{

    public PageAdmin() {
        super();

        Stop[] stops2 = new Stop[]{new Stop(0.4, Color.BLACK), new Stop(1, Color.rgb(123, 41, 67))};
        LinearGradient lg2 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REPEAT, stops2);

        this.setBackground(new Background(new BackgroundFill(lg2, null, null)));

    }

    public Label titlePageAdmin(String titre) {

        Font fonttitre = new Font("Arial", 32);
        Label title = new Label(titre);
        title.setTextFill(Color.rgb(179, 71, 91));
        title.setPadding(new Insets(10, 0, 10, 10));
        title.setFont(fonttitre);
        title.setAlignment(Pos.TOP_LEFT);

        return title;
    }

    public Label labelTypePageAdmin(String nom) {


        Label label = new Label(nom);
        label.setTextFill(Color.rgb(196, 196, 196));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10, 0, 10, 10));


        return label;

    }


    public Label labelGrosPageAdmin(String nom) {

        Font fontGros = new Font("Arial", 15);
        Label label = new Label(nom);
        label.setTextFill(Color.rgb(196, 196, 196));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10, 0, 10, 10));
        label.setFont(fontGros);

        return label;

    }

    public CheckBox checkBoxTypePageAdmin(String nom) {

        CheckBox cb = new CheckBox(nom);
        cb.setTextFill(Color.rgb(179, 71, 91));
        cb.setPadding(new Insets(10, 0, 10, 10));

        return cb;
    }

    public Hyperlink lienTypePageAdmin(String nom) {
        Hyperlink lien = new Hyperlink(nom);
        lien.setTextFill(Color.rgb(179, 71, 91));
        lien.setPadding(new Insets(10, 0, 10, 10));

        return lien;
    }

    public HBox hboxTypePageAdmin(String nom){
        HBox hbox = new HBox();
        Label label = this.labelTypePageAdmin(nom);
        TextField text = new TextField();

        hbox.getChildren().addAll(label, text);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        return hbox;
    }

    public HBox hboxTypeGrosPageAdmin(String nom){
        HBox hbox = new HBox();
        Label label = this.labelGrosPageAdmin(nom);
        TextField text = new TextField();

        hbox.getChildren().addAll(label, text);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        return hbox;
    }

    public HBox hboxTypePageAdmin(String nom, String nom2){
        HBox hbox = new HBox();
        Label label = this.labelTypePageAdmin(nom);
        Label label2 = this.labelTypePageAdmin(nom2);

        hbox.getChildren().addAll(label, label2);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        return hbox;
    }

    public HBox hboxTypePageAdmin(String nom, Button b){
        HBox hbox = new HBox();
        Label label = this.labelTypePageAdmin(nom);

        hbox.getChildren().addAll(label, b);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        return hbox;
    }

    public HBox hboxTypePageAdmin(String nom, TextArea textarea){
        HBox hbox = new HBox();
        Label label = this.labelTypePageAdmin(nom);

        hbox.getChildren().addAll(label, textarea);
        hbox.setPadding(new Insets(20, 100, 10, 100));

        return hbox;
    }

    public VBox vboxTypePageAdmin(String nom, TextArea textarea){
        VBox vbox = new VBox();
        Label label = this.labelTypePageAdmin(nom);

        vbox.getChildren().addAll(label, textarea);
        vbox.setPadding(new Insets(20, 100, 10, 100));

        return vbox;
    }

    public VBox vboxTypePageAdmin(String nom){
        VBox vbox = new VBox();
        Label label = this.labelTypePageAdmin(nom);
        TextField text = new TextField();

        vbox.getChildren().addAll(label, text);
        vbox.setPadding(new Insets(20, 100, 10, 100));

        return vbox;
    }


    public Button buttonTypePageAdmin(String nom){
        Button bouton = new Button(nom);
        bouton.setTextFill(Color.rgb(196, 196, 196));
        bouton.setBackground(new Background(new BackgroundFill(Color.rgb(179, 71, 91), new CornerRadii(5, false), null)));
        bouton.setPadding(new Insets(10, 50, 10, 50));

        return bouton;
    }

    public HBox hBoxTypetextBouton(String nom){
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        TextField text = new TextField();
        Button bouton = this.buttonTypePageAdmin("Demander en ami");


        hbox.getChildren().addAll(bouton, text);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        return hbox;
    }

    public TableView tableauTypePageAdmin(String... nomsColonnes){

        TableView tableau = new TableView();
        for (String nomC : nomsColonnes){
            TableColumn colonne = new TableColumn(nomC);
            colonne.setMinWidth(130);
            tableau.getColumns().add(colonne);
        }

        tableau.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return tableau;
    }

    public ButtonBar buttonBarTypePageAdmin(String... nomsBoutons){

        ButtonBar barBouton = new ButtonBar();
        for (String nomBouton : nomsBoutons){
            Button bouton = this.buttonTypePageAdmin(nomBouton);
            barBouton.setButtonData(bouton,ButtonData.LEFT);
            barBouton.getButtons().addAll(bouton);
        }
        barBouton.setPadding(new Insets(10, 0, 10, 0));
        return barBouton;
    }

    public ButtonBar buttonBarTypePageAdmin(Button... boutons){

        ButtonBar barBouton = new ButtonBar();
        for (Button bouton : boutons){
            barBouton.setButtonData(bouton,ButtonData.LEFT);
            barBouton.getButtons().add(bouton);
        }
        barBouton.setPadding(new Insets(10, 50, 10, 50));
        return barBouton;
    }

    public HBox imageTypePageAdmin(){

        Image test = new Image("application/inconnu.png");

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

    public TextArea textAeraVerticalNonEditable(){
        TextArea tmessage = new TextArea();
        tmessage.setWrapText(true);
        tmessage.setEditable(false);
        tmessage.setMinSize(200, 600);

        return tmessage;
    }

    public TextArea textAeraVertical(){
        TextArea tmessage = new TextArea();
        tmessage.setWrapText(true);
        tmessage.setEditable(true);
        tmessage.setMinSize(200, 500);

        return tmessage;
    }

    public TextArea textAeraHorizontalNonEditable(){
        TextArea tmessage = new TextArea();
        tmessage.setWrapText(true);
        tmessage.setEditable(false);
        tmessage.setMinSize(500, 200);

        return tmessage;
    }

    public TextArea textAeraHorizontal(){
        TextArea tmessage = new TextArea();
        tmessage.setWrapText(true);
        tmessage.setEditable(true);
        tmessage.setMinSize(500, 200);

        return tmessage;
    }

    public ComboBox comboBoxAdmin(String... nomItem){
        ComboBox cb = new ComboBox();
        for (String nom : nomItem){
            cb.getItems().add(nom);
        }
        return cb;
    }


}
