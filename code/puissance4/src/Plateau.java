public class Plateau extends Matrice<Integer> {
    public Plateau() {
        super(7, 7);
    }


	/**
	 * @param colonne La colonne à laquelle placer le pion
	 * @param pion Le pion à placer
	 */
    public boolean placerPion(int colonne, Integer pion) {
		if (this.caseLibre(colonne)) {
			int ligne = 0;
			while (ligne+1 < this.getNbLignes() && this.get(colonne, ligne+1) == null)
				ligne ++;
			this.set(colonne, ligne, pion);
			return true;
		} else
			return false;
    }

    private boolean caseLibre(int colonne) { // À IMPLÉMENTER
        return true;
    }

}
