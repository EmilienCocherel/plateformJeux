package mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;



public class ChoixCouleur implements EventHandler<ActionEvent> {


	private Mastermind partie;
	private Manche manche;


	public ChoixCouleur(Mastermind partie,Manche manche) {
	    this.partie = partie;
	    this.manche = manche;
	}


	@Override
	public void handle(ActionEvent actionEvent) {
		 SliderCouleur sc =(SliderCouleur) actionEvent.getSource();
		 if (sc.getValPion()==0){
		 	if (sc.getValue()==0.0){
		 		partie.getATester().getP1().setFill(Color.RED);
		 	}
		 	if (sc.getValue()==1.0){
		 		partie.getATester().getP1().setFill(Color.BLUE);
		 	}
		 	if (sc.getValue()==2.0){
		 		partie.getATester().getP1().setFill(Color.GREEN);
		 	}
		 	if (sc.getValue()==3.0){
		 		partie.getATester().getP1().setFill(Color.YELLOW);
		 	}
		 }

		 if (sc.getValPion()==1){
		 	if (sc.getValue()==0.0){
		 		partie.getATester().getP2().setFill(Color.RED);
		 	}
		 	if (sc.getValue()==1.0){
		 		partie.getATester().getP2().setFill(Color.BLUE);
		 	}
		 	if (sc.getValue()==2.0){
		 		partie.getATester().getP2().setFill(Color.GREEN);
		 	}
		 	if (sc.getValue()==3.0){
		 		partie.getATester().getP2().setFill(Color.YELLOW);
		 	}
		 }

		 if (sc.getValPion()==2){
		 	if (sc.getValue()==0.0){
		 		partie.getATester().getP3().setFill(Color.RED);
		 	}
		 	if (sc.getValue()==1.0){
		 		partie.getATester().getP3().setFill(Color.BLUE);
		 	}
		 	if (sc.getValue()==2.0){
		 		partie.getATester().getP3().setFill(Color.GREEN);
		 	}
		 	if (sc.getValue()==3.0){
		 		partie.getATester().getP3().setFill(Color.YELLOW);
		 	}
		 }

		 if (sc.getValPion()==3){
		 	if (sc.getValue()==0.0){
		 		partie.getATester().getP4().setFill(Color.RED);
		 	}
		 	if (sc.getValue()==1.0){
		 		partie.getATester().getP4().setFill(Color.BLUE);
		 	}
		 	if (sc.getValue()==2.0){
		 		partie.getATester().getP4().setFill(Color.GREEN);
		 	}
		 	if (sc.getValue()==3.0){
		 		partie.getATester().getP4().setFill(Color.YELLOW);
		 	}
		 }
		 partie.majAffichage();


		//BoutonRadio rb =(BoutonRadio) actionEvent.getSource();
		// if (rb.getValPion()==0){
		// 	if (rb.getText()=="rouge"){
		// 		partie.getATester().getP1().setFill(Color.RED);
		// 	}
		// 	if (rb.getText()=="bleu"){
		// 		partie.getATester().getP1().setFill(Color.BLUE);
		// 	}
		// 	if (rb.getText()=="vert"){
		// 		partie.getATester().getP1().setFill(Color.GREEN);
		// 	}
		// 	if (rb.getText()=="jaune"){
		// 		partie.getATester().getP1().setFill(Color.YELLOW);
		// 	}
		// }
		//
		// if (rb.getValPion()==1){
		// 	if (rb.getText()=="rouge"){
		// 		partie.getATester().getP2().setFill(Color.RED);
		// 	}
		// 	if (rb.getText()=="bleu"){
		// 		partie.getATester().getP2().setFill(Color.BLUE);
		// 	}
		// 	if (rb.getText()=="vert"){
		// 		partie.getATester().getP2().setFill(Color.GREEN);
		// 	}
		// 	if (rb.getText()=="jaune"){
		// 		partie.getATester().getP2().setFill(Color.YELLOW);
		// 	}
		// }
		//
		// if (rb.getValPion()==2){
		// 	if (rb.getText()=="rouge"){
		// 		partie.getATester().getP3().setFill(Color.RED);
		// 	}
		// 	if (rb.getText()=="bleu"){
		// 		partie.getATester().getP3().setFill(Color.BLUE);
		// 	}
		// 	if (rb.getText()=="vert"){
		// 		partie.getATester().getP3().setFill(Color.GREEN);
		// 	}
		// 	if (rb.getText()=="jaune"){
		// 		partie.getATester().getP3().setFill(Color.YELLOW);
		// 	}
		// }
		//
		// if (rb.getValPion()==3){
		// 	if (rb.getText()=="rouge"){
		// 		partie.getATester().getP4().setFill(Color.RED);
		// 	}
		// 	if (rb.getText()=="bleu"){
		// 		partie.getATester().getP4().setFill(Color.BLUE);
		// 	}
		// 	if (rb.getText()=="vert"){
		// 		partie.getATester().getP4().setFill(Color.GREEN);
		// 	}
		// 	if (rb.getText()=="jaune"){
		// 		partie.getATester().getP4().setFill(Color.YELLOW);
		// 	}
		// }
		// partie.majAffichage();
	}
}
