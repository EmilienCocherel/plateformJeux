import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControleurMenu implements EventHandler<ActionEvent> {
    AppliJDBC AppliJDBC;
    ControleurMenu(AppliJDBC AppliJDBC){
        this.AppliJDBC=AppliJDBC;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        FicheJoueur ficheJoueur=this.AppliJDBC.getFicheJoueur();
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
