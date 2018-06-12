package morpion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionTemps implements EventHandler<ActionEvent> {
    private Morpion m;
    private MorpionGraphique vue;

    ActionTemps(Morpion m, MorpionGraphique  vue){
        this.m=m;
        this.vue=vue;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        String etat=this.vue.ap.getMySQL().getEtat(this.vue.idPartie);
        this.m.setEtat(etat);
        this.vue.afficherGrille();
    }
}
