public class Jeton4 extends Jetons {
	
	// Rotation
	public void actionRecto(District[][] plateau, int l, int c, int nouveauMur) {
		plateau[l][c].setMur(nouveauMur);
	}
	
	public void actionVerso(Enqueteurs enqueteur /*enqueteur au choix*/, int nbCases /*1 ou 0*/) {
		enqueteur.deplacement(enqueteur,nbCases);
	}
	
	@Override
	public String getName() {
		if (this.getRecto() == true) {
			return "Rotation d'un district";
		}
		else {
			return "Un enquêteur au choix avance d'une case (ou 0 si Mr Jack la joue)";
		}
	}
}
