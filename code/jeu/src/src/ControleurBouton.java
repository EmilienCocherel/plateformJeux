import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

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
        JoueurBD jbd=this.AppliJDBC.getJoueurBD();
        JeuBD jeubd =this.AppliJDBC.getJeuBD();
        FicheJoueur ficheJoueur=this.AppliJDBC.getFicheJoueur();
        FicheJeu ficheJeu = this.AppliJDBC.getFicheJeu();
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
                break;
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
                break;

            case "Mettre à jour par pseudo":
                try{
                    jbd.majJoueur(ficheJoueur.getJoueur());
                    alertOK("Le joueur "+ficheJoueur.getPseudoJoueur()+ " a bien été mis à jour");
                    ficheJoueur.viderFiche();
                    ficheJoueur.setNomBouton("Rechercher par pseudo");
                    ficheJoueur.activerPseudoJoueur(true);
                }catch (SQLException ex) {
                    alertEchec(ex);
                }
                break;
        }

    }
}
