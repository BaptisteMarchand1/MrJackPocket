import java.util.ArrayList;

public class JoueurEnqueteur {
	private ArrayList<String> Suspects = new ArrayList<String>();
	
	
	public void initSuspects() {
		this.Suspects.add("Inspecteur Lestrade");
		this.Suspects.add("Miss Stealthy");
		this.Suspects.add("Jeremy Bert");
		this.Suspects.add("John Smith");
		this.Suspects.add("Joseph Lane");
		this.Suspects.add("Madame");
		this.Suspects.add("Sgt Goodley");
		this.Suspects.add("William Gull");
	}
	
	public void remove(String suspect) {
		this.Suspects.remove(suspect);
	}
	
	public ArrayList<String> getSuspects() {
		return Suspects;
	}
}