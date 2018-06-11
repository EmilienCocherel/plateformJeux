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

	/**
	 * @param colonne La colonne à vérifier
	 * @return Si il est possible de jouer à cette colonne
	 */
    private boolean caseLibre(int colonne) {
		if (0 <= colonne && colonne < this.getNbColonnes() && this.get(colonne, 0) == null)
			return true;
		return false;
    }

}
