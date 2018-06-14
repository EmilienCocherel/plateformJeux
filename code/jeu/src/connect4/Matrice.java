package connect4;

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
	 * @param ligne La ligne souhaitée
	 * @return La ligne demandée en paramètre
	 */
	public List<T> getLigne(int ligne) {
		List<T> res = new ArrayList<>();
		for (int colonne = 0; colonne < this.getNbColonnes(); colonne ++) {
			res.add(this.get(ligne, colonne));
		}
		return res;
	}

	/**
	 * @param ligne La ligne souhaitée
	 * @return La ligne demandée en paramètre
	 */
	public List<T> getColonne(int colonne) {
		List<T> res = new ArrayList<>();
		for (int ligne = 0; ligne < this.getNbLignes(); ligne ++) {
			res.add(this.get(ligne, colonne));
		}
		return res;
	}

	/**
	 * @param ligne La ligne de départ de la diagonale.
	 * @param colonne La colonne de départ de la diagonale.
	 * @return La diagonale indiquée
	 */
	public List<T> getDiagonalePrincipale(int ligne, int colonne) {
		List<T> res = new ArrayList<>();
		int x = colonne, y = ligne;
		while (y < this.getNbLignes() && x < this.getNbColonnes()) {
			res.add(this.get(x, y));
			x++;
			y++;
		}
		return res;
	}

	/**
	 * @param ligne La ligne de départ de la diagonale.
	 * @param colonne La colonne de départ de la diagonale.
	 * @return La diagonale indiquée
	 */
	public List<T> getDiagonaleSecondaire(int ligne, int colonne) {
		List<T> res = new ArrayList<>();
		int x = colonne, y = ligne;
		while (y >= 0 && x < this.getNbColonnes()) {
			res.add(this.get(x, y));
			x++;
			y--;
		}
		return res;
	}
}
