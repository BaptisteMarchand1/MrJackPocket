public class Enqueteurs {
	private int position;
	
	public Enqueteurs (int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
		
	
	public void deplacement (Enqueteurs enqueteur, int nbCases /*1 ou 2*/) {
		enqueteur.position = (enqueteur.position + nbCases) % 12;
	}
	
	
	
	
	
	/*
	public static void deplacement (Enqueteurs enqueteur) {
		if (enqueteur.position == [0,1] || enqueteur.position == [0,2]) {
			enqueteur.position[1]++;
		}
		
		else if (enqueteur.position == [1,4] || enqueteur.position == [2,4]) {
			enqueteur.position[0]++;
		}
		
		else if (enqueteur.position == [4,3] || enqueteur.position == [4,2]) {
			enqueteur.position[1]--;
		}
		
		else if (enqueteur.position == [3,0] || enqueteur.position == [2,0]) {
			enqueteur.position[0]--;
		}
		
		else if (enqueteur.position == [0,3]) {
			enqueteur.position = [1,4];
		}
		
		else if (enqueteur.position == [3,4]) {
			enqueteur.position = [4,3];
		}
		
		else if (enqueteur.position == [4,1]) {
			enqueteur.position = [3,0];
		}
		
		else if (enqueteur.position == [1,0]) {
			enqueteur.position = [0,1];
		}
	}*/




}
