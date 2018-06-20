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
			   lu = m.getLu() ? "O" : "N";
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

	/**
	 * @param joueur Le joueur
	 * @return les messages reçus par le joueur
	 */
	public List<Message> listeDesMessagesRecusParJoueur(Joueur joueur) throws SQLException {
		List<Message> liste = new ArrayList<>();
		PreparedStatement ps = laConnexion.prepareStatement("Select * from MESSAGE where idUt2 = ?");
		ps.setInt(1, joueur.getIdentifiant());
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			int idMsg = res.getInt("idMsg");
			Joueur joueur1 = this.joueurBD.rechercherJoueurParNum(res.getInt("idUt1"));
			Date dateMsg = res.getTimestamp("dateMsg");
			List<String> contenu = Arrays.asList(res.getString("contenuMsg").split("\n"));
			String objet = contenu.get(0),
				   message = String.join("\n", contenu.subList(1, contenu.size()-1));
			boolean luMsg = res.getString("luMsg").equals("O") ? true : false;

			liste.add(new Message(idMsg, dateMsg, objet, message, luMsg, joueur, joueur1));
		}
		res.close();
		System.out.println(liste);
		return liste;
	}

	/**
	 * @param joueur Le joueur
	 * @return les messages envoyés par le joueur
	 */
	public List<Message> listeDesMessagesEnvoyesParJoueur(Joueur joueur) throws SQLException {
		List<Message> liste = new ArrayList<>();
		PreparedStatement ps = laConnexion.prepareStatement("Select * from MESSAGE where idUt1 = ?");
		ps.setInt(1, joueur.getIdentifiant());
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			int idMsg = res.getInt("idMsg");
			Joueur joueur2 = this.joueurBD.rechercherJoueurParNum(res.getInt("idUt2"));
			Date dateMsg = res.getTimestamp("dateMsg");
			List<String> contenu = Arrays.asList(res.getString("contenuMsg").split("\n"));
			String objet = contenu.get(0),
				   message = String.join("\n", contenu.subList(1, contenu.size()-1));
			boolean luMsg = res.getString("luMsg").equals("O") ? true : false;

			liste.add(new Message(idMsg, dateMsg, objet, message, luMsg, joueur2, joueur));
		}
		res.close();
		System.out.println(liste);
		return liste;
	}
}
