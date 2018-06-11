import java.sql.*;
import java.util.ArrayList;

public class JoueurBD {

	ConnexionMySQL laConnexion;

	public JoueurBD(ConnexionMySQL laConnexion){
		this.laConnexion=laConnexion;
	}

	public int maxNumJoueur() throws SQLException{
		Statement s=laConnexion.createStatement();
		ResultSet r=s.executeQuery("select max(numJoueur) from JOUEUR");
		r.next();
		int val = r.getInt(1);
		return val;
	}


	public int insererJoueur( Joueur j) throws  SQLException{
		PreparedStatement ps = this.laConnexion.prepareStatement("INSERT INTO JOUEUR VALUES (?,?,?,?,?,?,?)");
		ps.setInt(1,this.maxNumJoueur()+1);
		ps.setString(2,j.getPseudo());
		ps.setString(3,j.getMotdepasse());
		ps.setString(4,String.valueOf(j.getSexe()));
		if (j.isAbonne()){
			ps.setString(5,"O");
		}
		else{
			ps.setString(5,"X");
		}
		ps.setInt(6,j.getNiveau());
		ps.setBytes(7,j.getAvatar());
		ps.executeUpdate();
		return this.maxNumJoueur()+1;
	}


	public void effacerJoueur(int num) throws SQLException {
		PreparedStatement ps1 = this.laConnexion.prepareStatement("delete from MESSAGE where idUt1=?");
		PreparedStatement ps2 = this.laConnexion.prepareStatement("delete from MESSAGE where idUt2=?");
		PreparedStatement ps3 = this.laConnexion.prepareStatement("delete from JOUEUR where numJoueur=?");
		ps1.setInt(1,num);
		ps2.setInt(1,num);
		ps3.setInt(1,num);
		ps1.executeUpdate();
		ps2.executeUpdate();
		ps3.executeUpdate();
	}

  public void majJoueur(Joueur j)throws SQLException{
		PreparedStatement ps1 = this.laConnexion.prepareStatement("update JOUEUR set pseudo = ? where numJoueur=?");
		PreparedStatement ps2 = this.laConnexion.prepareStatement("update JOUEUR set motdepasse = ? where numJoueur=?");
		PreparedStatement ps3 = this.laConnexion.prepareStatement("update JOUEUR set sexe = ? where numJoueur=?");
		PreparedStatement ps4 = this.laConnexion.prepareStatement("update JOUEUR set abonne = ? where numJoueur=?");
		PreparedStatement ps5 = this.laConnexion.prepareStatement("update JOUEUR set niveau = ? where numJoueur=?");
		PreparedStatement ps6 = this.laConnexion.prepareStatement("update JOUEUR set avatar = ? where numJoueur=?");
		int num = j.getIdentifiant();
		ps1.setString(1,j.getPseudo());
		ps1.setInt(2,num);
		ps2.setString(1,j.getMotdepasse());
		ps2.setInt(2,num);
		ps3.setString(1,String.valueOf(j.getSexe()));
		ps3.setInt(2,num);
		if (j.isAbonne()){
			ps4.setString(1,"O");
		}
		else{
			ps4.setString(1,"X");
		}
		ps4.setInt(2,num);
		ps5.setInt(1,j.getNiveau());
		ps5.setInt(2,num);
		ps6.setBytes(1,j.getAvatar());
		ps6.setInt(2,num);
		ps1.executeUpdate();
		ps2.executeUpdate();
		ps3.executeUpdate();
		ps4.executeUpdate();
		ps5.executeUpdate();
		ps6.executeUpdate();
	}

  public Joueur rechercherJoueurParNum(int num)throws SQLException{
		PreparedStatement ps = this.laConnexion.prepareStatement("select * from JOUEUR where numJoueur=?");
		ps.setInt(1,num);
		ResultSet r=ps.executeQuery();
		r.next();
		int identifiant = r.getInt(1);
		String pseudo = r.getString(2);
		String motdepasse = r.getString(3);
		String sex = r.getString(4);
		char sexe = sex.charAt(0);
		String abo = r.getString(5);
		boolean abonne = true;
		if(abo.equals("X")){
			abonne = false;
		}
		int niveau = r.getInt(6);
		byte[] avatar = r.getBytes(7);
		Joueur res = new Joueur(identifiant,pseudo,motdepasse,niveau,sexe,abonne,avatar);
		return res;
	}

  public ArrayList<Joueur> listeDesJoueurs() throws SQLException{
		ArrayList<Joueur> res = new ArrayList<>();
		PreparedStatement ps0 = this.laConnexion.prepareStatement("select * from JOUEUR");
		ResultSet rs=ps0.executeQuery();
		while(rs.next()){
			res.add(rechercherJoueurParNum(rs.getInt(1)));
		}
		return res;
	}

  public String rapportMessage() throws SQLException{
		String res="";
		ArrayList<Joueur> liste = this.listeDesJoueurs();
		for (Joueur j : liste){
			res+="\n messages reçus par "+j.getPseudo();
			PreparedStatement ps = this.laConnexion.prepareStatement("select * from MESSAGE where idUt2 = ?");
			ps.setInt(1,j.getIdentifiant());
			ResultSet r=ps.executeQuery();
			int cpt =0;
			while(r.next()){
				res += "\n"+r.getString(2);
				int numExpediteur = r.getInt(5);
				Joueur j2 = this.rechercherJoueurParNum(numExpediteur);
				res += ": de "+j2.getPseudo();
				res += ": "+r.getString(3);
				cpt+=1;
			}
			res += "\n total messages: "+cpt+"\n \n";
		}
    return res;
  }
}
