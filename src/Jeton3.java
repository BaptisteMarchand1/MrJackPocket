public class Jeton3 extends Jetons {
	
	// Rotation
	public void actionRecto(District[][] plateau, int l, int c, int nouveauMur) {
		plateau[l][c].setMur(nouveauMur);
	}
	
	// Permutation
	public void actionVerso(District[][] plateau, int l1, int c1, int l2, int c2) {
		District d1 = plateau[l1][c1];
		District d2 = plateau[l2][c2];
			
		plateau[l1][c1] = d2;
		plateau[l2][c2] = d1;
		
	}
	
	@Override
	public String getName() {
		if (this.getRecto() == true) {
			return "Rotation d'un district";
		}
		else {
			return "Permutation de deux districts";
		}
	}
}
	
