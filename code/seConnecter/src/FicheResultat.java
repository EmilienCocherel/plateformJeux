import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FicheResultat extends VBox{
    private Label titre;
    private Text texte;
    private TestJDBC testJDBC;
    public FicheResultat(TestJDBC testJDBC) {
        super(10);
        this.setAlignment(Pos.CENTER);
        this.titre=new Label("Résultat");
        this.titre.setFont(Font.font(24));
        this.texte=new Text();
        this.texte.setFont(Font.font(14));
        this.texte.setDisable(true);
        this.testJDBC=testJDBC;
        this.getChildren().addAll(this.titre,this.texte);
    }

    public void setTitre(String titre) {
        this.titre.setText(titre);
    }

    public void setTexte(String texte) {
        this.texte.setText(texte);
    }
}
