package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class BorderProfilUtilisateur extends PageJoueur {

    AppliJDBC app;
    String levelJoueur, estabo;

    public BorderProfilUtilisateur(AppliJDBC app){
        super();
        this.app = app;
        this.levelJoueur = "";
        this.estabo = "";

        GridPane gInfo = new GridPane();
        gInfo.add(this.labelGrosPageJoueur("Pseudo :"), 0, 0);
        gInfo.add(this.labelTypePageJoueur(this.app.getClient().getPseudo()), 1, 0);
        gInfo.add(this.labelGrosPageJoueur("Niveau :"), 0, 1);
        gInfo.add(this.labelTypePageJoueur(this.verifierNiveau()), 1, 1);
        gInfo.add(this.labelGrosPageJoueur("Premium :"), 0, 2);
        gInfo.add(this.labelTypePageJoueur(this.verifierAbo()), 1, 2);

        gInfo.setPadding(new Insets(75, 0, 0, 50));

        Button changerInfo = this.buttonTypePageJoueur("Changer information compte");
        changerInfo.setOnAction(event -> this.app.passerEnModeChgmntInfo());

        Button consulterstats = this.buttonTypePageJoueur("Consulter statistiques");
        consulterstats.setOnAction(event -> this.app.passerEnModeConsulterStatsJeux());

        ButtonBar bar = this.buttonBarTypePageJoueur(changerInfo, consulterstats);
        bar.setPadding(new Insets(0,0,50,0));

        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setMaxSize(800, 700);

        this.setCenter(gInfo);
        this.setRight(this.imageTypePageJoueur());
        this.setBottom(bar);
    }

    public String verifierNiveau(){
      if (this.app.getClient().getNiveau() == 1){
        this.levelJoueur = "Débutant";
      }
      else if (this.app.getClient().getNiveau() == 2){
        this.levelJoueur = "Medium";
      }
      else{
        this.levelJoueur = "Expert";
      }
      return this.levelJoueur;
    }

    public String verifierAbo(){
      if (this.app.getClient().isAbonne()){
        this.estabo = "Abonné";
      }
      else{
        this.estabo = "N'est pas abonné";
      }
      return this.estabo;
    }

    public String getNiveau(){
      return this.levelJoueur;
    }

    public String getAbo(){
      return this.estabo;
    }
}
