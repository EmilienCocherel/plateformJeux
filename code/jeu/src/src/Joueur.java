import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

public class Joueur {
    private int identifiant;
    private String pseudo;
    private String motdepasse;
    private char sexe;
    private boolean abonne;
    private int niveau;
	  private byte[] avatar;
    private String emailJo;
    private boolean activeJo;
    private boolean souvenir;
    private boolean admin;


    public Joueur(int identifiant, String pseudo, String motdepasse, char sexe, boolean abonne, int niveau, byte[] avatar, String emailJo, boolean activeJo, boolean souvenir, boolean admin) {
        this.identifiant = identifiant;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
        this.sexe = sexe;
        this.abonne = abonne;
        this.niveau = niveau;
        this.avatar=avatar;
        this.emailJo=emailJo;
        this.activeJo = activeJo;
        this.souvenir = souvenir;
        this.admin = admin;
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

    public String getEmailJo(){
      return this.emailJo;
    }

    public void setEmailJo(String mail){
      this.emailJo = mail;
    }

    public boolean isActive(){
      return this.activeJo;
    }

    public void setActiveJo(boolean actif){
      this.activeJo = actif;
    }

    public boolean isRemembered(){
      return this.souvenir;
    }

    public void setSouvenir(boolean souv){
      this.souvenir = souv;
    }

    public boolean isAdmin(){
      return this.admin;
    }

    public void setAdmin(boolean admi){
      this.admin = admi;
    }
}
