package application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

public class Login extends GridPane {
    private TextField login=null;
    private TextField serveur=null;
    private TextField bd=null;
    private PasswordField mdp=null;
    private Button ok =null;
    private TesterJeu p;
    
    Login( TesterJeu p){
	super();
	this.p=p;
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	Label lLogin = new Label("Login:");
	Label lMdp = new Label("Mot de passe:");
	Label lServeur = new Label("Serveur:");
	Label lBD = new Label("Base de données:");
	
	Button ok = new Button("OK");
	ok.setOnAction(new ActionLogin(this));
	login=new TextField();
	serveur=new TextField();
	bd=new TextField();
	mdp=new PasswordField();

	this.add(lLogin,0,0);
	this.add(lMdp,0,1);
	this.add(lServeur,0,2);
	this.add(lBD,0,3);

	this.add(login,1,0);
	this.add(mdp,1,1);
	this.add(serveur,1,2);
	this.add(bd,1,3);
	this.add(ok,0,4);
    }
    void setConnexion(ConnexionMySQL c){
	p.setConnexion(c);
    }
    void changeScene(){
	p.changeScene();
    }
    String getLogin(){
	return login.getText();
    }
    String getMdp(){
	return mdp.getText();
    }
    String getBD(){
	return bd.getText();
    }
    String getServeur(){
	return serveur.getText();
    }
}
