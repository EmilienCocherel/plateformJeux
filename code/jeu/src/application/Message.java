package application;

import java.util.Date;
import java.sql.SQLException;

public class Message {
	private int id;
	private Date date;
	private String objet, message;
	private boolean lu;
	private Joueur joueur1, joueur2;

	public Message(int id, Date date, String objet, String message, boolean lu, Joueur joueur1, Joueur joueur2) {
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.message = message;
		this.lu = lu;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	public int getId() {
		return this.id;
	}

	public Date getDate() {
		return this.date;
	}

	public String getMessage() {
		return this.message;
	}

	public String getObjet() {
		return this.objet;
	}

	public boolean getLu() {
		return this.lu;
	}

	public String getLuTexte() {
		return this.lu ? "V" : "X";
	}

	public Joueur getJoueur1() {
		return this.joueur1;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}

	public String getNomJoueur1() {
		return this.joueur1.getPseudo();
	}

	public String getNomJoueur2() {
		return this.joueur2.getPseudo();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}
}
