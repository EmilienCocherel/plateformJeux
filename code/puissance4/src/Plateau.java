import java.util.List;

public class Plateau extends Matrice<Integer> {
    public Plateau() {
        super(7, 7);
    }


	/**
	 * @param colonne La colonne à laquelle placer le pion
	 * @param pion Le pion à placer
	 * @return -1 si placer le pion a échoué, 0 si personne n'a gagné ou 1 si le pion a gagné la partie
	 */
    public int placerPion(int colonne, Integer pion) {
		int ligne = 0;
		if (this.caseLibre(colonne)) {
			while (ligne+1 < this.getNbLignes() && this.get(colonne, ligne+1) == null)
				ligne ++;
			this.set(colonne, ligne, pion);
		} else
			return -1;

		// Voir si le pion a gagné
		if (this.aGagne(colonne, ligne))
			return 1;
		else
			return 0;
    }

	public boolean aGagne(int colonne, int ligne) {
		Integer pion = this.get(ligne, colonne);
		// Vérifier la ligne
		List<Integer> l = this.getLigne(ligne);
		for (int i = 0; i < l.size() - 4; i++)
			if (l.get(i) == pion && l.get(i+1) == pion && l.get(i+2) == pion && l.get(i+3) == pion)
				return true;

		// Vérifier la colonne
		List<Integer> c = this.getColonne(ligne);
		for (int i = 0; i < c.size() - 4; i++)
			if (c.get(i) == pion && c.get(i+1) == pion && c.get(i+2) == pion && c.get(i+3) == pion)
				return true;

		// Vérifier la diagonale principale
		int diagonale_x = ligne, diagonale_y = colonne;
		while (diagonale_x != 0 && diagonale_y != 0) {
			diagonale_x --;
			diagonale_y --;
		}
		List<Integer> d = this.getDiagonalePrincipale(diagonale_y, diagonale_x);
		if (d.size() >= 4)
			for (int i = 0; i < d.size() - 4; i++)
				if (d.get(i) == pion && d.get(i+1) == pion && d.get(i+2) == pion && d.get(i+3) == pion)
					return true;

		// Vérifier la diagonale secondaire
		diagonale_x = ligne;
		diagonale_y = colonne;
		while (diagonale_x != 0 && diagonale_y != 7) {
			diagonale_x --;
			diagonale_y ++;
		}
		d = this.getDiagonaleSecondaire(diagonale_y, diagonale_x);
		if (d.size() >= 4)
			for (int i = 0; i < d.size() - 4; i++)
				if (d.get(i) == pion && d.get(i+1) == pion && d.get(i+2) == pion && d.get(i+3) == pion)
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
}
