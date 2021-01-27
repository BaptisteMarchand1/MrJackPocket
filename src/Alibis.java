public class Alibis {
	private String nom;
	private int nbSabliers;
	

	public Alibis(String nom, int nbSabliers) {
		this.nom = nom;
		this.nbSabliers = nbSabliers;
	}
	
	public String getNom() {
		return nom;
	}
	public int getSablier() {
		return nbSabliers;
	}
	
	
	public String toString() {
		StringBuilder affichage = new StringBuilder();
		affichage.append(this.getNom());
		affichage.append("(" + this.getSablier() + ")");
		return affichage.toString();
	}
	


}

