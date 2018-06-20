package application;

public class ListeJeux {
  private String nom, typeString, comment;
  private int typeInt;
  public ListeJeux(String nom, int typeInt, String comment){
    this.nom  = nom;
    this.typeInt = typeInt;
    this.comment = comment;
  }

  public ListeJeux(String nom, String typeString, String comment){
    this.nom = nom;
    this.typeString = typeString;
    this.comment = comment;
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
