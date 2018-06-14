package mastermind;

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
import javafx.stage.Modality;
import application.*;

public class Mastermind<T> extends application.Jeu<T>{
    private T j1;
    private int id;
    private ArrayList<Combinaison> combis;
    private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;
    private Combinaison combi;
    private Manche manche;
    private Stage stage;

    public Mastermind(int id,T j1){
      this.id=id;
      this.j1=j1;
    }
    public Mastermind(){}

    @Override
    public void jouerCoup(int idPartie, int joueur, Object partage){
    }

    @Override
    public void creerPartie(int idJeu, int idJoueur1, int idJoueur2, Object partage){
    }

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
        precedent.getJoueurMastermind().setScore(precedent.getJoueurMastermind().getScore()+precedent.getNbCoup());
        precedent.getJoueurMastermind().nouvelleManche(new Manche(this.combis.get(precedent.getNum()+1),this, precedent.getJoueurMastermind(),precedent.getNum()+1));
    }


//    Getter et Setter

    public T getJ1() {
        return j1;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setJ1(T j1) {
        this.j1 = j1;
    }
    public String getStringPion(int nbPion){
        switch (nbPion){
            case 0:
                return "p1";
            case 1:
                return "p2";
            case 2:
                return "p3";
            case 3:
                return "p4";
        }
        return null;
    }

    private Label getLabelPion(int nbPion){
        switch (nbPion){
            case 0:
                return this.p1;
            case 1:
                return this.p2;
            case 2:
                return this.p3;
            case 3:
                return this.p4;
        }
        return null;
    }
    }
    private VBox choixCouleurDuPion(int pion){
        VBox res=new VBox(5);
        this.p1=new Label();
        res.getChildren().add(this.getLabelPion(pion));
        res.setPadding(new Insets(10,10,10,10));
        Label nom = new Label(this.getStringPion(pion));
        res.getChildren().add(nom);
        ToggleGroup group = new ToggleGroup();
        BoutonRadio rfacile = new BoutonRadio("rouge",pion);
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        BoutonRadio rmoyen = new BoutonRadio("bleu",pion);
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        BoutonRadio rdifficile = new BoutonRadio("vert",pion);
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        BoutonRadio rexpert = new BoutonRadio("jaune",pion);
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur actionNiveau = new ChoixCouleur(this,((JoueurMastermind)this.j1).getMancheCourante());
        rfacile.setOnAction(actionNiveau);
        rmoyen.setOnAction(actionNiveau);
        rdifficile.setOnAction(actionNiveau);
        rexpert.setOnAction(actionNiveau);
        return res;
    }

    private VBox choixCouleursP1(){
        return this.choixCouleurDuPion(0);
    }

    private VBox choixCouleursP2(){
        return this.choixCouleurDuPion(1);
    }

    private VBox choixCouleursP3(){
        return this.choixCouleurDuPion(2);
    }

    private VBox choixCouleursP4(){
        return this.choixCouleurDuPion(3);
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
         public void run(){
            this.stage = new Stage();
            this.combis=new ArrayList<>();
            this.combis.add(new Combinaison(new Pion(1),new Pion(2),new Pion(2),new Pion(1)));
            this.combis.add(new Combinaison(new Pion(1),new Pion(3),new Pion(1),new Pion(1)));
            this.combis.add(new Combinaison(new Pion(2),new Pion(1),new Pion(1),new Pion(1)));
            this.combi = new Combinaison(new Pion(0),new Pion(0),new Pion(0),new Pion(0));
            stage.setTitle("Mastermind");
             ((JoueurMastermind)this.j1).nouvelleManche(new Manche(this.combis.get(0),this, (JoueurMastermind)this.j1,0));
            stage.setScene(this.laScene());
            stage.show();
            this.majAffichage();
         }
    }
