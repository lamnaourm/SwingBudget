
public class Depense {

	static int cp=0;
	private int id;
	private String description;
	private String categorie;
	private double montant;

	public Depense() {
		id=++cp;
	}
	
	public Depense(String description,String categorie, double montant) {
		super();
		id=++cp;
		this.description = description;
		this.categorie = categorie;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

}
