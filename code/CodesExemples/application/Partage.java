package application;
public class Partage{
    private ConnexionMySQL mySQL;
    private ChoixJeu choixJeu;
    public Partage(ConnexionMySQL mySQL, ChoixJeu choixJeu){
	this.mySQL=mySQL;
	this.choixJeu=choixJeu;
    }

    public ConnexionMySQL getMySQL(){return this.mySQL;}
    public ChoixJeu getChoixJeu(){return this.choixJeu;}
}
