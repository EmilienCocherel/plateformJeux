package projet;
import javafx.scene.layout.Pane;
public interface Jeu{
    /** permet à un joueur de lancer le jeu en retrouvant l'état actuel de la partie 
	 @param idPartie est l'identifiant de la partie dans la base de données
	 @param numJoueur est le numéro du joueur de la partie (1 ou 2)
	 @param partage permet de donner acces au jeu à des variables du module joueur
    **/
    public Pane jouerCoup(int idPartie, int numJoueur, Object partage);
    /** permet de demander à créer une nouvelle partie et de la lancer 
	 idJeu est l'identifiant du jeu dans la base de données
	 idJoueur1 et idJoueur2 sont les identifiants des deux participants
	 partage permet de donner acces au jeu à des variables du module joueur
    **/
    public Pane creerPartie(int idJeu, int idJoueur1, int idJoueur2, Object partage);
}
