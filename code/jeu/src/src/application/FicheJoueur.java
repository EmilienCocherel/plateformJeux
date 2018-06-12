package application;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class FicheJoueur extends GridPane{
    private AppliJDBC AppliJDBC;
    private Label titre;
    private TextField numJoueur;
    private TextField pseudo;
    private PasswordField passwd;
    private CheckBox abonne;
    private VueImageAvatar avatar;
    private TextField emailJo;
    private CheckBox activeJo;
    private CheckBox souvenir;

    private ComboBox<String> cb;
    private ToggleGroup gr;
    private RadioButton homme;
    private RadioButton femme;

    private Button bouton;

    private byte[] imageAvatar;


    public void setNomBouton(String nomBouton) {
        this.bouton.setText(nomBouton);
    }

     public void setTitre(String titre) {
        this.titre.setText(titre);
    }

    public void setNumJoueur(int numJoueur){
        this.numJoueur.setText(""+numJoueur);
    }

    public String getTitre(){
        return this.titre.getText();
    }

    public void setJoueur(Joueur j){
        this.pseudo.setText(j.getPseudo());
        this.passwd.setText(j.getMotdepasse());
        this.emailJo.setText(j.getEmailJo());
        this.abonne.setSelected(j.isAbonne());
        this.activeJo.setSelected(j.isActive());
        this.souvenir.setSelected(j.isRemembered());

        this.avatar.setAvatar(j.getAvatar());
        switch(j.getNiveau()){
            case 1: cb.setValue("Débutant"); break;
            case 2: cb.setValue("Medium"); break;
            case 3: cb.setValue("Expert"); break;
        }
        if (j.getSexe()=='M')
            gr.selectToggle(homme);
        else
            gr.selectToggle(femme);
    }

    public Joueur getJoueur(){
        int id=-1;
        try {
            id = Integer.parseInt(this.numJoueur.getText());
        }catch (Exception e){}
        String pseudo=this.pseudo.getText();
        String motdepasse=this.passwd.getText();
        String email = this.emailJo.getText();

        int niveau;
        if (cb.getValue().equals("Débutant"))
            niveau=1;
        else if (cb.getValue().equals("Medium"))
            niveau=2;
        else niveau=3;
        char sexe;
        if (gr.getSelectedToggle()==homme)
            sexe='M';
        else sexe='F';
        boolean abonne = this.abonne.isSelected();
        boolean actif = this.activeJo.isSelected();
        boolean resterCo = this.souvenir.isSelected();
	    String nomFicImage="toto";
	    return new Joueur(id,pseudo,motdepasse,sexe, abonne, niveau, this.avatar.getAvatar(), email, actif, resterCo);
    }

    void viderFiche(){
        this.numJoueur.setText("");
        this.passwd.setText("");
        this.pseudo.setText("");
        this.emailJo.setText("");
        this.abonne.setSelected(false);
        // this.activeJo.setSelected(false);
        this.gr.selectToggle(this.femme);
        this.cb.setValue("Débutant");
        this.avatar.resetAvatar();
    }



    FicheJoueur(AppliJDBC AppliJDBC) {
        super();
        this.AppliJDBC=AppliJDBC;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setHgap(5);
        this.setVgap(5);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTSEAGREEN, null, null)));

        this.titre=new Label("Fiche Joueur");
        this.titre.setFont(Font.font(24));
        this.numJoueur = new TextField();
        this.emailJo= new TextField();
        this.pseudo = new TextField();
        this.passwd = new PasswordField();
        this.abonne = new CheckBox("Abonné");
        this.activeJo = new CheckBox("Actif");
        this.souvenir = new CheckBox("Souviens");

        this.avatar = new VueImageAvatar("./img/avatar.png");
        this.avatar.setFitWidth(100);
        this.avatar.setPreserveRatio(true);
        this.avatar.setSmooth(true);
        this.cb=new ComboBox<String>(
                FXCollections.observableArrayList("Expert","Medium","Débutant"));

        this.homme = new RadioButton("Homme");
        this.femme = new RadioButton("Femme");
        this.gr = new ToggleGroup();
        this.homme.setToggleGroup(gr);
        this.femme.setToggleGroup(gr);
        TitledPane tp = new TitledPane();
        tp.setText("Sexe");
        tp.setCollapsible(false);

        VBox vp = new VBox(5);
        vp.getChildren().addAll(this.homme,this.femme);
        tp.setContent(vp);

        this.bouton = new Button("OK");
        this.bouton.setOnAction(new ControleurBouton(this.AppliJDBC));

        this.add(this.titre,1,0,2,1);
        this.add(new Label("Email:"),1,1);
        this.add(this.emailJo, 2,1,1,1);
        this.add(new Label("Numéro:"),1,2);
        this.add(this.numJoueur,2,2);
        this.add(new Label("Pseudo:"),1,3);
        this.add(this.pseudo,2,3);
        this.add(new Label("Mot de passe:"),1,4);
        this.add(this.passwd,2,4);
        this.add(new Label("Niveau:"),1,5);
        this.add(this.cb,2,5);
        this.add(this.abonne,1,6);
        this.add(this.activeJo,2,6);
        this.add(this.souvenir,3,6);
        this.add(tp,1,7,2,1);
        this.add(bouton,1,8,2,1);
        this.add(this.avatar,3,0);

    }
    public void activerNumJoueur(boolean actif){
        for (Node n: this.getChildren()){
            n.setDisable(actif);
        }
        this.numJoueur.setDisable(!actif);
        this.bouton.setDisable(false);
    }
    public int getNumJoueur(){
        return Integer.parseInt(this.numJoueur.getText());
    }

}
