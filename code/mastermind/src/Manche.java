public class Manche {
    private Joueur j;
    private int num;
    private Combinaison combi;
    private Mastermind partie;
    private int nbCoup;
    private boolean fini;

    public Manche(Combinaison combi,Mastermind partie, Joueur j, int num){
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
        return this.fini;
    }

    public void finManche(){
        this.partie.prochaineManche(this);
    }

    public Joueur getJoueur(){
        return this.j;
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
