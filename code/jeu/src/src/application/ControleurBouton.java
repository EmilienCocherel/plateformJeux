package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import java.util.ArrayList;

import java.sql.SQLException;

public class ControleurBouton implements EventHandler<ActionEvent> {
    private AppliJDBC AppliJDBC;

    public ControleurBouton(AppliJDBC AppliJDBC) {
        this.AppliJDBC=AppliJDBC;
    }

    private void alertOK( String message){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setWidth(500);
        alert.setTitle("Bravo !!!! ");
        alert.setHeaderText("Opération réussie");
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void alertEchec( SQLException ex){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(true);
        alert.setWidth(500);
        alert.setTitle("Echec !!!! ");
        alert.setHeaderText("Opération a echoué");
        alert.setContentText("Voici le message envoyé par le serveur\n"+ex.getMessage());
        alert.showAndWait();
    }
    @Override

    public void handle(ActionEvent actionEvent) {
        String nom=((Button)actionEvent.getTarget()).getText();
        Joueur j;
        JeuProfil jp;
        Rapport r;
        JoueurBD jbd=this.AppliJDBC.getJoueurBD();
        JeuBD jeubd =this.AppliJDBC.getJeuBD();
        RapportBD rbd = this.AppliJDBC.getRapportBD();
        FicheJoueur ficheJoueur=this.AppliJDBC.getFicheJoueur();
        FicheJeu ficheJeu = this.AppliJDBC.getFicheJeu();
        FicheRapport ficheRapport = this.AppliJDBC.getFicheRapport();
        switch (nom) {
            case "Créer":
                j = ficheJoueur.getJoueur();
                try {
                    int nj = jbd.insererJoueur(j);
                    ficheJoueur.setNumJoueur(nj);
                    alertOK("Insertion du joueur a réussi\nLe nouveau joueur porte le numéro "+nj);
                    ficheJoueur.viderFiche();
                } catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;
            case "Ajouter":
                jp = ficheJeu.getJeu();
                try {
                    int numjeu = jeubd.insererJeu(jp);
                    alertOK("Insertion du jeu a réussi\nLe nouveau jeu porte le numéro "+numjeu);
                    ficheJeu.viderFicheJeu();
                } catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;
            case "Rechercher par numéro":
                try{
                    j = jbd.rechercherJoueurParNum(ficheJoueur.getNumJoueur());
                    ficheJoueur.setJoueur(j);
                    String titre = ficheJoueur.getTitre();
                    switch (titre) {
                        case "Suppression":
                            ficheJoueur.setNomBouton("Supprimer");
                            break;
                        case "Mise à jour par numéro":
                            ficheJoueur.setNomBouton("Mettre à jour par numéro");
                            ficheJoueur.activerNumJoueur(false);
                            break;
                    }

                } catch (SQLException ex) {
                    alertEchec(ex);
                }

            case "Rechercher par pseudo":
                try{
                    j = jbd.rechercherJoueurParPseudo(ficheJoueur.getPseudoJoueur());
                    ficheJoueur.setJoueur(j);
                    String titre = ficheJoueur.getTitre();
                    switch (titre) {
                        case "Mise à jour par pseudo":
                            ficheJoueur.setNomBouton("Mettre à jour par pseudo");
                            ficheJoueur.activerNumJoueur(false);
                            break;
                    }

                } catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;
            case "Supprimer":
                try{
                    jbd.effacerJoueur(ficheJoueur.getNumJoueur());
                    alertOK("Le joueur "+ficheJoueur.getNumJoueur()+" a bien été supprimé");
                    ficheJoueur.viderFiche();
                    ficheJoueur.setNomBouton("Rechercher");
                }catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;
            case "Mettre à jour par numéro":
                try{
                    jbd.majJoueur(ficheJoueur.getJoueur());
                    alertOK("Le joueur "+ficheJoueur.getNumJoueur()+ " a bien été mis à jour");
                    ficheJoueur.viderFiche();
                    ficheJoueur.setNomBouton("Rechercher par numéro");
                    ficheJoueur.activerNumJoueur(true);
                }catch (SQLException ex) {
                    alertEchec(ex);
                }


                // MAJ POUR LE JEU
            case "Mettre à jour le jeu":
                try{
                    jeubd.majJeu(ficheJeu.getJeu());
                    alertOK("Le jeu "+ficheJeu.getIdJeu()+ " a bien été mis à jour");
                    ficheJeu.viderFicheJeu();
                    ficheJeu.setNomBouton("Rechercher jeu par numéro");
                    ficheJeu.activerIdJeu(true);
                }catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;

            case "Mettre à jour par nom":
                try{
                    jeubd.majJeu(ficheJeu.getJeu());
                    alertOK("Le jeu "+ficheJeu.getNomJeu()+ " a bien été mis à jour");
                    ficheJeu.viderFicheJeu();
                    ficheJeu.setNomBouton("Rechercher jeu par nom");
                    ficheJeu.activerNomJeu(true);
                }catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;

            case "Rechercher jeu par numéro":
              try{
                  JeuProfil jeu = jeubd.rechercherJeuParNum(ficheJeu.getIdJeu());
                  ficheJeu.setJeu(jeu);
                  String titre = ficheJeu.getTitre();
                  switch (titre) {
                      case "Suppression":
                          ficheJeu.setNomBouton("Supprimer");
                          break;
                      case "Mise à jour d'un jeu":
                          ficheJeu.setNomBouton("Mettre à jour le jeu");
                          ficheJeu.activerIdJeu(false);
                          break;
                  }

              } catch (SQLException ex) {
                  alertEchec(ex);
              }
              break;

            case "Rechercher jeu par nom":
              try{
                  JeuProfil jeu = jeubd.rechercherJeuParNom(ficheJeu.getNomJeu());
                  ficheJeu.setJeu(jeu);
                  String titre = ficheJeu.getTitre();
                  switch (titre) {
                      case "Suppression":
                          ficheJeu.setNomBouton("Supprimer");
                          break;
                      case "Mise à jour d'un jeu":
                          ficheJeu.setNomBouton("Mettre à jour le jeu");
                          ficheJeu.activerIdJeu(false);
                          break;
                  }

              } catch (SQLException ex) {
                  alertEchec(ex);
              }
              break;


                //RAPPORT
            case "Rechercher rapport par numéro":
              try{
                  r = rbd.rechercherRapportParNum(ficheRapport.getIdRapport());
                  ficheRapport.setRapport(r);
                  String titre = ficheRapport.getTitre();
                  switch (titre) {
                      case "Suppression":
                          ficheRapport.setNomBouton("Supprimer");
                          break;
                      // case "Mise à jour d'un jeu":
                      //     ficheJeu.setNomBouton("Mettre à jour le jeu");
                      //     ficheJeu.activerIdJeu(false);
                      //     break;
                  }

              } catch (SQLException ex) {
                  alertEchec(ex);
              }
              break;

            case "Filtrer les rapports":
              String laListeRapports="";
              try {
                  ArrayList<Rapport> res = this.AppliJDBC.getRapportBD().listeDesRapportsFiltree(ficheRapport.getSujetRapport());
                  for (Rapport rappo:res){
                    laListeRapports += rappo.getIdRapport()+" "+ rappo.getContenuRapport() +" " + rappo.getDateRapport();
                  }
              }catch (SQLException ex){
                  laListeRapports="La requête a échoué\nVoici le message du serveur\n"+ex.getMessage();
              }
              this.AppliJDBC.showFicheResultat(laListeRapports);
              break;

            case "Rédiger":
                r = ficheRapport.getRapport();
                try {
                    int nr = rbd.creerRapport(r);
                    ficheRapport.setIdRapport(nr);
                    alertOK("Insertion du rapport a réussi\nLe nouveau rapport porte le numéro "+nr);
                    ficheRapport.viderFicheRapport();
                } catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;

        }

    }
}
