package application;

//import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class InvitationBD {
	private ConnexionMySQL laConnexion;
	private JoueurBD joueurBD;
	private JeuBD jeuBD;

	public InvitationBD(ConnexionMySQL laConnexion, JeuBD jeuBD, JoueurBD joueurBD) {
		this.laConnexion=laConnexion;
		this.jeuBD = jeuBD;
		this.joueurBD = joueurBD;
	}

	/**
	 * @return L'id de partie maximal.
	 */
	public int maxId() {
		try {
			Statement s = laConnexion.createStatement();
			ResultSet res = s.executeQuery("Select max(idInv) as maxId from INVITATION");
			res.next();
			int max = res.getInt("maxId");
			res.close();
			return max;
		} catch (SQLException ex) {
			return 0;
		}
	}

	/**
	 * Créée une invitation
	 * @param inv L'invitation à envoyer
	 * @return L'id de l'invitation
	 */
	public int creerInvitation(Invitation inv) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement("insert into INVITATION values (?,?,?,?,?,?)");
		int id = this.maxId() + 1;
		String etat;
		if (inv.getEtat().equals("en attente"))
			etat = "E";
		else if(inv.getEtat().equals("acceptée"))
			etat = "A";
		else
			etat = "R";
		ps.setInt(1, id);
		ps.setTimestamp(2, new Timestamp(inv.getDate().getTime()));
		ps.setString(3, etat);
		ps.setInt(4, inv.getJoueur1().getIdentifiant());
		ps.setInt(5, inv.getJoueur2().getIdentifiant());
		ps.setInt(6, inv.getJeu().getIdJeu());
		ps.executeUpdate();
		inv.setId(id);
		return id;
	}

	/**
	 * Met à jour une invitation
	 * @param inv l'invitation à mettre à jour
	 */
	public void majInvitation(Invitation inv) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement("Update INVITATION set dateInv = ?,etatInv = ?, idJo = ?,idJo1 = ?, idJeu = ? where idInv = ?");
		String etat;
		if (inv.getEtat().equals("en attente"))
			etat = "E";
		else if(inv.getEtat().equals("acceptée"))
			etat = "A";
		else
			etat = "R";
		ps.setTimestamp(1, new Timestamp(inv.getDate().getTime()));
		ps.setString(2, etat);
		ps.setInt(3, inv.getJoueur1().getIdentifiant());
		ps.setInt(4, inv.getJoueur2().getIdentifiant());
		ps.setInt(5, inv.getJeu().getIdJeu());
		ps.executeUpdate();
	}

	public List<Invitation> listeInvitationsRecuesEnAttente(Joueur joueur) throws SQLException {
		List<Invitation> liste = new ArrayList<>();
		PreparedStatement ps = laConnexion.prepareStatement("Select * from INVITATION where idJo = ? and etatInv = 'E'");
		ps.setInt(1, joueur.getIdentifiant());
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			int idInv = res.getInt("idInv");
			Date dateInv = res.getTimestamp("dateInv");
			Joueur joueur1 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo"));
			JeuProfil jeu = this.jeuBD.rechercherJeuParNum(res.getInt("idJeu"));

			liste.add(new Invitation(idInv, dateInv, "en attente", joueur1, joueur, jeu));
		}
		res.close();
		System.out.println(liste);
		return liste;
	}
}
