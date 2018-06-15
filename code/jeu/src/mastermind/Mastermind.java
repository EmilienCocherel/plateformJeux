package mastermind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import application.*;

public class Mastermind extends application.Jeu{
    private JoueurMastermind j1;
    private int id;
    private ArrayList<Combinaison> combis;
    private Combinaison aTester;
    private Manche manche;
    private Stage stage;
    private Label historique;
    private Scene scene;
    private HBox interfaceChoix;
    private VBox historiqueCombinaison;

    public Mastermind(int id,JoueurMastermind j1){
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

    public Combinaison getATester(){
      return this.aTester;
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

    public Label getHistorique(){
      return this.historique;
    }


    public void prochaineManche(Manche precedent){
        precedent.getJoueurMastermind().setScore(precedent.getJoueurMastermind().getScore()+precedent.getNbCoup());
        precedent.getJoueurMastermind().nouvelleManche(new Manche(this.combis.get(precedent.getNum()+1),this, precedent.getJoueurMastermind(),precedent.getNum()+1));
    }


    public JoueurMastermind getJ1() {
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
    public void setJ1(Joueur joueur) {
      this.j1 = new JoueurMastermind(joueur.getIdentifiant());
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

    private Circle getPion(int nbPion){
        switch (nbPion){
            case 0:
                return this.aTester.getP1();
            case 1:
                return this.aTester.getP2();
            case 2:
                return this.aTester.getP3();
            case 3:
                return this.aTester.getP4();
        }
        return null;
    }
    private VBox choixCouleurDuPion(int val){
        VBox res=new VBox(5);
        res.getChildren().add(this.getPion(val));
        res.setPadding(new Insets(10,10,10,10));
        Label nom = new Label(this.getStringPion(val));
        res.getChildren().add(nom);
        ToggleGroup group = new ToggleGroup();
        BoutonRadio rfacile = new BoutonRadio("rouge",val);
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        BoutonRadio rmoyen = new BoutonRadio("bleu",val);
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        BoutonRadio rdifficile = new BoutonRadio("vert",val);
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        BoutonRadio rexpert = new BoutonRadio("jaune",val);
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


    private void initHistoriqueCombinaison(){
        VBox res=new VBox(5);
        res.setAlignment(Pos.CENTER);
        for(Combinaison combi:this.manche.getCombiParTour()){
            HBox box = new HBox();
            box.getChildren().add(combi.getP1());
            box.getChildren().add(combi.getP2());
            box.getChildren().add(combi.getP3());
            box.getChildren().add(combi.getP4());
            res.getChildren().add(box);
        }
        this.historiqueCombinaison=res;
    }

    private void initInterfaceChoix(){
        HBox res=new HBox(5);
        res.setAlignment(Pos.CENTER);
        Button brestart = new Button("tester");
        ActionTester actionTester = new ActionTester(this,this.j1.getMancheCourante());
        brestart.setOnAction(actionTester);
        res.getChildren().add(brestart);
        res.setBackground(new Background(new BackgroundFill(Color.LAVENDER,null,null)));
        res.getChildren().add(this.choixCouleursP1());
        res.getChildren().add(this.choixCouleursP2());
        res.getChildren().add(this.choixCouleursP3());
        res.getChildren().add(this.choixCouleursP4());
        this.historique = new Label();
        res.getChildren().add(historique);
        this.interfaceChoix=res;
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
        private void laScene(){
            BorderPane cont = new BorderPane();
            cont.setTop(this.titre());
            cont.setCenter(this.historiqueCombinaison);
            cont.setBottom(this.interfaceChoix);
            cont.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
            this.scene = new Scene(cont,500,600);
        }


        /**
         * charge les images à afficher en fonction des erreurs
         * @param repertoire répertoire où se trouvent les images
         */


        /**
         * raffraichit l'affichage en fonction du modèle
         */
        public void majAffichage(){
          this.aTester.getP1().setFill(this.aTester.getCouleurP1());
          this.aTester.getP2().setFill(this.aTester.getCouleurP2());
          this.aTester.getP3().setFill(this.aTester.getCouleurP3());
          this.aTester.getP4().setFill(this.aTester.getCouleurP4());
          //this.initHistoriqueCombinaison();
          //this.historique.setText(this.manche.getLog());
        }


         @Override
         public void run(){
            this.stage = new Stage();
            this.combis=new ArrayList<>();
            this.combis.add(new Combinaison(new Pion(Color.RED,1),new Pion(Color.RED,2),new Pion(Color.RED,3),new Pion(Color.RED,4)));
            this.combis.add(new Combinaison(new Pion(Color.RED,1),new Pion(Color.RED,2),new Pion(Color.RED,3),new Pion(Color.BLUE,4)));
            this.combis.add(new Combinaison(new Pion(Color.RED,1),new Pion(Color.RED,2),new Pion(Color.RED,3),new Pion(Color.RED,4)));
            this.aTester = new Combinaison(new Pion(Color.WHITE,1),new Pion(Color.WHITE,2),new Pion(Color.WHITE,3),new Pion(Color.WHITE,4));
            stage.setTitle("Mastermind");
            this.j1.nouvelleManche(new Manche(this.combis.get(0),this, this.j1,0));
            this.manche=this.j1.getMancheCourante();
            this.manche.initCombiParTour();
            this.initInterfaceChoix();
             this.initHistoriqueCombinaison();
            this.laScene();
            stage.setScene(this.scene);
            stage.show();
            this.majAffichage();
         }
    }
