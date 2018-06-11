import java.util.ArrayList;

public class Mastermind {
    private Joueur j1,j2;
    private int id;
    private ArrayList<Combinaison> combis;

    public Mastermind(Joueur j1, Joueur j2,int id){
        this.id=id;
        this.j1 = j1;
        this.j2 = j2;
        this.combis=new ArrayList<>();
    }

    public boolean estFinie(){ // À IMPLÉMENTER
        return true;
    }

    public void finPartie(){ // À IMPLÉMENTER
    }

    public void verifCombi(Combinaison test){
    }

    public void initManche(){ // À IMPLÉMENTER

    }

    public void prochaineManche(Manche precedent){
        precedent.getJoueur().setScore(precedent.getJoueur().getScore()+precedent.getNbCoup());
        precedent.getJoueur().nouvelleManche(new Manche(this.combis.get(precedent.getNum()+1),this, precedent.getJoueur(),precedent.getNum()+1));
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



    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }
}
