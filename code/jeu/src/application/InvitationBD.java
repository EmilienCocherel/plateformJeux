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
	 * Créée un message
	 * @param inv L'invitation à envoyer
	 * @return L'id de l'invitation
	 */
	public int creerInvitation(Invitation inv) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement("insert into INVITATION values (?,?,?,?,?,?)");
		int id = this.maxId() + 1;
		String etat;
		if (inv.getEtat().equals("en attente"))
			etat = "E";
		else if(inv.getEtat().equals("accepté"))
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
}
