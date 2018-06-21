package application;

import java.sql.*;
import java.util.ArrayList;

public class RapportBD {
	ConnexionMySQL laConnexion;
	RapportBD(ConnexionMySQL laConnexion){
		this.laConnexion=laConnexion;
	}

	// recherche nombre de rapport au total
	public int maxNumRapport() throws SQLException{
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select max(idRapport) as lemax from RAPPORT");
		res.next();
		int dernierRapport = res.getInt("lemax");
		res.close();
		return dernierRapport;
	}

	Rapport rechercherRapportParNum(int num) throws SQLException{
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from RAPPORT where idRapport =" + num);
		res.next();
		int idRapport = res.getInt("idRapport");
		String dateRapport = res.getString("dateRapport");
		String titreRapport = res.getString("titreRapport");
		String contenuRapport = res.getString("contenuRapport");
		int idJo = res.getInt("idJo");
		int sujetRapport = res.getInt("sujetRapport");
		res.close();
		return new Rapport(idRapport, dateRapport, titreRapport, sujetRapport, contenuRapport, idJo);
  }

	Rapport rechercherRapportParSujet(int sujet) throws SQLException{
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from RAPPORT where sujetRapport =" + sujet);
		res.next();
		int idRapport = res.getInt("idRapport");
		String dateRapport = res.getString("dateRapport");
		String titreRapport = res.getString("titreRapport");
		String contenuRapport = res.getString("contenuRapport");
		int idJo = res.getInt("idJo");
		int sujetRapport = res.getInt("sujetRapport");
		res.close();
		return new Rapport(idRapport, dateRapport, titreRapport, sujetRapport, contenuRapport, idJo);
  }

	public int creerRapport(Rapport r) throws SQLException{
		PreparedStatement ps = laConnexion.prepareStatement("insert into RAPPORT values (?,?,?,?,?,?)");
		int numRap = this.maxNumRapport() + 1;
		ps.setInt(1,numRap);
		ps.setString(2,r.getDateRapport());
		ps.setString(3,r.getTitreRapport());
		ps.setInt(4,r.getSujetRapport());
		ps.setString(5,r.getContenuRapport());
		ps.setInt(6,r.getIdJo());
		ps.executeUpdate();
		return numRap;
	}

  // public void majJeu(JeuProfil j) throws SQLException{
	// 	PreparedStatement ps = laConnexion.prepareStatement("Update JEU set nomJeu = ?,regleJeu = ?, jarJeu = ?, activeJeu = ?,	idTy = ? where idJeu =" + j.getIdJeu());
	// 	ps.setString(1,j.getNomJeu());
	// 	ps.setString(2,j.getDescription());
	// 	ps.setString(3,j.getJarJeu());
	// 	String actif = "N";
	// 	if (j.isActive()){
	// 		actif = "O";
	// 	}
	// 	ps.setString(4,actif);
	// 	ps.setInt(5,j.getIdType());
	// 	ps.executeUpdate();
  //
  // }
  //
  public ArrayList<Rapport> listeDesRapportsFiltree(int sujet) throws SQLException{
		ArrayList<Rapport> Liste = new ArrayList<Rapport>();
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from RAPPORT where sujetRapport =" + sujet);
		while (res.next()){
			int idRapport = res.getInt("idRapport");
			String dateRapport = res.getString("dateRapport");
			String titreRapport = res.getString("titreRapport");
			String contenuRapport = res.getString("contenuRapport");
			int idJo = res.getInt("idJo");
			int sujetRapport = res.getInt("sujetRapport");

			// ResultSet res2 = s.executeQuery("Select pseudo from JOUEUR where idJo =" + idJo);
			// String pseudoEnv = res2.getString("pseudo");

			Liste.add(new Rapport(idRapport, dateRapport, titreRapport, sujetRapport, contenuRapport, idJo));
		}
		res.close();
		return Liste;
  }

	public ArrayList<Rapport> listeDesRapports() throws SQLException{
		ArrayList<Rapport> Liste = new ArrayList<Rapport>();
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from RAPPORT");
		while (res.next()){
			int idRapport = res.getInt("idRapport");
			String dateRapport = res.getString("dateRapport");
			String titreRapport = res.getString("titreRapport");
			String contenuRapport = res.getString("contenuRapport");
			int idJo = res.getInt("idJo");
			int sujetRapport = res.getInt("sujetRapport");

			Liste.add(new Rapport(idRapport, dateRapport, titreRapport, sujetRapport, contenuRapport, idJo));
		}
		res.close();
		return Liste;
  }
  //
  // public String rapportMessage() throws SQLException{
	// 	Statement st = laConnexion.createStatement();
	// 	ResultSet rs=st.executeQuery(
	// 					"select j2.pseudo pseudoRec, dateMsg, j1.pseudo pseudoExp, contenuMsg "+
	// 										"from MESSAGE, JOUEUR j1, JOUEUR j2 " +
	// 										"where j1.idJo = idUt1 and j2.idJo = idUt2 "+
	// 										"order by j2.pseudo, dateMsg");
	// 	String pseudoPrec="", pseudo="111";
	// 	int cpt=0;
	// 	String res="";
	// 	while (rs.next()){
	// 			pseudo = rs.getString(1);
	// 			if (! pseudo.equals(pseudoPrec)){
	// 					if (!pseudoPrec.equals("")){
	// 							res += "Total des messages reçus: " + cpt + "\n\n";
	// 						}
	// 						cpt=0;
	// 					res += "Messages reçus par "+pseudo+"\n";
	// 					pseudoPrec = pseudo;
	// 				}
	// 				cpt += 1;
	// 			res += rs.getTimestamp(2)+": de "+rs.getString(3)+": "+rs.getString(4)+"\n";
	// 		}
  //
	// 		if (!pseudoPrec.equals("")) {
	// 			res += "Total des messages: " + cpt + "\n\n";
	// 	}
	// 	rs.close();
	// 	return res;
  // }
}
