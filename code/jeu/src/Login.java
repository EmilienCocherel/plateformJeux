import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.Connection;

public class Login extends GridPane {
    private PasswordField motDePasse;
    private TextField login, nomServeur, nomBD;

    private class EcouteurLogin implements ChangeListener<Boolean>{

        @Override
        public void changed(ObservableValue<? extends Boolean> observableValue, Boolean b, Boolean b1) {
            if (! b1 && nomBD.getText().equals("") && ! (login.getText().equals(""))){
                nomBD.setText("db"+login.getText());
            }
        }
    }

    public String getMotDePasse() {
        return this.motDePasse.getText();
    }

    public String getLogin() {
        return this.login.getText();
    }

    public String getNomServeur() {
        return this.nomServeur.getText();
    }

    public String getNomBD() {
        return this.nomBD.getText();
    }

}
