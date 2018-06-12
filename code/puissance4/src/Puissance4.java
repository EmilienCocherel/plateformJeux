import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;

public class Puissance4 {
    private List<Joueur> gagnants;
    private int id;
	private Joueur joueur1, joueur2;
	private Plateau plateau;
	/** Joueur actuel */
	private int actuel;

	/**
	 * @param joueur1 Le premier joueur
	 * @param joueur2 Le second joueur
	 */
    public Puissance4(Joueur j1, Joueur j2){
		this.plateau = new Plateau();
		this.gagnants = new ArrayList<>();
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.id = -1;
		this.actuel = 1;
    }

    public Integer getPion(int ligne, int colonne) {
        return this.plateau.get(ligne, colonne);
    }

    public boolean jouer(int colonne) {
		boolean res;
		Joueur joueur;
		if (this.actuel == 1) {
			joueur = this.joueur1;
			this.actuel = 2;
		} else {
			joueur = this.joueur2;
			this.actuel = 1;
		}
		res = this.plateau.placerPion(colonne, joueur.getPion());
		if (res) {
			this.gagnants.add(joueur);
			joueur1.reset();
			joueur2.reset();
			plateau.reset();
		} else
			joueur.retirerPion();
		return res;
    }

    private boolean retirerPion() { // À IMPLÉMENTER
        return true;
    }

//    Getter et Setter

    private Joueur getJoueur(String nom){ // À IMPLÉMENTER
        return null;
    }

    private Integer getNbPions(String joueur){ // À IMPLÉMENTER
        return null;
    }
    public List<Joueur> getGagnants() {
        return this.gagnants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Plateau getPlateau() {
		return this.plateau;
	}

	public Joueur getJoueur1() {
		return this.joueur1;
	}

	public Joueur getJoueur2() {
		return this.joueur2;
	}

	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("plateau", this.plateau.toJson());
		obj.put("joueur1", this.joueur1.toJson());
		obj.put("joueur2", this.joueur2.toJson());
		obj.put("actuel", this.actuel);
		obj.put("id", this.id);
		System.out.println(obj);
		return obj;
	}
}
