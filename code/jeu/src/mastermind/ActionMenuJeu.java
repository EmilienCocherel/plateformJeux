package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

public class ActionMenuJeu implements EventHandler<ActionEvent>{
    private Mastermind mastermind;


    public ActionMenuJeu(Mastermind mastermind) {
        this.mastermind = mastermind;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MenuItem menu = (MenuItem) actionEvent.getSource();
        String text = menu.getText();
        if (text.equals("Quitter")) {
            this.mastermind.fermer();;
        } else if (text.equals("Score")) {
            int score = this.mastermind.getJ1().getScore();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, ""+score);
            alert.setTitle("Score");
            alert.setHeaderText("Score");
            alert.showAndWait();
        }
    }
}