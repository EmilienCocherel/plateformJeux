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
    private Manche manche;


    public Combinaison getCombi(){
      return this.combi;
    }

    public boolean estFinie(){ // À IMPLÉMENTER
        if (this.manche.estFini() && this.manche.getNum() == 3){
            return true;
        }
        else{ // Mème si la personne à fait ses 12 coups mais qu'aucun n'est gagnant
            return false;
        }
    }

    public void finPartie(){
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        if (this.estFinie()){
            al.setHeaderText("Bravo !");
        }
        else{
            al.setHeaderText("Zut...");
        }
    }

    public void verifCombi(Combinaison test){
        if (estFinie()){

        }
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
        BoutonRadio rfacile = new BoutonRadio("rouge",1);
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        BoutonRadio rmoyen = new BoutonRadio("bleu",1);
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        BoutonRadio rdifficile = new BoutonRadio("vert",1);
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        BoutonRadio rexpert = new BoutonRadio("jaune",1);
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur actionNiveau = new ChoixCouleur(this,this.j1.getMancheCourante());
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
        BoutonRadio rfacile = new BoutonRadio("rouge",2);
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        BoutonRadio rmoyen = new BoutonRadio("bleu",2);
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        BoutonRadio rdifficile = new BoutonRadio("vert",2);
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        BoutonRadio rexpert = new BoutonRadio("jaune",2);
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur actionNiveau = new ChoixCouleur(this,this.j1.getMancheCourante());
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
        BoutonRadio rfacile = new BoutonRadio("rouge",3);
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        BoutonRadio rmoyen = new BoutonRadio("bleu",3);
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        BoutonRadio rdifficile = new BoutonRadio("vert",3);
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        BoutonRadio rexpert = new BoutonRadio("jaune",3);
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur actionNiveau = new ChoixCouleur(this,this.j1.getMancheCourante());
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
        BoutonRadio rfacile = new BoutonRadio("rouge",4);
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        BoutonRadio rmoyen = new BoutonRadio("bleu",4);
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        BoutonRadio rdifficile = new BoutonRadio("vert",4);
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        BoutonRadio rexpert = new BoutonRadio("jaune",4);
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur actionNiveau = new ChoixCouleur(this,this.j1.getMancheCourante());
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
        TestCombi tc = new TestCombi(this,this.manche);
        brestart.setOnAction(tc);
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
            Label nom = new Label("Mastermind");
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
            this.combis.add(new Combinaison(new Pion(1),new Pion(2),new Pion(2),new Pion(1)));
            this.combis.add(new Combinaison(new Pion(1),new Pion(3),new Pion(1),new Pion(1)));
            this.combis.add(new Combinaison(new Pion(2),new Pion(1),new Pion(1),new Pion(1)));
            this.combi = new Combinaison(new Pion(0),new Pion(0),new Pion(0),new Pion(0));
            stage.setTitle("Mastermind");
            this.j1=new Joueur();
            this.j1.nouvelleManche(new Manche(this.combis.get(0),this, this.j1,0));
            stage.setScene(this.laScene());
            stage.show();
            this.majAffichage();
        }

        /**
         * Programme principal
         * @param args inutilisé
         */
        public static void main(String[] args) {
            launch(args);
        }

    }
