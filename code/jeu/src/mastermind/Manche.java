package mastermind;

public class    Manche {
    private JoueurMastermind j;
    private int num;
    private Combinaison combi;
    private Mastermind partie;
    private int nbCoup;
    private boolean fini;

    public Manche(Combinaison combi,Mastermind partie, JoueurMastermind j, int num){
        this.j=j;
        this.combi=combi;
        this.partie=partie;
        this.num=num;
        this.nbCoup=0;
        this.fini=false;
    }

    public void verifCombi(Combinaison test){
        if(this.combi.equals(test)){
            this.finManche();
        }
    }

    public boolean estFini(){
        if (this.getCombi().equals(this.getCombi())){
            return true;
        }

        else{
            return false;
        }
    }

    public void finManche(){
        this.partie.prochaineManche(this);
    }

    public JoueurMastermind getJoueurMastermind(){
        return this.j;
    }

    public Combinaison getCombi() {
        return combi;
    }

    public int getNbCoup(){
        return this.nbCoup;
    }

    public void incrNbCoup(){
        this.nbCoup+=1;
    }

    public int getNum(){
        return this.num;
    }


}
