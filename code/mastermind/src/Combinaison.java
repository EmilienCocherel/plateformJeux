public class Combinaison {

    private int p1, p2, p3, p4;

    public Combinaison(int p1, int p2, int p3, int p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

//    public void Combinaison(){ // À IMPLÉMENTER ???
//
//    }

//    Getter et Setter

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public int getP4() {
        return p4;
    }

    public void setP4(int p4) {
        this.p4 = p4;
    }

    @Override
    public boolean equals(Object o){
        Combinaison c2=(Combinaison)o;
        return this.p1==c2.p1 && this.p2==c2.p2 && this.p3==c2.p3 && this.p4==c2.p4;
    }
}
