package application;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControleurMenuAccueil implements EventHandler<ActionEvent> {
    AppliJDBC AppliJDBC;
    ControleurMenuAccueil(AppliJDBC AppliJDBC){
        this.AppliJDBC=AppliJDBC;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        FicheJoueur ficheJoueur=this.AppliJDBC.getFicheJoueur();
        FicheJeu    ficheJeu   =this.AppliJDBC.getFicheJeu();
        FicheRapport ficheRapport = this.AppliJDBC.getFicheRapport();
        //ChoixJeu choixJeu = this.AppliJDBC.getChoixJeu();
        if (actionEvent.getTarget().getClass().equals(MenuItem.class)){
            String etiquette=((MenuItem)actionEvent.getTarget()).getText();
            switch (etiquette){
                case "Connexion":
                    this.AppliJDBC.showFenetreConnexion();
                    break;
                case "Déconnexion":
                    try{
                    this.AppliJDBC.getConnexion().close();
                    } catch(Exception e){}
                    this.AppliJDBC.deconnexionReussie();
                    break;
                case "Quitter":
                    try {
                        this.AppliJDBC.getConnexion().close();
                        this.AppliJDBC.stop();
                    } catch (Exception e) { }
                    Platform.exit();
                    System.exit(0);
                    break;
                case "Afficher le plus grand numéro de joueur":
                    try {
                        this.AppliJDBC.setMessage("Le plus grand numero est " + this.AppliJDBC.getJoueurBD().maxNumJoueur());
                    }catch (SQLException ex) {
                        this.AppliJDBC.setMessage("Problème avec la requête\nVoici le message d'erreur\n" + ex.getMessage());
                    }
                    break;
                case "Créer un joueur":
                    ficheJoueur.setNomBouton("Créer");
                    ficheJoueur.activerNumJoueur(false);
                    ficheJoueur.viderFiche();
                    this.AppliJDBC.showFicheJoueur();
                    break;
                case "Supprimer un joueur":
                    ficheJoueur.setNomBouton("Rechercher par numéro");
                    ficheJoueur.viderFiche();
                    ficheJoueur.activerNumJoueur(true);
                    ficheJoueur.setTitre("Suppression");
                    this.AppliJDBC.showFicheJoueur();
                    break;
                case "Mettre à jour un joueur":
                    ficheJoueur.setNomBouton("Rechercher par numéro");
                    ficheJoueur.activerNumJoueur(true);
                    ficheJoueur.viderFiche();
                    ficheJoueur.setTitre("Mise à jour par numéro");
                    this.AppliJDBC.showFicheJoueur();
                    break;
                case "Afficher un joueur":
                    ficheJoueur.setNomBouton("Rechercher par numéro");
                    ficheJoueur.activerNumJoueur(true);
                    ficheJoueur.viderFiche();
                    ficheJoueur.setTitre("Consultation");
                    this.AppliJDBC.showFicheJoueur();
                    break;
                case "Afficher un joueur par pseudo":
                    ficheJoueur.setNomBouton("Rechercher par pseudo");
                    ficheJoueur.activerPseudoJoueur(true);
                    ficheJoueur.viderFiche();
                    ficheJoueur.setTitre("Mise à jour par pseudo");
                    this.AppliJDBC.showFicheJoueur();
                    break;
                case "Afficher tous les joueurs":
                    String laListe="";
                    try {
                        ArrayList<Joueur> res = this.AppliJDBC.getJoueurBD().listeDesJoueurs();
                        for (Joueur j:res){
                            laListe+=j.getIdentifiant()+" "+j.getPseudo()+"\n";
                        }
                    }catch (SQLException ex){
                        laListe="La requête a échoué\nVoici le message du serveur\n"+ex.getMessage();
                    }
                    this.AppliJDBC.showFicheResultat(laListe);
                    break;
                case "Afficher msg par joueur":
                    String rapport="";
                    try {
                        rapport=this.AppliJDBC.getJoueurBD().rapportMessage();
                    }catch (SQLException ex){
                        rapport="Le traitement a échoué\nVoici le message du serveur\n"+ex.getMessage();
                    }
                    this.AppliJDBC.showFicheResultat(rapport);
                    break;

                  //JEUX
                case "Ajouter un jeu":
                    ficheJeu.setNomBouton("Ajouter");
                    ficheJeu.activerIdJeu(false);
                    ficheJeu.viderFicheJeu();
                    this.AppliJDBC.showFicheJeu();
                    break;

                case "Afficher le plus grand nombre de jeu":
                  try {
                      this.AppliJDBC.setMessage("Le plus grand numero est " + this.AppliJDBC.getJeuBD().maxNumJeu());
                  }catch (SQLException ex) {
                      this.AppliJDBC.setMessage("Problème avec la requête\nVoici le message d'erreur\n" + ex.getMessage());
                  }
                  break;

                case "Mettre à jour un jeu":
                  ficheJeu.setNomBouton("Rechercher un jeu par numéro");
                  ficheJeu.activerIdJeu(true);
                  ficheJeu.viderFicheJeu();
                  ficheJeu.setTitre("Mise à jour d'un jeu");
                  this.AppliJDBC.showFicheJeu();
                  break;

                case "Afficher un jeu par son numéro":
                    ficheJeu.setNomBouton("Rechercher jeu par numéro");
                    ficheJeu.activerIdJeu(true);
                    ficheJeu.viderFicheJeu();
                    ficheJeu.setTitre("Consultation");
                    this.AppliJDBC.showFicheJeu();
                    break;

                case "Afficher un jeu par son nom":
                    ficheJeu.setNomBouton("Rechercher jeu par nom");
                    ficheJeu.activerNomJeu(true);
                    ficheJeu.viderFicheJeu();
                    ficheJeu.setTitre("Consultation");
                    this.AppliJDBC.showFicheJeu();
                    break;

                case "Afficher la liste des jeux":
                  String laListeJeu="";
                  try {
                      ArrayList<JeuProfil> res = this.AppliJDBC.getJeuBD().listeDesJeux();
                      for (JeuProfil j:res){
                        if(j.isActive()){
                          laListeJeu+=j.getIdJeu()+" "+j.getNomJeu()+"    Actif"+"\n";
                        }
                        else{
                          laListeJeu+=j.getIdJeu()+" "+j.getNomJeu()+"    Inactif"+"\n";
                        }
                      }
                  }catch (SQLException ex){
                      laListeJeu="La requête a échoué\nVoici le message du serveur\n"+ex.getMessage();
                  }
                  this.AppliJDBC.showFicheResultat(laListeJeu);
                  break;


                //RAPPORT
                case "Afficher le plus grand nombre de rapport":
                  try {
                      this.AppliJDBC.setMessage("Le plus grand numero est " + this.AppliJDBC.getRapportBD().maxNumRapport());
                  }catch (SQLException ex) {
                      this.AppliJDBC.setMessage("Problème avec la requête\nVoici le message d'erreur\n" + ex.getMessage());
                  }
                  break;

                case "Afficher un rapport par son numéro":
                    ficheRapport.setNomBouton("Rechercher rapport par numéro");
                    ficheRapport.activerIdRapport(true);
                    ficheRapport.viderFicheRapport();
                    ficheRapport.setTitre("Consultation");
                    this.AppliJDBC.showFicheRapport();
                    break;

                case "Lire un rapport":
                    ficheRapport.setNomBouton("Filtrer les rapports");
                    ficheRapport.activerSujetRapport(true);
                    ficheRapport.viderFicheRapport();
                    ficheRapport.setTitre("Consultation");
                    this.AppliJDBC.showFicheRapport();
                    break;

                case "Liste des rapports":
                  String listeRapports="";
                  try {
                      ArrayList<Rapport> res = this.AppliJDBC.getRapportBD().listeDesRapports();
                      for (Rapport rap:res){
                        listeRapports += rap.getIdRapport()+" "+ rap.getContenuRapport() +" " + rap.getDateRapport()+"\n";
                      }
                  }catch (SQLException ex){
                      listeRapports="La requête a échoué\nVoici le message du serveur\n"+ex.getMessage();
                  }
                  this.AppliJDBC.showFicheResultat(listeRapports);
                  break;

                case "Rédiger un rapport":
                    ficheRapport.setNomBouton("Rédiger");
                    ficheRapport.activerIdRapport(false);
                    ficheRapport.activerDateRapport(false);
                    ficheRapport.viderFicheRapport();
                    this.AppliJDBC.showFicheRapport();
                    break;




                default:
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
			        alert.setTitle("Option non connue !!!! ");
			        alert.setHeaderText("Option "+etiquette+" inconnue");
			        alert.setContentText("Problème de définition des menus");
			        alert.showAndWait();
            }
        }
    }
}
