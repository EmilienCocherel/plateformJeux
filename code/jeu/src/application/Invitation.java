package application;

import java.util.Date;
import java.sql.SQLException;

public class Invitation {
	private int id;
	private Date date;
	private String etat;
	private Joueur joueur1, joueur2;
	private JeuProfil jeu;

	public Invitation(int id, Date date, String etat, Joueur joueur1, Joueur joueur2, JeuProfil jeu) {
		this.id = id;
		this.date = date;
		this.etat = etat;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.jeu = jeu;
	}

	public int getId() {
		return this.id;
	}

	public Date getDate() {
		return this.date;
	}

	public String getEtat() {
		return this.etat;
	}

	public Joueur getJoueur1() {
		return this.joueur1;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}

	public JeuProfil getJeu() {
		return this.jeu;
	}

	public String getNomJoueur1() {
		return this.joueur1.getPseudo();
	}

	public String getNomJoueur2() {
		return this.joueur2.getPseudo();
	}

	public String getNomJeu() {
		return this.jeu.getNomJeu();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}
}
