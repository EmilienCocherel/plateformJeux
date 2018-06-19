package mastermind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import application.*;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class Mastermind extends application.Jeu{
    private JoueurMastermind joueur;
    private int id;
    private ArrayList<Combinaison> combis;
    private Combinaison aTester;
    private Manche manche;
    private Stage stage;
    private Label historique;
    private Scene scene;
    private HBox interfaceChoix;
    private VBox historiqueCombinaison;
    private application.Partie partie;
    private int idJoueurJ1;
    private int idJoueurJ2;
    private application.PartieBD partieBD;
	private Button tester;

    public Mastermind(){}

    @Override
    public void jouerCoup(int idPartie, int joueur, Object partage){
    }

    @Override
    public void creerPartie(int idJeu, int idJoueur1, int idJoueur2, Object partage){
    }

    @Override
    public void setPartie(application.Partie partie, int idJoueur) {
        this.partie = partie;
        application.Joueur joueur1 = partie.getJoueur1();
        application.Joueur joueur2 = partie.getJoueur2();
        this.joueur=new JoueurMastermind(idJoueur);
        this.idJoueurJ1=joueur1.getIdentifiant();
        this.idJoueurJ2=joueur2.getIdentifiant();
        this.combis=new ArrayList<>();
        this.combis.add(new Combinaison(new Pion(Color.RED),new Pion(Color.RED),new Pion(Color.RED),new Pion(Color.RED)));
        this.combis.add(new Combinaison(new Pion(Color.GREEN),new Pion(Color.RED),new Pion(Color.RED),new Pion(Color.BLUE)));
        this.combis.add(new Combinaison(new Pion(Color.BLUE),new Pion(Color.YELLOW),new Pion(Color.RED),new Pion(Color.RED)));
        this.aTester = new Combinaison();
        this.joueur.nouvelleManche(new Manche(this.combis.get(0),this, this.joueur,0));
        this.manche=this.joueur.getMancheCourante();
        this.manche.initCombiParTour();
        this.manche.initResParTour();
		this.initHistoriqueCombinaison();
        this.getEtat(idJoueur);
		this.setEtat();
    }

    @Override
    public void setPartieBD(application.PartieBD partieBD) {
        this.partieBD = partieBD;
    }

    public boolean getEtat(int actuel) {
		int id = this.partie.getId();
		try {
			String etat = this.partieBD.getEtat(id);
			JSONParser parser = new JSONParser();
			try {
				JSONObject obj = (JSONObject) parser.parse(etat);
				this.fromJson(obj);
				System.out.println(this.joueur.getIdentifiant()+" get màj OK");
				return true;
			} catch (ParseException ex) {
				System.out.println(ex.getCause());
				System.out.println(etat);
				return false;
			}
        } catch (SQLException ex) {
            System.out.println(this.joueur.getIdentifiant()+" get màj FAIL sql exception");
            return false;
        }
    }

    public void setEtat() {
        // TODO: envoyer l'état au format JSON
        JSONObject json = this.toJson();
        System.out.println(json);
        try {
            this.partieBD.majEtat(this.partie.getId(), json.toString());
            System.out.println(this.joueur.getIdentifiant()+" insert màj OK");
        } catch (SQLException ex) {
            System.out.println(this.joueur.getIdentifiant()+" insert màj FAIL");
        }
    }

    public void fromJson(JSONObject json) {
        Long id = (Long) json.get("id"), tour = (Long) json.get("tour");
		JSONArray combinaisons = (JSONArray) json.get("combinaisons");
        if (this.joueur.getIdentifiant()==this.idJoueurJ1){
            this.joueur.fromJson((JSONObject) json.get("joueur1"));
        }
        else{
            this.joueur.fromJson((JSONObject) json.get("joueur2"));
        }
        if (id != null){
            this.id = id.intValue();
        }
        if (tour != null)
            this.manche.setNbCoup(tour.intValue());

		this.manche.fromJson((JSONObject) json.get("manche"));

		for (int i=0; i < combinaisons.size(); i++) {
			this.combis.get(i).fromJson((JSONObject) combinaisons.get(i));
		}
    }

    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
		JSONArray combinaisons = new JSONArray();
		for (Combinaison combi : this.combis)
			combinaisons.add(combi.toJson());
		obj.put("combinaisons", combinaisons);

		obj.put("manche", this.manche.toJson());

        obj.put("id", this.id);
        if(this.joueur.getIdentifiant()==this.idJoueurJ1){
            obj.put("joueur1", this.joueur.toJson());
            obj.put("tourJ1", this.manche.getNbCoup());
        }
        else{
            obj.put("joueur2", this.joueur.toJson());
            obj.put("tourJ2", this.manche.getNbCoup());
        }
        return obj;
    }

    //public boolean estFinie(){ // À IMPLÉMENTER
    //    if (this.manche.estFini() && this.manche.getNum() == 3){
    //        return true;
    //    }
    //   else{ // Mème si la personne à fait ses 12 coups mais qu'aucun n'est gagnant
    //       return false;
    //   }
    //}

    public void finPartie(){}


      /**
      * passe prochaine manche
      */
    public void prochaineManche(Manche precedent,boolean gagne){
        try{
            this.joueur.nouvelleManche(new Manche(this.combis.get(precedent.getNum()+1),this, precedent.getJoueurMastermind(),precedent.getNum()+1));
            this.manche=joueur.getMancheCourante();
            this.manche.initCombiParTour();
            this.manche.initResParTour();
            Alert info = new Alert(CONFIRMATION);
            if (gagne){
                info.setHeaderText("Combinaison trouvé");
                info.setContentText("Vous avez remporté la manche!\n voulez-vous passer à la suivante?");
            }
            else{
                info.setHeaderText("Manche termine");
                String solution = precedent.getCombi().toString();
                info.setContentText("La manche est terminé vous avez perdu \n La solution était: "+solution+"\n passer à la prochaine manche ?");
            }
            Optional<ButtonType> result = info.showAndWait();
                this.aTester = new Combinaison();
                this.initInterfaceChoix();
                this.initHistoriqueCombinaison();
                this.laScene();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                stage.setScene(this.scene);
            }
            else{
                this.stage.close();
            }
        }
        catch(IndexOutOfBoundsException e){
            if (gagne){
                Alert info = new Alert(CONFIRMATION);
                info.setHeaderText("La Partie est terminé");
                info.setContentText("Vous avez remporté la dernière manche!");
                info.showAndWait();
                stage.close();
            }
            else{
                Alert info = new Alert(CONFIRMATION);
                info.setHeaderText("La Partie est terminé");
                String solution = precedent.getCombi().toString();
                info.setContentText("Vous avez perdu la dernière Manche \n La solution était: "+solution);
                info.showAndWait();
                stage.close();
            }
			PartieFinie p = new PartieFinie(this);
			this.stage.setScene(p.getScene());
        }
    }

    //    Getter et Setter

    public Label getHistorique(){
      return this.historique;
    }

    public Combinaison getATester(){
      return this.aTester;
    }

    public JoueurMastermind getJ1() {
        return joueur;
    }

    public int getId() {
        return id;
    }

	public int getIdJoueur1() {
		return this.idJoueurJ1;
	}

    public void setId(int id) {
        this.id = id;
    }

    public void setJ1(Joueur joueur) {
      this.joueur = new JoueurMastermind(joueur.getIdentifiant());
    }


    /**
    * @return un string correspondant au numéro de pion
    */
    public String getStringPion(int nbPion){
        switch (nbPion){
            case 0:
                return "p1";
            case 1:
                return "p2";
            case 2:
                return "p3";
            case 3:
                return "p4";
        }
        return null;
    }


    /**
    * @return Pion à l'emplacement nbPion de la combinaison à tester
    */
    private Circle getPion(int nbPion){
        switch (nbPion){
            case 0:
                return this.aTester.getP1();
            case 1:
                return this.aTester.getP2();
            case 2:
                return this.aTester.getP3();
            case 3:
                return this.aTester.getP4();
        }
        return null;
    }

    /**
    * @return une VBox contenant les radio boutons permettant de changer la couleurs des pions de la combinaison à tester
    */
    private VBox choixCouleurDuPion(int val){
        VBox res=new VBox(5);
        res.getChildren().add(this.getPion(val));
        res.setPadding(new Insets(10,10,10,10));
        Label nom = new Label(this.getStringPion(val));
        res.getChildren().add(nom);
        ToggleGroup group = new ToggleGroup();
        BoutonRadio rfacile = new BoutonRadio("rouge",val);
        rfacile.setToggleGroup(group);
        res.getChildren().add(rfacile);
        BoutonRadio rmoyen = new BoutonRadio("bleu",val);
        rmoyen.setToggleGroup(group);
        res.getChildren().add(rmoyen);
        BoutonRadio rdifficile = new BoutonRadio("vert",val);
        rdifficile.setToggleGroup(group);
        res.getChildren().add(rdifficile);
        BoutonRadio rexpert = new BoutonRadio("jaune",val);
        rexpert.setToggleGroup(group);
        res.getChildren().add(rexpert);
        ChoixCouleur actionNiveau = new ChoixCouleur(this,((JoueurMastermind)this.joueur).getMancheCourante());
        rfacile.setOnAction(actionNiveau);
        rmoyen.setOnAction(actionNiveau);
        rdifficile.setOnAction(actionNiveau);
        rexpert.setOnAction(actionNiveau);
        return res;
    }

    /**
     * initialise l'interface de choix de couleur des pions de la combinaison à tester
     */
    private void initInterfaceChoix(){
        HBox res=new HBox(5);
        res.setAlignment(Pos.CENTER);
        this.tester = new Button("Tester");
        ActionTester actionTester = new ActionTester(this,this.joueur.getMancheCourante());
        this.tester.setOnAction(actionTester);
		this.tester.setDisable(true);
        res.getChildren().add(this.tester);
        res.setBackground(new Background(new BackgroundFill(Color.LAVENDER,null,null)));
        res.getChildren().add(this.choixCouleurDuPion(0));
        res.getChildren().add(this.choixCouleurDuPion(1));
        res.getChildren().add(this.choixCouleurDuPion(2));
        res.getChildren().add(this.choixCouleurDuPion(3));
        this.historique = new Label();
        res.getChildren().add(historique);
        this.interfaceChoix=res;
    }

    /**
     * initialise l'interface des combinaisons déjà tester par l'utilisateur
     */
    private void initHistoriqueCombinaison(){
        VBox res=new VBox(5);
        res.setAlignment(Pos.CENTER);
        for(int i =0; i<this.manche.getCombiParTour().size();i++){
            Combinaison combi = this.manche.getCombiParTour().get(i);
            HBox box = new HBox();
            box.getChildren().add(combi.getP1());
            box.getChildren().add(combi.getP2());
            box.getChildren().add(combi.getP3());
            box.getChildren().add(combi.getP4());
            Resultat resultat = this.manche.getResParTour().get(i);
            for (Circle cercle :resultat.getPionsRes()){
                box.getChildren().add(cercle);
            }
            res.getChildren().add(box);
        }
        this.historiqueCombinaison=res;
    }

      /**
      * @return le panel contenant le titre du jeu
      */
      private FlowPane titre(){
          FlowPane res = new FlowPane();
          res.setPadding(new Insets(10,10,10,10));
          Label nom = new Label("Mastermind");
          res.getChildren().add(nom);
          res.setAlignment(Pos.CENTER);
          return res;
      }

      /**
       * initialise le graphe de scène de la vue à partir de methodes précédantes
       */
      private void laScene(){
          BorderPane cont = new BorderPane();
          cont.setTop(this.titre());
          cont.setCenter(this.historiqueCombinaison);
          cont.setBottom(this.interfaceChoix);
          cont.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
          this.scene = new Scene(cont,500,600);
      }


      /**
       * raffraichit l'affichage en fonction du modèle
       */
      public void majAffichage(){
        this.aTester.getP1().setFill(this.aTester.getCouleurP1());
        this.aTester.getP2().setFill(this.aTester.getCouleurP2());
        this.aTester.getP3().setFill(this.aTester.getCouleurP3());
        this.aTester.getP4().setFill(this.aTester.getCouleurP4());
		this.tester.setDisable(this.aTester.getCouleurP1().equals(Color.WHITE) ||
				this.aTester.getCouleurP2().equals(Color.WHITE) ||
				this.aTester.getCouleurP3().equals(Color.WHITE) ||
				this.aTester.getCouleurP4().equals(Color.WHITE));
	}

	/**
	* lance le jeu
	*/
	@Override
	public void run(){
		this.stage = new Stage();
		stage.setTitle("Mastermind");
		this.initInterfaceChoix();
		this.laScene();
		stage.setScene(this.scene);
		stage.show();
		this.majAffichage();
	}
}
