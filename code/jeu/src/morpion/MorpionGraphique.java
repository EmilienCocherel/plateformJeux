package morpion;

import javafx.application.Application;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.util.Duration;
import application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MorpionGraphique extends Application {
    private GridPane gridPane;
    private Button [][] gb=null;
    private Label msg=null;
    private Morpion mp=null;
    private int joueur;
    public  Partage ap;
    public int idPartie;

    public MorpionGraphique(Morpion mp, int joueur, Partage ap,int idPartie){
      this.gridPane=new GridPane();
    	this.joueur=joueur;
    	this.mp=mp;
    	this.ap=ap;
    	this.creerGrille();
    	this.afficherGrille();
    	this.idPartie=idPartie;
    	ActionTemps actionTemps=new ActionTemps(mp,this);
    	KeyFrame keyFrame = new KeyFrame(Duration.seconds(10),actionTemps);
    	Timeline timeline= new Timeline(keyFrame);
    	timeline.setCycleCount(Animation.INDEFINITE);
    	timeline.play();
    }

    public void creerGrille(){
    	int taille=mp.getTaille();
    	ClicBouton cb=new ClicBouton(mp,this);
    	this.gridPane.setAlignment(Pos.CENTER);
    	gb=new Button[taille][taille];
    	for (int i =0; i<taille; i++)
  	  for (int j=0;j<taille;j++){
    	Bouton bt=new Bouton(i,j);
    	if (mp.getVal(i,j)==0)
  		  bt.setText("");
  		else{
  		  bt.setText(""+mp.getVal(i,j));
  		  bt.setDisable(true);
  		}
  		bt.setMinHeight(30);
  		bt.setMinWidth(30);
  		bt.setOnAction(cb);
  		gb[i][j]=bt;
  		this.gridPane.add(bt,j,i);
  	  }
  	  msg=new Label();
  	  msg.setText("C'est au joueur "+mp.getJoueurCourant()+" de jouer");
  	  this.gridPane.add(msg,2,taille,taille,1);
    }

  public void setMessage(String message){
	   msg.setText(message);
  }

  public void desactiverGrille(){
  	int taille=mp.getTaille();
  	for (int i =0; i<taille; i++)
  	    for (int j=0;j<taille;j++){
  		    gb[i][j].setDisable(true);
  	    }
  }


  public void afficherGrille(){
  	int taille=mp.getTaille();
  	for (int i =0; i<taille; i++)
  	    for (int j=0;j<taille;j++){
  		if (mp.getVal(i,j)==0){
  		    gb[i][j].setText("");
  		    gb[i][j].setDisable(false);
  		}
  		else{
  		    gb[i][j].setText(""+mp.getVal(i,j));
  		    gb[i][j].setDisable(true);
  		}
  	    }
  	if (mp.getJoueurGagnant()!=0){
  	    if (joueur==mp.getJoueurGagnant())
  	    	msg.setText("Vous avez gagné");
  	    else
  		msg.setText("Vous avez perdu");
  	    desactiverGrille();
  	}
  	else
  	    if (mp.getJoueurCourant()==joueur)
  		msg.setText("C'est à vous de jouer");
  	    else{
  		msg.setText("C'est à votre adversaire de jouer");
  		desactiverGrille();
  	    }
    }

    public void majAffichage(){}

    @Override
        public void start(Stage stage) {
            // création du modèle
            stage.setTitle("Morpion");
            stage.setScene(new Scene(this.gridPane,500,450));
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
