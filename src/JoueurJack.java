public class JoueurJack {
	private String coupable;
	private int sabliers;
	
	public JoueurJack(String coupable) {
		this.coupable = coupable;
	}
	
	public String getCoupable() {
		return coupable;
	}
	
	public int getSabliers(){
		return sabliers;
	}
	
	public void addSabliers(int n) {
		sabliers += n;
	}
}



