public class District {
	
	public District(String suspect) {
		this.suspect = suspect;
		this.id = suspect.substring(0,1);
		this.vide = false;
		this.mur = 0;
	}
	
	public District(String suspect, String id) {
		this.suspect = suspect;
		this.id = id;
		this.vide = false;
		this.mur = 0;
	}
	
	public District(boolean vide, int mur) {
		this.suspect = "x";
		this.id = "x";
		this.vide = vide;
		this.mur = mur;
	}
	
	public String suspect;
	public String id; 		// Identifiant du suspect par un seul caractère
	public boolean vide; 	// false si le personnage est encore suspect
	public int mur;			// valeur 0,1, 2 ou 3 selon le côté du mur, indiqué dans le sens des aiguilles d'une montre en commencant par le nord

	public void setMur(int x) {
		mur = x;
	 }
	
	public int getMur() {
		return mur;
	}
		
	public String getSuspect() {
		return this.suspect;
	}
	
	public void retourner() {
		this.vide = true;
	}
	
	
	
	public String getId() {
		return this.id;
	}
}
	