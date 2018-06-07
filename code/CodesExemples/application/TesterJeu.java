package application;
import javafx.animation.*;
import javafx.util.*;
import javafx.event.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class TesterJeu extends Application {
    private ConnexionMySQL laConnexion=null;
    Stage primaryStage=null;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test du TesterJeu");
	Scene s=new Scene(new Login(this),500,500);
        primaryStage.setScene(s);
	primaryStage.show();	
	this.primaryStage=primaryStage;
    }
    public void setConnexion(ConnexionMySQL c){
	this.laConnexion=c;
    }
    public void changeScene(){
	Scene s2=new Scene(new ChoixJeu(laConnexion),500,500);
	primaryStage.setScene(s2);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
	
}
