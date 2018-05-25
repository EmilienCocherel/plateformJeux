import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;

public class Joueur {
    private int identifiant;
    private String pseudo;
    private String motdepasse;
    private int niveau;
    private char sexe;
    private boolean abonne;
	  private byte[] avatar;
    private String email;
    private List<Joueur> listeAmi;


    public Joueur(int identifiant, String pseudo, String motdepasse, int niveau, char sexe, boolean abonne, byte[] avatar) {
        this.identifiant = identifiant;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
        this.niveau = niveau;
        this.sexe = sexe
        this.abonne = abonne;
        this.avatar=avatar;
        this.email="";
        this.listeAmi=new ArrayList<>();
    }


    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public boolean isAbonne() {
        return abonne;
    }

    public void setAbonne(boolean abonne) {
        this.abonne = abonne;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
