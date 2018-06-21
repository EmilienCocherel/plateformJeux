package application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;




public class BorderRedigerRapport extends PageAdmin {

    private AppliJDBC app;
    private Label pseudo;
    private TextField objet;
    private TextArea tMessage;
    private ComboBox cb;
    private RapportBD bd;
    private SimpleDateFormat lecteur;
    private Date date;

    public BorderRedigerRapport(AppliJDBC app,RapportBD bd) {
        super();
        this.app = app;
        this.bd = bd;

        GridPane grid = new GridPane();

        Button bMenu = this.buttonTypePageAdmin("Accueil");
        bMenu.setOnAction(event -> this.app.passerEnModeAccueil());

        Button bEnregistrer = this.buttonTypePageAdmin("Enregistrer");
        ActionEnregistrementRapport action = new ActionEnregistrementRapport(this,this.app);
        bEnregistrer.setOnAction(action);

        this.cb = comboBoxAdmin("Bug","Information","Message","Bannissement","Debannissement","Autre");
        this.pseudo = labelTypePageAdmin(this.app.getClient().getPseudo());
        this.objet = new TextField();
        this.lecteur = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        this.date = new Date();

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0, 20, 0, 20));
        this.setMaxSize(800, 700);

        this.tMessage = new TextArea();
        tMessage.setMinSize(500, 400);

        grid.setPadding(new Insets(50, 0, 0, 0));

        grid.add(this.labelTypePageAdmin("Auteur : "), 0, 0);
        grid.add(this.pseudo, 1, 0);
        grid.add(this.labelTypePageAdmin("Nom du rapport : "), 0, 1);
        grid.add(this.objet,1, 1);
        grid.add(this.labelTypePageAdmin("Sujet : "), 0, 2);
        grid.add(this.cb,1,2);
        grid.add(this.labelTypePageAdmin("Message : "), 0, 3);
        grid.add(this.tMessage, 1, 3);
        this.setCenter(grid);
        this.setBottom(this.buttonBarTypePageAdmin(bMenu, bEnregistrer));
        grid.setMargin(this.cb,new Insets(6,0,10,0));
    }
    public void ajouterRapport() throws SQLException{
      // try {
        this.bd.creerRapportVoid(new Rapport(this.bd.maxNumRapport(),this.date.toString(),this.objet.getText(),this.getElemCB(),this.tMessage.getText(),this.app.getClient().getIdentifiant()));
      // }
      // catch(SQLException e){
      //   throw new SQLException(e);
      // }
    }
    public int getElemCB(){
      int sujetRapport;
      if (this.cb.getValue().equals("Bug"))
          sujetRapport = 1;
      else if (this.cb.getValue().equals("Information"))
          sujetRapport = 2;
      else if (this.cb.getValue().equals("Message"))
          sujetRapport = 3;
      else if (this.cb.getValue().equals("Bannissement"))
          sujetRapport = 4;
      else if (this.cb.getValue().equals("Debannissement"))
          sujetRapport = 5;
      else
          sujetRapport = 6;
      return sujetRapport;
    }
}
