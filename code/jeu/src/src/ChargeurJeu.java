import java.io.*;
import java.net.*;

public class ChargeurJeu{
    private String repertoireJar;
    ChargeurJeu(String repertoireJar){
	if (repertoireJar.endsWith("/"))
	    this.repertoireJar=repertoireJar;
	else
	    this.repertoireJar=repertoireJar+"/";
    }

    @SuppressWarnings("deprecation")
    Jeu chargerJeu(String nomJar, String nomClasse) throws ClassNotFoundException,InstantiationException,IllegalAccessException,MalformedURLException {
 	File ficJar = new File(this.repertoireJar+nomJar);
	URL[] listeURL = {ficJar.toURL()};
	ClassLoader loader = new URLClassLoader(listeURL);
	return (Jeu)Class.forName(nomClasse,true,loader).newInstance();
    }
}
