package morpion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

class ClicBouton implements EventHandler<ActionEvent> {

    private Morpion m;
    private MorpionGraphique vue;

    public ClicBouton(Morpion m, MorpionGraphique  vue){
    	this.m=m;
    	this.vue=vue;
    }
    
    @Override
    public void handle(ActionEvent e) {
    	Bouton b=(Bouton) e.getSource();
    	b.setText(""+m.getJoueurCourant());
    	b.setDisable(true);
    	m.jouer(b.ligne,b.colonne);
    	vue.ap.getMySQL().updatePartie(vue.idPartie,m.getEtat(),0,0);
    	vue.afficherGrille();
    	vue.desactiverGrille();
    }
}
