package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

public class ActionMenuAide implements EventHandler<ActionEvent>{
    /**
     * Modèle du jeu
     */
    private Mastermind mastermind;

    public ActionMenuAide(Mastermind mastermind) {
        this.mastermind = mastermind;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MenuItem menu = (MenuItem) actionEvent.getSource();
        String text = menu.getText();
        if (text.equals("A propos")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nous somme la team AJEL,\nC'est nous qui avons codé ce jeu avec le reste de la plateforme pour notre projet de fin d'année à l'IUT informatique d'Orléans.\nRejoignez nous du côté gris de la force.\nL'équipe se compose de:\nAurélien Desprez, Emilien Cocherel\nEdwin Charlotte, Quentin Bernard\nAmélie Dauvois, Etienne Fouquet");
            alert.setTitle("A propos");
            alert.setHeaderText("A propos");
            alert.setGraphic(new ImageView("./img/about_us.gif"));
            ((ImageView)alert.getGraphic()).setFitHeight(60.0);
            ((ImageView)alert.getGraphic()).setFitWidth(60.0);
            alert.setResizable(true);
            alert.showAndWait();
        } else if (text.equals("Tutoriel")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le jeu se déroule en 3 manche,\npour chaque manche la platforme génére\nune combinaison de 4 couleur aléatoire\n(une combinaison peut contenir plusieurs fois la même couleur)\n, chaque joueur jou de son coté\nen essayant de trouver la combinaison.\nA chaque fois qu'une combinaison est testé,\ndes pion noir et doré appraissent en fonction\ndu nombre de pions de la bonne couleur\nou bonne endroit (dorée) et pion de la\n bonne couleur au mauvais endroit(noir).\nle gagnant et le joueur avec le plus grand score");
            alert.setTitle("Tutoriel");
            alert.setResizable(true);
            alert.setHeaderText("Tutoriel");
            alert.showAndWait();
        }
    }
}