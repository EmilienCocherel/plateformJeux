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
    private JeuProfil jeu;

    public BorderFicheJeu(AppliJDBC app,JeuProfil jeu){
        super();
        this.jeu = jeu;
        this.app = app;
        this.type = labelTypePageJoueur(this.jeu.getIdString());
        this.titre = labelTypePageJoueur(this.jeu.getNomJeu());
        this.description = textAeraHorizontalNonEditable(this.jeu.getDescription());



         this.cotegauche = new GridPane();

        this.cotegauche.add(this.labelTypePageJoueur("Titre :"),0,0);
        this.cotegauche.add(this.titre,1,0);
        this.cotegauche.add(this.labelTypePageJoueur("Type de jeu : "),0,4);
        this.cotegauche.add(this.type,1,4);
        this.cotegauche.setPadding(new Insets(30, 30, 10, 10));

        this.cotehaut= new GridPane();

        // cotehaut.add(this.imageTypePageAdmin(),0,0);
        this.cotehaut.add(cotegauche,1,0);
        this.cotehaut.setPadding(new Insets(30, 30, 10, 10));

        this.cotebas = new GridPane();


        this.cotebas.add(this.labelTypePageJoueur("Description : "),0,1);
        // cotebas.add(this.labelTypePageJoueur(this.description), 0,2);
        this.cotebas.add(this.description,1,1);
        this.cotebas.setPadding(new Insets(30, 30, 10, 10));

        this.setTop(this.cotehaut);
        this.setCenter(this.cotebas);


        this.setBackground(new Background(new BackgroundFill(Color.rgb(53, 56, 61), new CornerRadii(5, false), Insets.EMPTY)));
        this.setPadding(new Insets(0,20,0,20));
        this.setMaxSize(800, 700);
    }
    // public void ajoute(){
    //   this.cotehaut.getChildren().remove(this.cotegauche);
    //   this.cotehaut.add(this.cotegauche,1,0);
    //   this.setTop(this.cotehaut);
    //   this.setCenter(this.cotebas);
    // }
    public Label getTitre(){
      return this.titre;
    }

    public Label getType(){
      return this.type;
    }

    public String getDescription(){
      return this.description.getText();
    }

    // public void setAllGrid(int nType,String newTitre,String desc){
    //   this.cotegauche.getChildren().removeAll(this.type,this.titre);
    //   this.cotebas.getChildren().remove(this.description);
    //   this.cotehaut.getChildren().remove(this.cotegauche);
    //   if (nType == 1){
    //     this.type = labelTypePageJoueur("Tour par tour");
    //     this.cotegauche.add(this.type,1,4);
    //   }
    //   else{
    //     this.type = labelTypePageJoueur("Instantané");
    //     this.cotegauche.add(this.type,1,4);
    //   }
    //   this.titre = labelTypePageJoueur(newTitre);
    //   this.cotegauche.add(this.titre,1,0);
    //   this.description = textAeraHorizontalNonEditable(desc);
    //   this.cotebas.add(this.description,1,1);
    //   this.cotehaut.add(this.cotegauche,1,0);
    //   this.setTop(this.cotehaut);
    //   this.setCenter(this.cotebas);
    // }
}
