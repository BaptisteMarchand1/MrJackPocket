import java.util.LinkedList;

public class Jeton1 extends Jetons {
	private Alibis carte;
	
	
	//Alibi
	public Alibis actionRecto(LinkedList<Alibis> pile) {
		this.carte = piocher(pile);
		pile.remove(carte);
		return carte;
	}
	
	
	//Sherlock
	public void actionVerso(Enqueteurs enqueteur, int nbCases) {
		enqueteur.deplacement(enqueteur,nbCases);
	}
	
	@Override
	public String getName() {
		if (this.getRecto() == true) {
			return "Piocher une carte Alibi";
		}
		else {
			return "Sherlock avance de 1 ou 2 cases";
		}
	}

	
	public static Alibis piocher(LinkedList<Alibis> pile) {
		Alibis carte = pile.pollFirst();
		return carte;
	}
	
}
