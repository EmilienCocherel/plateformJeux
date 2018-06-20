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

public class BorderFicheJeu extends PageJoueur {

    AppliJDBC app;
    private Label titre, type;
    private TextArea description;
    private GridPane cotegauche,cotehaut,cotebas;

    public BorderFicheJeu(AppliJDBC app){
        super();
        this.app = app;
        this.type = labelTypePageJoueur("");
        this.titre = labelTypePageJoueur("");
        this.description = textAeraHorizontalNonEditable("");



         this.cotegauche = new GridPane();

        cotegauche.add(this.labelTypePageJoueur("Titre :"),0,0);
        cotegauche.add(this.titre,1,0);
        cotegauche.add(this.labelTypePageJoueur("Type de jeu : "),0,4);
        cotegauche.add(this.type,1,4);
        cotegauche.setPadding(new Insets(30, 30, 10, 10));

        this.cotehaut= new GridPane();

        // cotehaut.add(this.imageTypePageAdmin(),0,0);
        cotehaut.add(cotegauche,1,0);
        cotehaut.setPadding(new Insets(30, 30, 10, 10));

        this.cotebas = new GridPane();


        cotebas.add(this.labelTypePageJoueur("Description : "),0,1);
        // cotebas.add(this.labelTypePageJoueur(this.description), 0,2);
        cotebas.add(this.description,1,1);
        cotebas.setPadding(new Insets(30, 30, 10, 10));



        this.setTop(cotehaut);
        this.setCenter(cotebas);


        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0,20,0,20));
        this.setMaxSize(800, 700);
    }
    public void ajoute(){
      this.cotehaut.getChildren().remove(this.cotegauche);
      this.cotehaut.add(this.cotegauche,1,0);
      this.setTop(this.cotehaut);
      this.setCenter(this.cotebas);
    }
    public Label getTitre(){
      return this.titre;
    }

    public Label getType(){
      return this.type;
    }

    public String getDescription(){
      return this.description.getText();
    }

    public void setType(int nType){
      this.cotegauche.getChildren().remove(this.type);
      if (nType == 1){
        this.type = labelTypePageJoueur("Tour par tour");
        this.cotegauche.add(this.type,1,4);
      }
      else{
        this.cotegauche.add(this.type = labelTypePageJoueur("Instantané"),1,4);
      }
    }

    public void setNomJeu(String newTitre){
      this.cotegauche.getChildren().remove(this.titre);
      this.cotegauche.add(this.titre = labelTypePageJoueur(newTitre),1,0);
    }

    public void setDescription(String desc){
      this.cotebas.getChildren().remove(this.description);
      this.cotebas.add(this.description = textAeraHorizontalNonEditable(desc),1,1);
    }




    public void remplirJeuProfil(JeuProfil jeu){
      this.ajoute();
      this.setNomJeu(jeu.getNomJeu());
      // this.setIdJeu(jeu.getIdJeu());
      this.setDescription(jeu.getDescription());
      // this.setjarJeu(jeu.getJarJeu());
      // this.setActiveJeu(jeu.isActive());
      this.setType(jeu.getIdType());
    }

}
