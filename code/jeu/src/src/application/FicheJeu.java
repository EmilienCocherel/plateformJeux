package application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class FicheJeu extends GridPane{
    private AppliJDBC AppliJDBC;
    private Label titre;
    private TextField idJeu;
    private TextField nomJeu;
    private TextField description;
    private TextField jarJeu;
    private CheckBox activeJeu;
    // private CheckBox payant;
    // private TextField prix;
    // private VueImageAvatar image;
    // private byte[] imageAvatar;
    private ComboBox<String> cb;

    private Button bouton;

    public void setNomBouton(String nomBouton) {
        this.bouton.setText(nomBouton);
    }

     public void setTitre(String titre) {
        this.titre.setText(titre);
    }

    public void setIdJeu(int numJeu){
        this.idJeu.setText(""+numJeu);
    }

    public String getTitre(){
        return this.titre.getText();
    }

    public void setJeu(JeuProfil j){
        this.nomJeu.setText(j.getNomJeu());
        this.description.setText(j.getDescription());
        this.jarJeu.setText(j.getJarJeu());

        switch(j.getIdType()){
            case 1: cb.setValue("Tour par Tour"); break;
            case 2: cb.setValue("Simultané"); break;
        }
    }

    public JeuProfil getJeu(){
        int id=-1;
        try {
            id = Integer.parseInt(this.idJeu.getText());
        }catch (Exception e){}
        String nomJeu=this.nomJeu.getText();
        String description=this.description.getText();
        String jar = this.jarJeu.getText();
        boolean isActif = this.activeJeu.isSelected();

        int typejeu;
        if (cb.getValue().equals("Tour par tour"))
            typejeu=1;
        else
            typejeu=2;

	    return new JeuProfil(id, nomJeu, description, jar, isActif, typejeu);
    }

    void viderFicheJeu(){
        this.idJeu.setText("");
        this.description.setText("");
        this.nomJeu.setText("");
        this.jarJeu.setText("");
        this.activeJeu.setSelected(false);
        this.cb.setValue("Tour par tour");
    }

    FicheJeu(AppliJDBC AppliJDBC) {
        super();
        this.AppliJDBC=AppliJDBC;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setHgap(5);
        this.setVgap(5);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTSEAGREEN, null, null)));

        this.titre=new Label("Fiche Jeu");
        this.titre.setFont(Font.font(24));
        this.idJeu = new TextField();
        this.nomJeu= new TextField();
        this.description = new TextField();
        this.jarJeu = new TextField();
        this.activeJeu = new CheckBox("Actif");
        this.cb=new ComboBox<String>(
                FXCollections.observableArrayList("Simultané","Tour par tour"));

        this.bouton = new Button("OK");
        this.bouton.setOnAction(new ControleurBouton(this.AppliJDBC));

        this.add(this.titre,1,0,2,1);
        this.add(new Label("Titre:"),1,1);
        this.add(this.nomJeu, 2,1);
        this.add(new Label("Numéro:"),1,2);
        this.add(this.idJeu,2,2);
        this.add(new Label("JarJeu:"),1,3);
        this.add(this.jarJeu,2,3);
        this.add(new Label("Decpription:"),1,4);
        this.add(this.description,2,4);
        this.add(new Label("Type:"),1,5);
        this.add(this.cb,2,5);
        this.add(this.activeJeu,2,6);
        this.add(bouton,1,9,2,1);

    }
    public void activerIdJeu(boolean actif){
        for (Node n: this.getChildren()){
            n.setDisable(actif);
        }
        this.idJeu.setDisable(!actif);
        this.bouton.setDisable(false);
    }

    public int getIdJeu(){
        return Integer.parseInt(this.idJeu.getText());
    }

    public void activerNomJeu(boolean actif){
        for (Node n: this.getChildren()){
            n.setDisable(actif);
        }
        this.nomJeu.setDisable(!actif);
        this.bouton.setDisable(false);
    }

    public String getNomJeu(){
        return this.nomJeu.getText();
    }

}
