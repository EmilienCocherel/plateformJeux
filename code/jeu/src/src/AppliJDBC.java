import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppliJDBC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Login Login;
    private FicheJoueur ficheJoueur;
    private JoueurBD joueurBD;
    private ConnexionMySQL Connexion;
    private Scene scene;
    private ApplicationAJEL ApplicationAJEL;
    private Label message;
    private FicheResultat ficheResultat;

    public void init(){
        try {
            this.Connexion = new ConnexionMySQL();
        }catch (ClassNotFoundException ex){
            System.out.println("Driver MySQL non trouvé!!!");
            System.exit(1);
        }
        this.Login=new Login(this);
        this.ficheJoueur=new FicheJoueur(this);
        this.ficheResultat=new FicheResultat(this);
        this.joueurBD=new JoueurBD(this.Connexion);
        this.message=new Label("Vous n'êtes pas connecté");
        message.setFont(Font.font(24));
        message.setAlignment(Pos.CENTER);
    }
    @Override
    public void start(Stage primaryStage) {
        VBox fp=new VBox(5);
        fp.setAlignment(Pos.TOP_CENTER);
        ApplicationAJEL=new ApplicationAJEL(this);
        fp.getChildren().addAll(this.ApplicationAJEL,message);
        this.scene= new Scene(fp,500,500);
        primaryStage.setScene(this.scene);
        primaryStage.setTitle("Application AJEL");
        primaryStage.show();
    }

    public Login getLogin() {
        return Login;
    }

    public void connexionReussie(){
        this.message.setText("Vous êtes connecté");
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
        this.ApplicationAJEL.connecter();
    }

    public void deconnexionReussie(){
        this.message.setText("Vous êtes déconnecté");
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);
        this.ApplicationAJEL.deconnecter();
    }
    public void showFenetreConnexion(){
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.Login);
    }
    public void showFicheJoueur(){
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.ficheJoueur);
    }
    public void showFicheResultat(String resultat){
        this.ficheResultat.setTexte(resultat);
        VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.ficheResultat);
    }
    public void setMessage(String message){
        this.message.setText(message);
         VBox fp=((VBox)scene.getRoot());
        fp.getChildren().remove(1);
        fp.getChildren().addAll(this.message);

    }

    public ConnexionMySQL getConnexion() {
        return Connexion;
    }

    public JoueurBD getJoueurBD() {
        return joueurBD;
    }

    public FicheJoueur getFicheJoueur() {
        return ficheJoueur;
    }
}
