import java.util.List;

public class Matrice<T> {
    private List<List<T>> tableau;

	/**
	 * @param lignes Le nombre de lignes de la nouvelle matrice
	 * @param colonnes Le nombre de colonnes de la nouvelle matrice
	 */
    public Matrice(int lignes, int colonnes) {
		this.tableau = new ArrayList<>();
		for (int i = 0; i < hauteur; i++) {
			this.matrice.add(new ArrayList<T>());
			for (int j = 0; j < largeur; j++) {
				this.matrice.get(i).add(null);
			}
		}
    }

//    Getter et Setter

	/**
	 * @param colonne La colonne à rechercher
	 * @param ligne La ligne à rechercher
	 * @return L'objet à la position demandée
	 */
    public T get(int ligne, int colonne) {
		return this.tableau.get(ligne).get(colonne);
    }

	/**
	 * @param colonne La colonne à rechercher
	 * @param ligne La ligne à rechercher
	 * @param valeur La nouvelle valeur de la position donnée
	 */
    public boolean set(int ligne, int colonne, T valeur) {
		return this.tableau.get(ligne).set(colonne, valeur);
    }

    public List<List<T>> getTableau() {
        return tableau;
    }

    public void setTableau(List<List<T>> tableau) {
        this.tableau = tableau;
    }
}
