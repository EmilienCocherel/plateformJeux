package application;

import java.sql.*;
import java.util.ArrayList;

public class JoueurBD {
	ConnexionMySQL laConnexion;
	JoueurBD(ConnexionMySQL laConnexion){
		this.laConnexion=laConnexion;
	}

	int maxNumJoueur() throws SQLException{
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select max(idJo) as lemax from JOUEUR");
		res.next();
		int dernierJoueur = res.getInt("lemax");
		res.close();
		return dernierJoueur;
	}

	Joueur rechercherJoueurParNum(int num) throws SQLException{
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from JOUEUR where idJo =" + num);
		res.next();
		int numJ = res.getInt("idJo");
		String nomJ = res.getString("pseudo");
		String mdp = res.getString("motdepasse");
		String sexe = res.getString("sexe");
		boolean abo = res.getString("abonne").equals("O");
		int level = res.getInt("niveau");
		byte[] image = res.getBytes("avatar");
		String email = res.getString("emailJo");
		boolean actif = res.getString("activeJo").equals("O");
		boolean resterCo = res.getString("souvenir").equals("O");
		res.close();
		return new Joueur(numJ, nomJ, mdp, sexe.charAt(0), abo, level, image, email, actif, resterCo);
  }

	int insererJoueur( Joueur j) throws SQLException{
		PreparedStatement ps = laConnexion.prepareStatement("insert into JOUEUR values (?,?,?,?,?,?,?,?,?,?)");
		int numJ = this.maxNumJoueur() + 1;
		ps.setInt(1,numJ);
		ps.setString(2,j.getPseudo());
		ps.setString(3,j.getMotdepasse());
		ps.setString(4,j.getSexe() + "");
		String abo = "N";
		if (j.isAbonne()){
			abo = "O";
		}
		ps.setString(5,abo);
		ps.setInt(6,j.getNiveau());
		ps.setBytes(7,j.getAvatar());
		ps.setString(8,j.getEmailJo());
		String actif = "N";
		if (j.isActive()){
			actif = "O";
		}
		ps.setString(9,actif);
		String resterCo = "N";
		if (j.isRemembered()){
			resterCo = "O";
		}
		ps.setString(10,resterCo);
		ps.executeUpdate();
		return numJ;
	}


	void effacerJoueur(int num) throws SQLException{
		Statement s = laConnexion.createStatement();
		s.executeUpdate("Delete from JOUEUR where numJoueur =" + num);
	}


  void majJoueur(Joueur j) throws SQLException{
		PreparedStatement ps = laConnexion.prepareStatement("Update JOUEUR set pseudo = ?,motdepasse = ?, sexe = ?, abonne = ?,	niveau = ?,	avatar = ?, emailJo = ?, activeJo = ?, resterCo = ? where idJo =" + j.getIdentifiant());
		ps.setString(1,j.getPseudo());
		ps.setString(2,j.getMotdepasse());
		ps.setString(3,j.getSexe() + "");
		String abo = "N";
		if (j.isAbonne()){
			abo = "O";
		}
		ps.setString(4,abo);
		ps.setInt(5,j.getNiveau());
		ps.setBytes(6,j.getAvatar());
		ps.setString(7,j.getEmailJo());
		String actif = "N";
		if (j.isActive()){
			actif = "O";
		}
		ps.setString(8,actif);
		ps.setString(9,j.getEmailJo());
		String resterCo = "N";
		if (j.isRemembered()){
			resterCo = "O";
		}
		ps.setString(10, resterCo);
		ps.executeUpdate();

  }

  ArrayList<Joueur> listeDesJoueurs() throws SQLException{
		ArrayList<Joueur> Liste = new ArrayList<Joueur>();
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from JOUEUR");
		while (res.next()){
			int numJ = res.getInt("idJo");
			String nomJ = res.getString("pseudo");
			String mdp = res.getString("motdepasse");
			int level = res.getInt("niveau");
			String sexe = res.getString("sexe");
			boolean abo = res.getString("abonne").equals("O");
			byte[] image = res.getBytes("avatar");
			String mail = res.getString("emailJo");
			boolean actif = res.getString("activeJo").equals("O");
			boolean resterCo = res.getString("souvenir").equals("O");
			Liste.add(new Joueur(numJ, nomJ, mdp, sexe.charAt(0), abo, level, image, mail, actif, resterCo));
		}
		res.close();
		return Liste;
  }

  String rapportMessage() throws SQLException{
	// 	Statement st = laConnexion.createStatement();
	// 	ResultSet rs=st.executeQuery(
	// 					"select j2.pseudo pseudoRec, dateMsg, j1.pseudo pseudoExp, contenuMsg "+
	// 										"from MESSAGE, JOUEUR j1, JOUEUR j2 " +
	// 										"where j1.numJoueur=idUt1 and j2.numJoueur=idUt2 "+
	// 										"order by j2.pseudo, dateMsg");
	// 	String pseudoPrec="", pseudo="111";
	// 	int cpt=0;
	// 	String res="";
	// 	while (rs.next()){
	// 			pseudo=rs.getString(1);
	// 			if (! pseudo.equals(pseudoPrec)){
	// 					if (!pseudoPrec.equals("")){
	// 							res+="Total des messages reçus: "+cpt+"\n\n";
	// 						}
	// 						cpt=0;
	// 					res+="Messages reçus par "+pseudo+"\n";
	// 					pseudoPrec=pseudo;
	// 				}
	// 				cpt+=1;
	// 			res+=rs.getTimestamp(2)+": de "+rs.getString(3)+": "+rs.getString(4)+"\n";
	// 		}
  //
	// 		if (!pseudoPrec.equals("")) {
	// 			res += "Total des messages: " + cpt + "\n\n";
	// 	}
	// 	rs.close();
		return "";
  }
}
