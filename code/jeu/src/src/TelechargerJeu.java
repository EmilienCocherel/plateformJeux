
public class TelechargerJeu {

    public static void main(String[] args) throws Exception{
        ConnexionMySQL laConnexion;
        System.out.println(args[0]);
        laConnexion=new ConnexionMySQL();
        laConnexion.connecter(args[0],args[1],args[2],args[3]);
        laConnexion.getJar(args[4],args[5]);
    }
}
