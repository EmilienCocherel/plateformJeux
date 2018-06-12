import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionBoutonLogin implements EventHandler<ActionEvent> {
    private Login log;
    private CreeCompte compte;

    public ActionBoutonLogin(Login log,CreeCompte compte){
        this.log = log;
        this.compte = compte;
    }

    @Override
    public void handle(ActionEvent action){
        Button b = (Button) action.getSource();
        if (b.getText().endsWith("Créer un compte")){
            this();
        }
    }
}
