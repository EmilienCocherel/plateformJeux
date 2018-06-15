package mastermind;

import javafx.scene.paint.Paint;

public class Combinaison {

    private Pion p1, p2, p3, p4;

    public Combinaison(Pion p1, Pion p2, Pion p3, Pion p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

//    Getter et Setter

    public Pion getP1() {
      return this.p1;
    }

    public String getCouleurP1() {
      return this.p1.getCouleur();
    }

    public Paint getPeintureP1() {
      return this.p1.getPeinture();
    }

    public void setP1(int val) {
      this.p1.setVal(val);
    }

    public Pion getP2() {
      return this.p2;
    }

    public String getCouleurP2() {
      return this.p2.getCouleur();
    }

    public Paint getPeintureP2() {
      return this.p2.getPeinture();
    }

    public void setP2(int val) {
      this.p2.setVal(val);
    }

    public Pion getP3() {
      return this.p3;
    }

    public String getCouleurP3() {
      return this.p3.getCouleur();
    }

    public Paint getPeintureP3() {
      return this.p3.getPeinture();
    }

    public void setP3(int val) {
      this.p3.setVal(val);
    }

    public Pion getP4() {
      return this.p4;
    }

    public String getCouleurP4() {
      return this.p4.getCouleur();
    }

    public Paint getPeintureP4() {
      return this.p4.getPeinture();
    }

    public void setP4(int val) {
        this.p4.setVal(val);
    }

    @Override
    public boolean equals(Object o){
        Combinaison c2=(Combinaison)o;
        return this.p1.equals(c2.p1) && this.p2.equals(c2.p2) && this.p3.equals(c2.p3) && this.p4.equals(c2.p4);
    }
}
