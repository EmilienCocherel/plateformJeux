package application;
import javafx.scene.control.ButtonBase;

public class ListeJeux extends ButtonBase{
  private String nom, typeString, comment;
  private int typeInt;
  public ListeJeux(String nom, int typeInt, String comment){
    super();
    this.nom  = nom;
    this.typeInt = typeInt;
    this.comment = comment;
  }

  public ListeJeux(String nom, String typeString, String comment){
    super();
    this.nom = nom;
    this.typeString = typeString;
    this.comment = comment;
  }

  @Override
  public void fire(){
    System.out.println("COUCOU");
  }

  public String getNom(){
    return this.nom;
  }

  public String getTypeString(){
    return this.typeString;
  }

  public String getComment(){
    return this.comment;
  }
  public int getTypeInt(){
    return this.typeInt;
  }
}
