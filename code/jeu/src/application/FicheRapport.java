package application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class FicheRapport extends GridPane{
    private AppliJDBC AppliJDBC;
    private Label titre;
    private TextField idRapport;
    private TextField dateRapport;
    private TextField titreRapport;
    private TextField sujetRapport;
    private TextField contenuRapport;
    private TextField idJo;
    private ComboBox<String> cb;

    private Button bouton;

    public void setNomBouton(String nomBouton) {
        this.bouton.setText(nomBouton);
    }

     public void setTitre(String titre) {
        this.titre.setText(titre);
    }

    public void setIdRapport(int numRapport){
        this.idRapport.setText(""+numRapport);
    }

    public void setIdJo(int numJo){
        this.idJo.setText(""+idJo);
    }

    public String getTitre(){
        return this.titre.getText();
    }

    public void setRapport(Rapport r){
        this.dateRapport.setText(r.getDateRapport());
        this.titreRapport.setText(r.getTitreRapport());
        this.contenuRapport.setText(r.getContenuRapport());

        switch(r.getSujetRapport()){
            case 1: cb.setValue("Bug"); break;
            case 2: cb.setValue("Information"); break;
            case 3: cb.setValue("Message"); break;
            case 4: cb.setValue("Bannissement"); break;
            case 5: cb.setValue("Debannissement"); break;
            case 6: cb.setValue("Autre"); break;
        }

    }

    public Rapport getRapport(){
        int id = -1;
        int idJo = -1;
        try {
            id = Integer.parseInt(this.idRapport.getText());
        }catch (Exception e){}
        try {
            id = Integer.parseInt(this.idJo.getText());
        }catch (Exception e){}

        String dateRapport = this.dateRapport.getText();
        String titreRapport=this.titreRapport.getText();
        String contenuRapport=this.contenuRapport.getText();

        int sujetRapport;
        if (cb.getValue().equals("Bug"))
            sujetRapport = 1;
        else if (cb.getValue().equals("Information"))
            sujetRapport = 2;
        else if (cb.getValue().equals("Message"))
            sujetRapport = 3;
        else if (cb.getValue().equals("Bannissement"))
            sujetRapport = 4;
        else if (cb.getValue().equals("Debannissement"))
            sujetRapport = 5;
        else
            sujetRapport = 6;
	    return new Rapport(id, dateRapport, titreRapport, sujetRapport, contenuRapport, idJo);
    }

    void viderFicheRapport(){
        this.idRapport.setText("");
        this.dateRapport.setText("");
        this.titreRapport.setText("");
        this.contenuRapport.setText("");
        this.idJo.setText("");
        this.cb.setValue("Bug");
    }

    FicheRapport(AppliJDBC AppliJDBC) {
        super();
        this.AppliJDBC=AppliJDBC;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setHgap(5);
        this.setVgap(5);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTSEAGREEN, null, null)));

        this.titre=new Label("Fiche Rapport");
        this.titre.setFont(Font.font(24));
        this.idRapport = new TextField();
        this.titreRapport= new TextField();
        this.contenuRapport = new TextField();
        this.idJo = new TextField();
        this.dateRapport = new TextField();
        this.cb=new ComboBox<String>(
                FXCollections.observableArrayList("Bug","Information","Message", "Bannissement", "Debannissement", "Autre"));

        this.bouton = new Button("OK");
        this.bouton.setOnAction(new ControleurBouton(this.AppliJDBC));

        this.add(this.titre,1,0,2,1);
        this.add(new Label("Titre:"),1,1);
        this.add(this.titreRapport, 2,1);
        this.add(new Label("Numéro:"),1,2);
        this.add(this.idRapport,2,2);
        this.add(new Label("Corps:"),1,3);
        this.add(this.contenuRapport,1,4);
        this.add(new Label("Date de rédaction:"),1,5);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String datenow = dateFormat.format(today);
        this.dateRapport.setText(datenow);
        this.add(this.dateRapport,2,5);


        this.add(new Label("Sujet:"),1,6);
        this.add(this.cb,2,6);
        this.add(bouton,1,9,2,1);

    }
    public void activerIdRapport(boolean actif){
        for (Node n: this.getChildren()){
            n.setDisable(actif);
        }
        this.idRapport.setDisable(!actif);
        this.bouton.setDisable(false);
    }

    public void activerDateRapport(boolean actif){
        for (Node n: this.getChildren()){
            n.setDisable(actif);
        }
        this.dateRapport.setDisable(!actif);
        this.bouton.setDisable(false);
    }

    public int getIdRapport(){
        return Integer.parseInt(this.idRapport.getText());
    }

    public void activerSujetRapport(boolean actif){
        for (Node n: this.getChildren()){
            n.setDisable(actif);
        }
        this.cb.setDisable(!actif);
        this.bouton.setDisable(false);
    }

    public int getSujetRapport(){
      int sujetRapport;
      if (cb.getValue().equals("Bug"))
          sujetRapport = 1;
      else if (cb.getValue().equals("Information"))
          sujetRapport = 2;
      else if (cb.getValue().equals("Message"))
          sujetRapport = 3;
      else if (cb.getValue().equals("Bannissement"))
          sujetRapport = 4;
      else if (cb.getValue().equals("Debannissement"))
          sujetRapport = 5;
      else
          sujetRapport = 6;
      return sujetRapport;
    }



    // public void activerNomJeu(boolean actif){
    //     for (Node n: this.getChildren()){
    //         n.setDisable(actif);
    //     }
    //     this.nomJeu.setDisable(!actif);
    //     this.bouton.setDisable(false);
    // }
    //
    // public String getNomJeu(){
    //     return this.nomJeu.getText();
    // }

}
