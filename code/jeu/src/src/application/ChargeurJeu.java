package application;

import java.io.*;
import java.net.*;
import javafx.stage.Stage;
import javafx.application.Application;
import morpion.*;
import mastermind.*;
import javafx.application.Platform;

public class ChargeurJeu{
    private String repertoireJar;

    public ChargeurJeu(String repertoireJar){
    	if (repertoireJar.endsWith("/")){
        this.repertoireJar=repertoireJar;
      }
    	else{
        this.repertoireJar=repertoireJar+"/";
      }
    }

    @SuppressWarnings("deprecation")
    public void chargerJeu(String nomJar, String nomClasse) throws ClassNotFoundException,InstantiationException,IllegalAccessException,MalformedURLException {
     	File ficJar = new File(this.repertoireJar+nomJar);
    	URL[] listeURL = {ficJar.toURL()};
      String[] args = {};
    	ClassLoader loader = new URLClassLoader(listeURL);
    	//return (Jeu)Class.forName(nomClasse,true,loader).newInstance();
      //Class jeu = (Jeu)Class.forName(nomClasse,true,loader);
      //jeu.main(args);
      //Application.launch(Mastermind.class,args);

      //Jeu jeu = (Jeu)Class.forName(nomClasse,true,loader).newInstance();
      //Platform.runLater(jeu)
      Platform.runLater(new Mastermind(1,new JoueurMastermind(10)));

      //jeu.start(new Stage());
      //Class.forName(nomClasse,true,loader).newInstance();
      //Platform.runLater(new Runnable() {
      //public void run() {
      //     new Class.forName(nomClasse,true,loader).start(new Stage());}});
    }
}
