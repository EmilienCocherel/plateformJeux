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

public class MessageBD {
	private ConnexionMySQL laConnexion;
	private JoueurBD joueurBD;

	public MessageBD(ConnexionMySQL laConnexion, JoueurBD joueurBD) {
		this.laConnexion=laConnexion;
		this.joueurBD = joueurBD;
	}

	/**
	 * @return L'id de partie maximal.
	 */
	public int maxId() {
		try {
			Statement s = laConnexion.createStatement();
			ResultSet res = s.executeQuery("Select max(idMsg) as maxId from MESSAGE");
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
	 * @param message Le message à envoyer
	 * @return L'id du message
	 */
	public int creerMessage(Message m) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement("insert into MESSAGE values (?,?,?,?,?,?)");
		int id = this.maxId() + 1;
		String contenu = m.getObjet()+"\n"+m.getMessage(),
			   lu = m.isLu() ? "O" : "N";
		ps.setInt(1, id);
		ps.setTimestamp(2, new Timestamp(m.getDate().getTime()));
		ps.setString(3, contenu);
		ps.setString(4, lu);
		ps.setInt(5, m.getJoueur1().getIdentifiant());
		ps.setInt(6, m.getJoueur2().getIdentifiant());
		ps.executeUpdate();
		m.setId(id);
		return id;
	}
}
