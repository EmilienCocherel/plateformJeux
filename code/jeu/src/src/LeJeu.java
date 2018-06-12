import javafx.scene.layout.Pane;
import java.sql.Connection;

public class LeJeu implements Jeu  {
    private int joueur;
    private Morpion mp=null;
    private MorpionGraphique mg=null;
    private Partage partage=null;


    public LeJeu(){
	     this.joueur=0;
	     this.mp=null;
	     this.mg=null;
    }

    public Pane jouerCoup(int idPartie, int joueur, Object partage){
    	System.out.println("coucou1");
	    this.partage=(Partage)partage;
	    String etat = this.partage.getMySQL().getEtat(idPartie);
	    //String etat="{\"grille\":[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,2],[0,0,0,1,0]], \"nbAlignes\":3, \"joueurCourant\":1, \"joueurGagnant\":0, \"taille\":5, \"numTour\":2}";//"{\"grille\":[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,2],[0,0,0,1,0]], \"joueurCourant\":1, \"joueurGagnant\":0, \"nbAlignes\":3, \"taille\":5}";
	    this.mp=new Morpion(etat);
	    this.joueur=joueur;
	    this.mg=new MorpionGraphique(this.mp, joueur,this.partage,idPartie);
	    return this.mg;
    }

    public Pane creerPartie(int idJeu, int idJoueur1, int idJoueur2, Object partage){
	     this.partage=(Partage)partage;
	     this.mp=new Morpion(7, 4, 1);
	     int idPartie=this.partage.getMySQL().creerPartie(idJeu,idJoueur1,idJoueur2,mp.getEtat());
	     this.joueur=1;
       this.mg=new MorpionGraphique(this.mp, joueur,this.partage,idJeu);
	     return this.mg;
    }
    public Pane getVueJeu(){
	     return (Pane) this.mg;
    }
}
