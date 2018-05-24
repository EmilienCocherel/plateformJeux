import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControleurMenu implements EventHandler<ActionEvent> {
    TestJDBC testJDBC;
    ControleurMenu(TestJDBC testJDBC){
        this.testJDBC=testJDBC;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        FicheJoueur ficheJoueur=this.testJDBC.getFicheJoueur();
        if (actionEvent.getTarget().getClass().equals(MenuItem.class)){
            String etiquette=((MenuItem)actionEvent.getTarget()).getText();
            switch (etiquette){
                case "Connexion":
                    this.testJDBC.showFenetreConnexion();
                    break;
                case "Déconnexion":
                    try{
                    this.testJDBC.getConnexionMySQL().close();
                    } catch(Exception e){}
                    this.testJDBC.deconnexionReussie();
                    break;
                case "Quitter":
                    try {
                        this.testJDBC.getConnexionMySQL().close();
                        this.testJDBC.stop();
                    } catch (Exception e) { }
                    Platform.exit();
                    System.exit(0);
                    break;
                case "Afficher le plus grand numéro de joueur":
                    try {
                        this.testJDBC.setMessage("Le plus grand numero est " + this.testJDBC.getJoueurBD().maxNumJoueur());
                    }catch (SQLException ex) {
                        this.testJDBC.setMessage("Problème avec la requête\nVoici le message d'erreur\n" + ex.getMessage());
                    }
                    break;
                case "Créer un joueur":
                    ficheJoueur.setNomBouton("Créer");
                    ficheJoueur.activerNumJoueur(false);
                    ficheJoueur.viderFiche();
                    this.testJDBC.showFicheJoueur();
                    break;
                case "Supprimer un joueur":
                    ficheJoueur.setNomBouton("Rechercher");
                    ficheJoueur.viderFiche();
                    ficheJoueur.activerNumJoueur(true);
                    ficheJoueur.setTitre("Suppression");
                    this.testJDBC.showFicheJoueur();
                    break;
                case "Mettre à jour un joueur":
                    ficheJoueur.setNomBouton("Rechercher");
                    ficheJoueur.activerNumJoueur(true);
                    ficheJoueur.viderFiche();
                    ficheJoueur.setTitre("Mise à jour");
                    this.testJDBC.showFicheJoueur();
                    break;
                case "Afficher un joueur":
                    ficheJoueur.setNomBouton("Rechercher");
                    ficheJoueur.activerNumJoueur(true);
                    ficheJoueur.viderFiche();
                    ficheJoueur.setTitre("Consultation");
                    this.testJDBC.showFicheJoueur();
                    break;
                case "Afficher tous les joueurs":
                    String laListe="";
                    try {
                        ArrayList<Joueur> res = this.testJDBC.getJoueurBD().listeDesJoueurs();
                        for (Joueur j:res){
                            laListe+=j.getIdentifiant()+" "+j.getPseudo()+"\n";
                        }
                    }catch (SQLException ex){
                        laListe="La requête a échoué\nVoici le message du serveur\n"+ex.getMessage();
                    }
                    this.testJDBC.showFicheResultat(laListe);
                    break;
                case "Afficher msg par joueur":
                    String rapport="";
                    try {
                        rapport=this.testJDBC.getJoueurBD().rapportMessage();
                    }catch (SQLException ex){
                        rapport="Le traitement a échoué\nVoici le message du serveur\n"+ex.getMessage();
                    }
                    this.testJDBC.showFicheResultat(rapport);
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
