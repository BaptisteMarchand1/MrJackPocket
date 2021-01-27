public class Jeton2 extends Jetons {
	private String actionR;
	private String actionV;

	
	//Watson
	public void actionRecto(Enqueteurs enqueteur, int nbCases) {
		enqueteur.deplacement(enqueteur,nbCases);
	}
	
	//Tobi
	public void actionVerso(Enqueteurs enqueteur, int nbCases) {
		enqueteur.deplacement(enqueteur,nbCases);
	}
	
	@Override
	public String getName() {
		if (this.getRecto() == true) {
			return "Watson avance 1 ou 2 cases";
		}
		else {
			return "Tobi avance de 1 ou 2 cases";
		}
	}
}
