package application;

import java.util.Date;
import java.sql.SQLException;

public class Partie {
	private int id, numEtape, score1, score2;
	private Date debut;
	private String etat;
	private JeuProfil jeu;
	private Joueur joueur1, joueur2;
	private Joueur joueur;

	public Partie(int id, Date debut, int numEtape, String etat, JeuProfil jeu,
			Joueur joueur1, int score1, Joueur joueur2, int score2) throws SQLException {
		this.id = id;
		this.debut = debut;
		this.numEtape = numEtape;
		this.etat = etat;
		this.jeu = jeu;
		this.joueur1 = joueur1;
		this.score1 = score1;
		this.joueur2 = joueur2;
		this.score2 = score2;
	}

	public Partie(int id, Date debut, int numEtape, String etat, JeuProfil jeu,
			Joueur joueur1, int score1, Joueur joueur2, int score2, Joueur joueur) throws SQLException {
		this.id = id;
		this.debut = debut;
		this.numEtape = numEtape;
		this.etat = etat;
		this.jeu = jeu;
		this.joueur1 = joueur1;
		this.score1 = score1;
		this.joueur2 = joueur2;
		this.score2 = score2;
		this.joueur = joueur;
	}

	public int getId() {
		return this.id;
	}

	public Date getDebut() {
		return this.debut;
	}

	public int getNumEtape() {
		return this.numEtape;
	}

	public String getEtat() {
		return this.etat;
	}

	public JeuProfil getJeu() {
		return this.jeu;
	}

	public Joueur getJoueur1() {
		return this.joueur1;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}

	public int getScore1() {
		return this.score1;
	}

	public int getScore2() {
		return this.score2;
	}

	public String getAdversaire() {
		if (this.joueur1.getIdentifiant() == this.joueur.getIdentifiant())
			return this.joueur2.getPseudo();
		else
			return this.joueur1.getPseudo();
	}

	public String getNomJeu() {
		return this.jeu.getNomJeu();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setJeu(JeuProfil jeu) {
		this.jeu = jeu;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}
}
