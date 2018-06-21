package application;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Date;

public class Rapport {
    private int idRapport;
    private String dateRapport;
    private String titreRapport;
    private int sujetRapport;
    private String contenuRapport;
    private int idJo;
    private String joueur;


    public Rapport(int idRapport, String dateRapport, String titreRapport, int sujetRapport, String contenuRapport, int idJo,String joueur) {
        this.idRapport = idRapport;
        this.dateRapport = dateRapport;
        this.sujetRapport = sujetRapport;
        this.titreRapport = titreRapport;
        this.contenuRapport = contenuRapport;
        this.idJo = idJo;
        this.joueur = joueur;
    }
    public Rapport(int idRapport, String dateRapport, String titreRapport, int sujetRapport, String contenuRapport, int idJo) {
        this.idRapport = idRapport;
        this.dateRapport = dateRapport;
        this.sujetRapport = sujetRapport;
        this.titreRapport = titreRapport;
        this.contenuRapport = contenuRapport;
        this.idJo = idJo;
    }

    public int getIdRapport() {
        return this.idRapport;
    }

    public void setIdRapport(int id) {
        this.idRapport = id;
    }

    public String getDateRapport() {
        return this.dateRapport;
    }

    public void setDateRapport(String nd) {
        this.dateRapport = nd;
    }

    public String getTitreRapport() {
        return this.titreRapport;
    }

    public void setTitreRapport(String nt) {
        this.titreRapport = nt;
    }

    public int getSujetRapport(){
        return this.sujetRapport;
    }

    public void setSujetRapport (int sujet){
        this.sujetRapport = sujet;
    }

    public String getContenuRapport() {
        return this.contenuRapport;
    }

    public void setContenuRapport(String contenu) {
        this.contenuRapport = contenu;
    }

    public int getIdJo() {
        return this.idJo;
    }

    public String getJoueur() {
      return this.joueur;
    }

    public void setIdJo(int id) {
        this.idJo = id;
    }

}
