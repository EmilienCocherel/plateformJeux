package application;

import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.stage.Stage;
import mastermind.*;

public abstract class Jeu implements Runnable{
    /** permet à un joueur de lancer le jeu en retrouvant l'état actuel de la partie
	 @param idPartie est l'identifiant de la partie dans la base de données
	 @param numJoueur est le numéro du joueur de la partie (1 ou 2)
    **/
    //public abstract void jouerCoup(int idPartie, int numJoueur);
    /** permet de demander à créer une nouvelle partie et de la lancer
	 idJeu est l'identifiant du jeu dans la base de données
	 idJoueur1 et idJoueur2 sont les identifiants des deux participants
	 partage permet de donner acces au jeu à des variables du module joueur
    **/
    //public abstract void creerPartie(int idJeu, int idJoueur1, int idJoueur2);

    public abstract void run();

    //public abstract void setId(int id);

    //public abstract void setJ1(Joueur j1);

	/**
	 * @param partie La partie en cours
	 * @param joueur Le joueur client
	 */
	public abstract void setPartie(Partie partie, int joueur);

	public abstract void setPartieBD(PartieBD partieBD);
}
