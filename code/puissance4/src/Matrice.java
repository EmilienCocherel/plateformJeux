import java.util.List;

public class Matrice<T> {

    private List<List<T>> tableau;

    public Matrice(int lignes, int colonnes){

    }

    public Matrice(){

    }

//    Getter et Setter

    public T get(int ligne, int colonne){ // À IMPLEMENTER
        return null;
    }

    public boolean set(int ligne, int colonne, T valeur){ // À IMPLEMENTER
        return true;
    }

    public List<List<T>> getTableau() {
        return tableau;
    }

    public void setTableau(List<List<T>> tableau) {
        this.tableau = tableau;
    }
}
