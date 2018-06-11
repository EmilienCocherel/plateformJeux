package application;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class ConnexionMySQL {
	Connection mysql=null;
        boolean connecte=false;
    public ConnexionMySQL(String nomServeur, String nomBase, String nomLogin, String motDePasse) throws ClassNotFoundException,SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	mysql = DriverManager.getConnection("jdbc:mysql://"+nomServeur+":3306/"+nomBase,nomLogin, motDePasse);
	connecte=true;
    }
    public void close() throws  SQLException{this.mysql.close();}

    public void insertJeu(String nom, String regle, String nomFic, int typeJeu){
	File file = new File (nomFic);
	try{
	    FileInputStream reader = new FileInputStream (file);
	    try{
		int taille=reader.available();
		try{
		    PreparedStatement ps= mysql.prepareStatement("insert into JEUTEST values (?,?,?,?,'O',?)");
		    Statement st=mysql.createStatement();
		    ResultSet rs=st.executeQuery("select IFNULL(max(idJeu),0)+1 from JEUTEST");
		    rs.next();
		    int id=rs.getInt(1);
		    ps.setInt(1,id);
		    ps.setString(2,nom);
		    ps.setString(3,regle);
		    ps.setBlob(4,reader,taille);
		    ps.setInt(5,typeJeu);
		    ps.executeUpdate();
		}catch (SQLException exception){
		    System.out.println("Erreur SQL : " + exception.getMessage());
		}
		reader.close();
	    }catch (IOException exception){
		System.out.println("Erreur lors de la lecture : " + exception.toString());
	    }
	}catch (FileNotFoundException exception){
	    System.out.println ("Le fichier n'a pas été trouvé");
	}
    }
    
    public void getJar(String nom, String nomFic){
	File file = new File (nomFic);
	try{
	    FileOutputStream writer = new FileOutputStream (file);
	    try{
		Blob b;
		try{
		    PreparedStatement ps= mysql.prepareStatement("select jarJeu from JEUTEST where nomJeu=?");
		    ps.setString(1,nom);
		    ResultSet rs=ps.executeQuery();
		    rs.next();
		    b=rs.getBlob(1);
		    writer.write(b.getBytes(1,(int)b.length()));
		}catch (SQLException exception){
		    System.out.println("Erreur SQL : " + exception.getMessage());
		}
	
		writer.close();
	    }catch (IOException exception){
		System.out.println("Erreur lors de la lecture : " + exception.toString());
	    }
	}catch (FileNotFoundException exception){
	    System.out.println ("Le fichier n'a pas été trouvé");
	}
    }
    public String getEtat(int idPartie) {
	String etat="";
	try{
	    PreparedStatement ps= mysql.prepareStatement("select etatPartie from PARTIETEST where idPa=?");
	    ps.setInt(1,idPartie);
	    ResultSet rs=ps.executeQuery();
	    rs.next();
	    etat=rs.getString("etatPartie");
	}catch (SQLException exception){
	    System.out.println("Erreur SQL : " + exception.getMessage());
	}
    	return etat;
    }    

    public void setEtat(int idPartie,String etat){
	try{
	    PreparedStatement ps= mysql.prepareStatement("update PARTIETEST set etatPartie=? where idPa=?");
	    ps.setInt(2,idPartie);
	    ps.setString(1,etat);
	    ps.executeUpdate();
	}catch (SQLException exception){
	    System.out.println("Erreur SQL : " + exception.getMessage());
	}
    }    

    public ArrayList<String> getJeux(){
	ArrayList<String> liste= new  ArrayList<String>();
	try{
	    PreparedStatement ps= mysql.prepareStatement("select distinct nomJeu from JEUTEST order by nomJeu");
	    ResultSet rs=ps.executeQuery();
	    while (rs.next()){
		liste.add(rs.getString(1));
	    }
	    rs.close();
	}catch (SQLException exception){
	    System.out.println("Erreur SQL : " + exception.getMessage());
	}
	
	return liste;
    }

    public boolean estUnePartie(int idPartie){
        try {
            Statement st = this.mysql.createStatement();
            ResultSet rs = st.executeQuery("select * from PARTIETEST where idPa=" + idPartie);
            return rs.next();
        }
        catch (SQLException ex){
        return false;}
    }
    public int creerPartie(int idJeu,int idJoueur1,int idJoueur2,String etat){
	int idPartie=-1;
	try{
	    Statement s=mysql.createStatement();
	    ResultSet rs=s.executeQuery("select IFNULL(max(idPa),0) from PARTIETEST");
	    rs.next();
	    idPartie=rs.getInt(1)+1;
	    PreparedStatement ps= mysql.prepareStatement("insert into PARTIETEST values (?,now(),0,?,?,?,?,?,?)");
	    ps.setInt(1,idPartie);
	    ps.setString(2,etat);
	    ps.setInt(3,idJeu);
	    ps.setInt(4,idJoueur1);
	    ps.setInt(5,0);
	    ps.setInt(6,idJoueur2);
	    ps.setInt(7,0);
	    ps.executeUpdate();
	}catch (SQLException exception){
	    System.out.println("Erreur SQL : " + exception.getMessage());
	}
	return idPartie;
    }
    public void updatePartie(int idPartie,String etat, int score1, int score2){
	try{
	    PreparedStatement ps= mysql.prepareStatement("update PARTIETEST set etatPartie=?,numEtape=numEtape+1, score1=?,score2=? where idPa=?");
	    ps.setInt(4,idPartie);
	    ps.setString(1,etat);
	    ps.setInt(2,score1);
	    ps.setInt(3,score2);
	    ps.executeUpdate();
	}catch (SQLException exception){
	    System.out.println("Erreur SQL : " + exception.getMessage());
	}
    }
}
