public class Enqueteurs {
	private int position;
	//private int
	
	public Enqueteurs (int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
		
	
	public void deplacement (Enqueteurs enqueteur, int nbCases /*1 ou 2*/) {
		enqueteur.position = (enqueteur.position + nbCases) % 12;
	}
}
