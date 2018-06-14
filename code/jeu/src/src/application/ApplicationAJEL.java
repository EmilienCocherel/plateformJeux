package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;

public class ApplicationAJEL extends MenuBar{
    private String [][] menuPrinc={
            {"Connexion BD","Connexion","Déconnexion","Quitter"},

            {"Joueur","Afficher le plus grand numéro de joueur", "Créer un joueur", "Supprimer un joueur",
                    "Mettre à jour un joueur", "Afficher un joueur", "Afficher un joueur par pseudo",
                    "Afficher tous les joueurs", "Afficher msg par joueur"},

            {"Jeu", "Afficher le plus grand nombre de jeu", "Afficher la liste des jeux",
                    "Afficher un jeu par son numéro", "Afficher un jeu par son nom", "Ajouter un jeu",
                    "Mettre à jour un jeu","Jouer"},

            {"Rapport", "Lire un rapport", "Rédiger un rapport", "Afficher le plus grand nombre de rapport",
                        "Afficher un rapport par son numéro", "Liste des rapports"},

            {"Statistiques", "Lire une statistique"},

            {"Aide", "Accéder aux aides"}};
    private ArrayList<MenuItem> lesItems;
    private AppliJDBC AppliJDBC;
    private ControleurMenu controleurMenu;

    ApplicationAJEL(AppliJDBC AppliJDBC){
        super();
        this.AppliJDBC=AppliJDBC;
        this.lesItems=new ArrayList<MenuItem>();
        this.controleurMenu=new ControleurMenu(AppliJDBC);
        for (String[] listeMenu:this.menuPrinc){
            Menu m = new Menu(listeMenu[0]);
            m.setDisable(true);
            for (int i=1;i<listeMenu.length;i++){
                MenuItem mi=new MenuItem(listeMenu[i]);
                mi.setId(""+i);
                mi.setOnAction(controleurMenu);
                lesItems.add(mi);
                m.getItems().add(mi);
            }
            this.getMenus().add(m);
        }
        this.getMenus().get(0).setDisable(false);
        this.lesItems.get(1).setDisable(true);
    }

    public void connecter(){
        for (Menu m:this.getMenus()){
            m.setDisable(false);
        }
        lesItems.get(0).setDisable(true);
        lesItems.get(1).setDisable(false);

    }

    public void deconnecter(){
        for (Menu m:this.getMenus()){
            m.setDisable(true);
        }
        this.getMenus().get(0).setDisable(false);
        lesItems.get(0).setDisable(false);
        lesItems.get(1).setDisable(true);

    }
}
