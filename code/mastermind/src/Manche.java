import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class    Manche {
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

    public Manche(){

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

    public Combinaison initCombi(){
        Random randint = new Random();
        List<Pion> liste = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            int randInt = randint.nextInt(3);
            switch(i) {
                case 0:
                switch (randInt) {
                    case 0:
                        combi.setP1(1);
                        break;
                    case 1:
                        combi.setP2(1);
                        break;
                    case 2:
                        combi.setP3(1);
                        break;
                    case 3:
                        combi.setP4(1);
                        break;
                }
                break;
                case 1:
                    switch (randInt) {
                        case 0:
                            combi.setP1(2);
                            break;
                        case 1:
                            combi.setP2(2);
                            break;
                        case 2:
                            combi.setP3(2);
                            break;
                        case 3:
                            combi.setP4(2);
                            break;
                    }
                    break;
                case 2:
                    switch (randInt) {
                        case 0:
                            combi.setP1(3);
                            break;
                        case 1:
                            combi.setP2(3);
                            break;
                        case 2:
                            combi.setP3(3);
                            break;
                        case 3:
                            combi.setP4(3);
                            break;
                    }
                    break;
                case 3:
                    switch (randInt) {
                        case 0:
                            combi.setP1(4);
                            break;
                        case 1:
                            combi.setP2(4);
                            break;
                        case 2:
                            combi.setP3(4);
                            break;
                        case 3:
                            combi.setP4(4);
                            break;
                    }
                    break;
            }
        }
        return combi;
    }


    public void finManche(){
        this.partie.prochaineManche(this);
    }

    public Joueur getJoueur(){
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
