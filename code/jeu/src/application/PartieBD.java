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

public class PartieBD {
	private ConnexionMySQL laConnexion;
	private JeuBD jeuBD;
	private JoueurBD joueurBD;

	public PartieBD(ConnexionMySQL laConnexion, JeuBD jeuBD, JoueurBD joueurBD) {
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
			ResultSet res = s.executeQuery("Select max(idPa) as maxId from PARTIE");
			res.next();
			int max = res.getInt("maxId");
			res.close();
			return max;
		} catch (SQLException ex) {
			return 0;
		}
	}

	public Partie rechercherPartieParNum(int num) throws SQLException {
		PreparedStatement s = laConnexion.prepareStatement("select * from PARTIE where idPa = ?");
		s.setInt(1, num);
		ResultSet res = s.executeQuery();
		res.next();
		int idPa = res.getInt("idPa"),
			numEtape = res.getInt("numEtape"),
			score1 = res.getInt("score1"),
			score2 = res.getInt("score2");
		JeuProfil jeu = this.jeuBD.rechercherJeuParNum(res.getInt("idJeu"));
		Joueur joueur1 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo1")),
			   joueur2 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo2"));
		Date debutPa = res.getTimestamp("debutPa");
		String etatPartie = res.getString("etatPartie");
		res.close();
		return new Partie(idPa, debutPa, numEtape, etatPartie, jeu, joueur1, score1, joueur2, score2);
	}

	public int creerPartie(Partie p) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement("insert into PARTIE values (?,?,?,?,?,?,?,?,?)");
		int idPa = this.maxId() + 1;
		ps.setInt(1, idPa);
		ps.setTimestamp(2, new Timestamp(p.getDebut().getTime()));
		ps.setInt(3, p.getNumEtape());
		ps.setString(4, p.getEtat());
		ps.setInt(5, p.getJeu().getIdJeu());
		ps.setInt(6, p.getJoueur1().getIdentifiant());
		ps.setInt(7, p.getScore1());
		ps.setInt(8, p.getJoueur2().getIdentifiant());
		ps.setInt(9, p.getScore2());
		ps.executeUpdate();
		p.setId(idPa);
		return idPa;
	}

	public void majPartie(Partie p) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement(
			"Update PARTIE set debutPa = ?, numEtape = ?, etatPartie = ?, idJeu = ?, idJo1 = ?, score1 = ?, idJo2 = ?, score2 = ? where idPa = ?");
		ps.setTimestamp(1, new Timestamp(p.getDebut().getTime()));
		ps.setInt(2, p.getNumEtape());
		ps.setString(3, p.getEtat());
		ps.setInt(4, p.getJeu().getIdJeu());
		ps.setInt(5, p.getJoueur1().getIdentifiant());
		ps.setInt(6, p.getScore1());
		ps.setInt(7, p.getJoueur2().getIdentifiant());
		ps.setInt(8, p.getScore2());
		ps.setInt(9, p.getId());
		ps.executeUpdate();
	}

	public List<Partie> listeDesPartiesDuJoueur(Joueur joueur) throws SQLException {
		List<Partie> liste = new ArrayList<>();
		PreparedStatement ps = laConnexion.prepareStatement("Select * from PARTIE where idJo1 = ? or idJo2 = ?");
		ps.setInt(1, joueur.getIdentifiant());
		ps.setInt(2, joueur.getIdentifiant());
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			int idPa = res.getInt("idPa"),
				numEtape = res.getInt("numEtape"),
				score1 = res.getInt("score1"),
				score2 = res.getInt("score2");
			JeuProfil jeu = this.jeuBD.rechercherJeuParNum(res.getInt("idJeu"));
			Joueur joueur1 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo1")),
				   joueur2 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo2"));
			Date debutPa = res.getTimestamp("debutPa");
			String etatPartie = res.getString("etatPartie");

			liste.add(new Partie(idPa, debutPa, numEtape, etatPartie, jeu, joueur1, score1, joueur2, score2));
		}
		res.close();
		return liste;
	}

	public List<Partie> listeDesPartiesDuJoueurActuelEnCours(Joueur joueur,AppliJDBC app) throws SQLException {
		List<Partie> liste = new ArrayList<>();
		PreparedStatement ps = laConnexion.prepareStatement("Select * from PARTIE where idJo1 = ? or idJo2 = ? and numEtape = 0");
		ps.setInt(1, joueur.getIdentifiant());
		ps.setInt(2, joueur.getIdentifiant());
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			int idPa = res.getInt("idPa"),
				numEtape = res.getInt("numEtape"),
				score1 = res.getInt("score1"),
				score2 = res.getInt("score2");
			JeuProfil jeu = this.jeuBD.rechercherJeuParNum(res.getInt("idJeu"));
			Joueur joueur1 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo1")),
				   joueur2 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo2"));
			Date debutPa = res.getTimestamp("debutPa");
			String etatPartie = res.getString("etatPartie");

			liste.add(new Partie(idPa, debutPa, numEtape, etatPartie, jeu, joueur1, score1, joueur2, score2, joueur));
		}
		res.close();
		return liste;
	}

	public List<Partie> listeDesPartiesDuJoueurHistorique(Joueur joueur,AppliJDBC app) throws SQLException {
		List<Partie> liste = new ArrayList<>();
		PreparedStatement ps = laConnexion.prepareStatement("Select * from PARTIE where idJo1 = ? or idJo2 = ? and numEtape = 1");
		ps.setInt(1, joueur.getIdentifiant());
		ps.setInt(2, app.getClient().getIdentifiant());
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			int idPa = res.getInt("idPa"),
				numEtape = res.getInt("numEtape"),
				score1 = res.getInt("score1"),
				score2 = res.getInt("score2");
			JeuProfil jeu = this.jeuBD.rechercherJeuParNum(res.getInt("idJeu"));
			Joueur joueur1 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo1")),
				   joueur2 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo2"));
			Date debutPa = res.getTimestamp("debutPa");
			String etatPartie = res.getString("etatPartie");

			liste.add(new Partie(idPa, debutPa, numEtape, etatPartie, jeu, joueur1, score1, joueur2, score2, joueur));
		}
		res.close();
		return liste;
	}

	public List<Partie> listeDesParties() throws SQLException{
		List<Partie> liste = new ArrayList<>();
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from RAPPORT");
		while (res.next()){
			int idPa = res.getInt("idPa"),
				numEtape = res.getInt("numEtape"),
				score1 = res.getInt("score1"),
				score2 = res.getInt("score2");
			JeuProfil jeu = this.jeuBD.rechercherJeuParNum(res.getInt("idJeu"));
			Joueur joueur1 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo1")),
				   joueur2 = this.joueurBD.rechercherJoueurParNum(res.getInt("idJo2"));
			Date debutPa = res.getTimestamp("debutPa");
			String etatPartie = res.getString("etatPartie");

			liste.add(new Partie(idPa, debutPa, numEtape, etatPartie, jeu, joueur1, score1, joueur2, score2));
		}
		res.close();
		return liste;
	}

	public List<JeuProfil> listeJeuFiniJoueur(Joueur joueur) throws SQLException {
		List<JeuProfil> res = new ArrayList<>();
		PreparedStatement ps = laConnexion.prepareStatement("select distinct idJeu from PARTIE where (idJo2 = ? or idJo2 = ?) and numEtape = 1");
		ps.setInt(1, joueur.getIdentifiant());
		ps.setInt(2, joueur.getIdentifiant());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			res.add(this.jeuBD.rechercherJeuParNum(rs.getInt("idJeu")));
		}
		return res;
	}

	public List<Statistique> listeStatsParJeu(Joueur joueur) throws SQLException {
		List<JeuProfil> jeux = this.listeJeuFiniJoueur(joueur);
		List<Statistique> res = new ArrayList<>();
		PreparedStatement victoires = laConnexion.prepareStatement(
				"select count(idPa) from PARTIE where idJeu = ? and numEtape = 1 and ((idJo1 = ? and score1 > score2) or (idJo2 = ? and score2 > score1))");
		victoires.setInt(2, joueur.getIdentifiant());
		victoires.setInt(3, joueur.getIdentifiant());
		ResultSet rs;
		long pourcentVictoire, scoreMoyen;
		for (JeuProfil jeu : jeux) {
			rs = victoires.executeQuery();
			rs.next();
			pourcentVictoire = rs.getLong(1);
			res.add(new Statistique(jeu, pourcentVictoire));
		}
		return res;
	}

	public void majEtat(int idPa, String etatPartie) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement("update PARTIE set etatPartie = ? where idPa = ?");
		ps.setString(1, etatPartie);
		ps.setInt(2, idPa);
		ps.executeUpdate();
	}

	public String getEtat(int idPa) throws SQLException {
		PreparedStatement ps = laConnexion.prepareStatement("select etatPartie from PARTIE where idPa = ?");
		ps.setInt(1, idPa);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getString("etatPartie");
	}
}
