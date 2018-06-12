import org.json.simple.JSONArray;
import java.util.List;

public class Plateau extends Matrice<Integer> {
    public Plateau() {
        super(7, 7);
    }


	/**
	 * @param colonne La colonne à laquelle placer le pion
	 * @param pion Le pion à placer
	 * @return si le pion a gagné la partie
	 */
    public boolean placerPion(int colonne, Integer pion) {
		int ligne = 0;
		while (ligne+1 < this.getNbLignes() && this.get(ligne+1, colonne) == null)
			ligne ++;
		this.set(ligne, colonne, pion);

		// Voir si le pion a gagné
		return this.aGagne(ligne, colonne);
    }

	/**
	 * @param liste Une liste de pions (ligne, colonne ou diagonale)
	 * @param pion Le pion recherché
	 * @return Si le pion recherché gagne dans cette liste (càd est aligné 4 fois)
	 */
	public static boolean finie(List<Integer> liste, Integer pion) {
		if (liste.size() >= 4)
			for (int i = 0; i < liste.size() - 3; i++) {
				if (liste.get(i) == pion && liste.get(i+1) == pion &&
						liste.get(i+2) == pion && liste.get(i+3) == pion)
					return true;
			}
		return false;
	}

	public boolean aGagne(int ligne, int colonne) {
		Integer pion = this.get(ligne, colonne);
		// Vérifier la ligne
		List<Integer> l = this.getLigne(ligne);
		if (Plateau.finie(l, pion))
			return true;

		// Vérifier la colonne
		List<Integer> c = this.getColonne(colonne);
		if (Plateau.finie(c, pion))
			return true;

		// Vérifier la diagonale principale
		int diagonale_x = ligne, diagonale_y = colonne;
		while (diagonale_x != 0 && diagonale_y != 0) {
			diagonale_x --;
			diagonale_y --;
		}
		List<Integer> d = this.getDiagonalePrincipale(diagonale_y, diagonale_x);
		if (Plateau.finie(d, pion))
			return true;

		// Vérifier la diagonale secondaire
		diagonale_x = ligne;
		diagonale_y = colonne;
		while (diagonale_x > 0 && diagonale_y < 6) {
			diagonale_x --;
			diagonale_y ++;
		}
		d = this.getDiagonaleSecondaire(diagonale_y, diagonale_x);
		if (Plateau.finie(d, pion))
			return true;

		// Si le pion n'a pas gagné
		return false;
	}

	/**
	 * @param colonne La colonne à vérifier
	 * @return Si il est possible de jouer à cette colonne
	 */
    private boolean caseLibre(int colonne) {
		if (0 <= colonne && colonne < this.getNbColonnes() && this.get(colonne, 0) == null)
			return true;
		return false;
    }

	/**
	 * Remettre à zéro pour le round suivant
	 */
	public void reset() {
		for (int ligne = 0; ligne < this.getNbLignes(); ligne ++)
			for (int colonne = 0; colonne < this.getNbColonnes(); colonne ++)
				this.set(ligne, colonne, null);
	}

	/**
	 * Convertir le plateau au format json
	 */
	public JSONArray toJson() {
		JSONArray res = new JSONArray();
		JSONArray elem;
		for (int ligne = 0; ligne < this.getNbLignes(); ligne ++) {
			elem = new JSONArray();
			for (int colonne = 0; colonne < this.getNbColonnes(); colonne ++)
				elem.add(this.get(ligne, colonne));
			res.add(elem);
		}
		return res;
	}
}
