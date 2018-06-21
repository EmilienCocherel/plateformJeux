package application;

public class Statistique {
	private JeuProfil jeu;
	private long pourcentVictoire;
	
	public Statistique(JeuProfil jeu, long pourcentVictoire) {
		this.jeu = jeu;
		this.pourcentVictoire = pourcentVictoire;
	}

	public String getNomJeu() {
		return this.jeu.getNomJeu();
	}

	public long getPourcentVictoire() {
		return this.pourcentVictoire;
	}
}
