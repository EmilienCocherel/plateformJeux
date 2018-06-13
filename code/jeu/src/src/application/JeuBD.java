package application;

import java.sql.*;
import java.util.ArrayList;

public class JeuBD {
	ConnexionMySQL laConnexion;
	JeuBD(ConnexionMySQL laConnexion){
		this.laConnexion=laConnexion;
	}

	public String test(){
		return "yoylol";
	}

	// recherche nombre de joueurs au total
	public int maxNumJeu() throws SQLException{
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select max(idJeu) as lemax from JEU");
		res.next();
		int dernierJeu = res.getInt("lemax");
		res.close();
		return dernierJeu;
	}

	JeuProfil rechercherJeuParNum(int num) throws SQLException{
		Statement s = laConnexion.createStatement();
		ResultSet res = s.executeQuery("Select * from JEU where idJeu =" + num);
		res.next();
		int numJeu = res.getInt("idJeu");
		String nomJ = res.getString("nomJeu");
		String description = res.getString("regleJeu");
		String jarjar = res.getString("jarJeu");
		boolean actif = res.getString("activeJeu").equals("O");
		int idType = res.getInt("idTy");
		res.close();
		return new JeuProfil(numJeu, nomJ, description, jarjar, actif, idType);
  }

	public int insererJeu(JeuProfil j) throws SQLException{
		PreparedStatement ps = laConnexion.prepareStatement("insert into JEU values (?,?,?,?,?,?)");
		int numJeu = this.maxNumJeu() + 1;
		ps.setInt(1,numJeu);
		ps.setString(2,j.getNomJeu());
		ps.setString(3,j.getDescription());
		ps.setString(4,j.getJarJeu());
		String isActif = "N";
		if (j.isActive()){
			isActif = "O";
		}
		ps.setString(5,isActif);
		ps.setInt(6,j.getIdType());
		ps.executeUpdate();
		return numJeu;
	}

  public void majJeu(JeuProfil j) throws SQLException{
		PreparedStatement ps = laConnexion.prepareStatement("Update JEU set nomJeu = ?,regleJeu = ?, jarJeu = ?, activeJeu = ?,	idTy = ? where idJeu =" + j.getIdJeu());
		ps.setString(1,j.getNomJeu());
		ps.setString(2,j.getDescription());
		ps.setString(3,j.getJarJeu());
		String actif = "N";
		if (j.isActive()){
			actif = "O";
		}
		ps.setString(4,actif);
		ps.setInt(5,j.getIdType());
		ps.executeUpdate();

  }

  public ArrayList<Joueur> listeDesJoueurs() throws SQLException{
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
			boolean estAdmin = res.getString("admin").equals("O");
			Liste.add(new Joueur(numJ, nomJ, mdp, sexe.charAt(0), abo, level, image, mail, actif, estAdmin));
		}
		res.close();
		return Liste;
  }

  public String rapportMessage() throws SQLException{
		Statement st = laConnexion.createStatement();
		ResultSet rs=st.executeQuery(
						"select j2.pseudo pseudoRec, dateMsg, j1.pseudo pseudoExp, contenuMsg "+
											"from MESSAGE, JOUEUR j1, JOUEUR j2 " +
											"where j1.idJo = idUt1 and j2.idJo = idUt2 "+
											"order by j2.pseudo, dateMsg");
		String pseudoPrec="", pseudo="111";
		int cpt=0;
		String res="";
		while (rs.next()){
				pseudo = rs.getString(1);
				if (! pseudo.equals(pseudoPrec)){
						if (!pseudoPrec.equals("")){
								res += "Total des messages reçus: " + cpt + "\n\n";
							}
							cpt=0;
						res += "Messages reçus par "+pseudo+"\n";
						pseudoPrec = pseudo;
					}
					cpt += 1;
				res += rs.getTimestamp(2)+": de "+rs.getString(3)+": "+rs.getString(4)+"\n";
			}

			if (!pseudoPrec.equals("")) {
				res += "Total des messages: " + cpt + "\n\n";
		}
		rs.close();
		return res;
  }
}
