import java.util.Random;

public abstract class Jetons {
	private boolean recto;  	// = true pour la face recto, false sinon
	
	public boolean getRecto() {
		return recto;
	}
	
	public void tirageAuSort() {
		Random face = new Random();
		recto = face.nextBoolean();
	}
	
	public void retourner() {
		recto = !recto;
	}
	
	public String getName() {
		return "a";
	}
	
	
	
}
