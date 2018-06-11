import java.sql.*;
import java.util.ArrayList;

public class JoueurBD {
	Connexion laConnexion;
	JoueurBD(Connexion laConnexion){
		this.laConnexion=laConnexion;
	}

	int maxNumJoueur() throws SQLException{
		// PreparedStatement ps = laConnexion.prepareStatement("");
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
		res.close();
		return new Joueur(numJ, nomJ, mdp, sexe.charAt(0), abo, level, image, email, actif);
  }
  //
	int insererJoueur( Joueur j) throws SQLException{
	// 	PreparedStatement ps = laConnexion.prepareStatement("insert into JOUEUR values (?,?,?,?,?,?,?)");
	// 	int numJ = this.maxNumJoueur() + 1;
	// 	ps.setInt(1,numJ);
	// 	ps.setString(2,j.getPseudo());
	// 	ps.setString(3,j.getMotdepasse());
	// 	ps.setString(4,j.getSexe() + "");
	// 	String abo = "N";
	// 	if (j.isAbonne()){
	// 		abo = "O";
	// 	}
	// 	ps.setString(5,abo);
	// 	ps.setInt(6,j.getNiveau());
	// 	ps.setBytes(7,j.getAvatar());
	// 	ps.executeUpdate();
		return -1;
  //
	}
  //
  //
	void effacerJoueur(int num) throws SQLException{
	// 	Statement s = laConnexion.createStatement();
	// 	s.executeUpdate("Delete from JOUEUR where numJoueur =" + num);
	}
  //
  void majJoueur(Joueur j) throws SQLException{
	// 	PreparedStatement ps = laConnexion.prepareStatement("Update JOUEUR set pseudo = ?,motdepasse = ?,sexe = ?,abonne = ?,	niveau = ?,	avatar = ? where numJoueur =" + j.getIdentifiant());
	// 	ps.setString(1,j.getPseudo());
	// 	ps.setString(2,j.getMotdepasse());
	// 	ps.setString(3,j.getSexe() + "");
	// 	String abo = "N";
	// 	if (j.isAbonne()){
	// 		abo = "O";
	// 	}
	// 	ps.setString(4,abo);
	// 	ps.setInt(5,j.getNiveau());
	// 	ps.setBytes(6,j.getAvatar());
	// 	ps.executeUpdate();
  //
  }
  //
  ArrayList<Joueur> listeDesJoueurs() throws SQLException{
	// 	ArrayList<Joueur> Liste = new ArrayList<Joueur>();
	// 	Statement s = laConnexion.createStatement();
	// 	ResultSet res = s.executeQuery("Select * from JOUEUR");
	// 	while (res.next()){
	// 		int numJ = res.getInt("numJoueur");
	// 		String nomJ = res.getString("pseudo");
	// 		String mdp = res.getString("motdepasse");
	// 		int level = res.getInt("niveau");
	// 		String sexe = res.getString("sexe");
	// 		boolean abo = res.getString("abonne").equals("O");
	// 		byte[] image = res.getBytes("avatar");
	// 		Liste.add(new Joueur(numJ, nomJ, mdp, level, sexe.charAt(0), abo, image));
	// 	}
	// 	res.close();
		return null;
  }
  //
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
