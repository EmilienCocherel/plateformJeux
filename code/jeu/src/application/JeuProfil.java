package application;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

public class JeuProfil {
    private int idJeu;
    private String nomJeu;
    private String description;
    private byte[] jarJeu;
    private boolean activeJeu;
    private int idType;


    public JeuProfil(int idJeu, String nomJeu, String description, byte[] jarJeu, boolean activeJeu, int idType) {
        this.idJeu = idJeu;
        this.nomJeu = nomJeu;
        this.description = description;
        this.jarJeu = jarJeu;
        this.activeJeu = activeJeu;
        this.idType = idType;
    }

    public int getIdJeu() {
        return this.idJeu;
    }

    public void setIdjeu(int id) {
        this.idJeu = id;
    }

    public String getNomJeu() {
        return this.nomJeu;
    }

    public void setNomJeu(String nom) {
        this.nomJeu = nom;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public byte[] getJarJeu() {
        return this.jarJeu;
    }

    public void setjarJeu(byte[] jarjar) {
        this.jarJeu = jarjar;
    }

    public boolean isActive() {
        return this.activeJeu;
    }

    public void setActiveJeu(boolean actif) {
        this.activeJeu = actif;
    }

    public int getIdType() {
        return this.idType;
    }
    public String getIdString(){
      if (this.idType == 1){
        return "Tour par tour";
      }
      else{
        return "Instantané";
      }
    }
    public void setIdType(int id) {
        this.idType = id;
    }

}
