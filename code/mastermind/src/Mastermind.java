import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Mastermind extends Application{
    private Joueur j1;
    private int id;
    private ArrayList<Combinaison> combis;
    private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;
    private Combinaison combi;


    public Combinaison getCombi(){
      return this.combi;
    }

    public boolean estFinie(){ // À IMPLÉMENTER
        return true;
    }

    public void finPartie(){ // À IMPLÉMENTER
    }

    public void verifCombi(Combinaison test){
    }

    public void initManche(){ // À IMPLÉMENTER

    }

    public void prochaineManche(Manche precedent){
        precedent.getJoueur().setScore(precedent.getJoueur().getScore()+precedent.getNbCoup());
        precedent.getJoueur().nouvelleManche(new Manche(this.combis.get(precedent.getNum()+1),this, precedent.getJoueur(),precedent.getNum()+1));
    }


//    Getter et Setter

    public Joueur getJ1() {
        return j1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    private VBox choixCouleursP1(){
        VBox res=new VBox(5);
        this.p1=new Label();
        res.getChildren().add(this.p1);
        res.setPadding(new Insets(10,10,10,10));
        Label nom = new Label("p1");
        res.getChildren().add(nom);
        ToggleGroup group = new ToggleGroup();
        RadioButton rfacile = new RadioButton("rouge");
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        RadioButton rmoyen = new RadioButton("bleu");
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        RadioButton rdifficile = new RadioButton("vert");
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        RadioButton rexpert = new RadioButton("jaune");
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur1 actionNiveau = new ChoixCouleur1(this,this.j1.getMancheCourante());
        rfacile.setOnAction(actionNiveau);
        rmoyen.setOnAction(actionNiveau);
        rdifficile.setOnAction(actionNiveau);
        rexpert.setOnAction(actionNiveau);
        return res;
    }

    private VBox choixCouleursP2(){
        VBox res=new VBox(5);
        this.p2=new Label();
        res.getChildren().add(this.p2);
        res.setPadding(new Insets(10,10,10,10));
        Label nom = new Label("p2");
        res.getChildren().add(nom);
        ToggleGroup group = new ToggleGroup();
        RadioButton rfacile = new RadioButton("rouge");
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        RadioButton rmoyen = new RadioButton("bleu");
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        RadioButton rdifficile = new RadioButton("vert");
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        RadioButton rexpert = new RadioButton("jaune");
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur2 actionNiveau = new ChoixCouleur2(this,this.j1.getMancheCourante());
        rfacile.setOnAction(actionNiveau);
        rmoyen.setOnAction(actionNiveau);
        rdifficile.setOnAction(actionNiveau);
        rexpert.setOnAction(actionNiveau);
        return res;
    }

    private VBox choixCouleursP3(){
        VBox res=new VBox(5);
        this.p3=new Label();
        res.getChildren().add(this.p3);
        res.setPadding(new Insets(10,10,10,10));
        Label nom = new Label("p3");
        res.getChildren().add(nom);
        ToggleGroup group = new ToggleGroup();
        RadioButton rfacile = new RadioButton("rouge");
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        RadioButton rmoyen = new RadioButton("bleu");
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        RadioButton rdifficile = new RadioButton("vert");
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        RadioButton rexpert = new RadioButton("jaune");
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur3 actionNiveau = new ChoixCouleur3(this,this.j1.getMancheCourante());
        rfacile.setOnAction(actionNiveau);
        rmoyen.setOnAction(actionNiveau);
        rdifficile.setOnAction(actionNiveau);
        rexpert.setOnAction(actionNiveau);
        return res;
    }

    private VBox choixCouleursP4(){
        VBox res=new VBox(5);
        this.p4=new Label();
        this.p4.setText("test");
        res.getChildren().add(this.p4);
        res.setPadding(new Insets(10,10,10,10));
        Label nom = new Label("p4");
        res.getChildren().add(nom);
        ToggleGroup group = new ToggleGroup();
        RadioButton rfacile = new RadioButton("rouge");
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        RadioButton rmoyen = new RadioButton("bleu");
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        RadioButton rdifficile = new RadioButton("vert");
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        RadioButton rexpert = new RadioButton("jaune");
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur4 actionNiveau = new ChoixCouleur4(this,this.j1.getMancheCourante());
        rfacile.setOnAction(actionNiveau);
        rmoyen.setOnAction(actionNiveau);
        rdifficile.setOnAction(actionNiveau);
        rexpert.setOnAction(actionNiveau);
        return res;
    }

    private HBox central(){
        HBox res=new HBox(5);
        res.setAlignment(Pos.CENTER);
        Button brestart = new Button("tester");
        res.getChildren().add(brestart);
        res.setBackground(new Background(new BackgroundFill(Color.LAVENDER,null,null)));
        res.getChildren().add(this.choixCouleursP1());
        res.getChildren().add(this.choixCouleursP2());
        res.getChildren().add(this.choixCouleursP3());
        res.getChildren().add(this.choixCouleursP4());
        return res;
    }

        /**
         * @return le panel contenant le titre du jeu
         */
        private FlowPane titre(){
            FlowPane res = new FlowPane();
            res.setPadding(new Insets(10,10,10,10));
            Label nom = new Label("Matsermind");
            res.getChildren().add(nom);
            res.setAlignment(Pos.CENTER);
            return res;
        }

        /**
         * @return  le graphe de scène de la vue à partir de methodes précédantes
         */
        private Scene laScene(){
            BorderPane cont = new BorderPane();
            cont.setTop(this.titre());
            cont.setCenter(this.central());
            cont.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
            return new Scene(cont,500,450);
        }


        /**
         * charge les images à afficher en fonction des erreurs
         * @param repertoire répertoire où se trouvent les images
         */

        /**
         * Affiche en clair le mot à trouver
         */
        public void afficheReponse(){
            // A implémenter
        }

        /**
         * raffraichit l'affichage en fonction du modèle
         */
        public void majAffichage(){
          this.p1.setText(this.combi.getCouleurP1());
          this.p2.setText(this.combi.getCouleurP2());
          this.p3.setText(this.combi.getCouleurP3());
          this.p4.setText(this.combi.getCouleurP4());
        }

        /**
         * Crée le modèle, charge les images, créer le graphe de scène et lance le jeu
         * @param stage la fenêtre principale
         */
        @Override
        public void start(Stage stage) {
            // création du modèle
            this.combis=new ArrayList<>();
            this.combis.add(new Combinaison(1,2,1,2));
            this.combis.add(new Combinaison(1,2,1,2));
            this.combis.add(new Combinaison(1,2,1,2));
            this.combi = new Combinaison(0,0,0,0);
            stage.setTitle("jeu du pendu");
            this.j1=new Joueur();
            this.j1.nouvelleManche(new Manche(this.combis.get(0),this, this.j1,0));
            stage.setScene(this.laScene());
            stage.show();
            this.majAffichage();
            // démarrage du chrono
        }

        /**
         * Programme principal
         * @param args inutilisé
         */
        public static void main(String[] args) {
            launch(args);
        }

    }
