public class Pion{
  private int val;

  public Pion(int val){
    this.val=val;
  }

  public int getVal(){
    return this.val;
  }

  public void setVal(int val){
    this.val=val;
  }

  public String getCouleur(){
    if(this.val == 0){
      return "";
    }
    if(this.val == 1){
      return "rouge";
    }
    if(this.val == 2){
      return "bleu";
    }
    if(this.val == 3){
      return "vert";
    }
    if(this.val == 4){
      return "jaune";
    }
    return null;
  }

  @Override
  public boolean equals(Object o){
      Pion p2=(Pion)o;
      return this.val==p2.val;
  }
}
