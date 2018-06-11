import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Matrice<T> {
    private List<List<T>> tableau;

	/**
	 * @param lignes Le nombre de lignes de la nouvelle matrice
	 * @param colonnes Le nombre de colonnes de la nouvelle matrice
	 */
    public Matrice(int lignes, int colonnes) {
		this.tableau = new ArrayList<>();
		for (int i = 0; i < lignes; i++) {
			this.tableau.add(new ArrayList<T>());
			for (int j = 0; j < colonnes; j++) {
				this.tableau.get(i).add(null);
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
		return this.tableau.get(ligne).set(colonne, valeur) != null;
    }

	/**
	 * @return Le nombre de colonnes de la matrice
	 */
	public int getNbColonnes() {
		return this.tableau.get(0).size();
	}

	/**
	 * @return Le nombre de lignes de la matrice
	 */
	public int getNbLignes() {
		return this.tableau.size();
	}

	/**
	 * @return Un ensemble des lignes de la matrice.
	 */
	public Set<List<T>> getLignes() {
		Set<List<T>> res = new HashSet<>();
		List<T> liste;
		for (int lig=0; lig<this.getNbLignes(); lig++) {
			liste = new ArrayList<>();
			for (int col=0; col<this.getNbColonnes(); col++) {
				liste.add(this.get(lig, col));
			}
			res.add(liste);
		}
		return res;
	}

	/**
	 * @return Un ensemble des colonnes de la matrice.
	 */
	public Set<List<T>> getColonnes() {
		Set<List<T>> res = new HashSet<>();
		List<T> liste;
		for (int col=0; col<this.getNbColonnes(); col++) {
			liste = new ArrayList<>();
			for (int lig=0; lig<this.getNbLignes(); lig++) {
				liste.add(this.get(lig, col));
			}
			res.add(liste);
		}
		return res;
	}

	/**
	 * @param colonne La colonne de départ de la diagonale.
	 * @param ligne La ligne de départ de la diagonale.
	 * @return La diagonale indiquée
	 */
	private List<T> getDiagonalePrincipale(int colonne, int ligne) {
		List<T> res = new ArrayList<>();
		int x = colonne, y = ligne;
		while (y >= this.getNbLignes() && x < this.getNbColonnes()) {
			res.add(this.get(x, y));
			x++;
			y++;
		}
		return res;
	}

	/**
	 * @param colonne La colonne de départ de la diagonale.
	 * @param ligne La ligne de départ de la diagonale.
	 * @return La diagonale indiquée
	 */
	private List<T> getDiagonaleSecondaire(int colonne, int ligne) {
		List<T> res = new ArrayList<>();
		int x = colonne, y = ligne;
		while (y >= 0 && x < this.getNbColonnes()) {
			res.add(this.get(x, y));
			x++;
			y--;
		}
		return res;
	}
	/**
	 * @return Un ensemble des diagonales de matrice.
	 */
	public Set<List<T>> getDiagonales() {
		Set<List<T>> res = new HashSet<>();
		// Diagonales principales
		for (int nb=0; nb<this.getNbLignes(); nb++) {
			res.add(this.getDiagonalePrincipale(0, nb));
			if (nb>0)
				res.add(this.getDiagonaleSecondaire(nb, 0));
		}
		// Diagonales secondaires
		for (int nb=0; nb<this.getNbLignes(); nb++) {
			res.add(this.getDiagonaleSecondaire(0, nb));
			if (nb>0)
				res.add(this.getDiagonaleSecondaire(nb, 6));
		}
		return res;
	}
}
