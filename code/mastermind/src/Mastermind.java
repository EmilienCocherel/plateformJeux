public class Mastermind {
    private Joueur j1,j2;
    private int id;
    private Combinaison combi;

    public Mastermind(Joueur j1, Joueur j2, Combinaison combi){
        this.j1 = j1;
        this.j2 = j2;
        this.combi = combi;
    }

    public boolean estFinie(){ // À IMPLÉMENTER
        return true;
    }

    public void finPartie(){ // À IMPLÉMENTER
    }

    public void verifCombi(){ // À IMPLÉMENTER
    }

    public void initManche(){ // À IMPLÉMENTER

    }


//    Getter et Setter

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Combinaison getCombi() {
        return combi;
    }

    public void setCombi(Combinaison combi) {
        this.combi = combi;
    }

    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }
}
