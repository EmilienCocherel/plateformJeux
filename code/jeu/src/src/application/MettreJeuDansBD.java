package application;

public class MettreJeuDansBD {

    public static void main(String[] args) throws Exception{
        ConnexionMySQL laConnexion;
        System.out.println(args[0]);
        laConnexion=new ConnexionMySQL();
        laConnexion.connecter(args[0],args[1],args[2],args[3]);
        laConnexion.insertJeu(args[4],"la jolie règle",args[5],1);
    }
}
