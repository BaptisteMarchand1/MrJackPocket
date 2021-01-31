import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class JDistrict extends JComponent{
	
	private static final long serialVersionUID = 1L;
	
	private BufferedImage Image;
	private ImageIcon Icon;
	private JPanel parent;
	private String nom;
	

	
	public JDistrict(BufferedImage Image, JPanel parent) {
		this.parent = parent;
		this.Image = Image;
		this.Icon = new ImageIcon(Image);
		this.nom = "";
	}
	
	public JDistrict(BufferedImage Image, JPanel parent, String nom) {
		this.parent = parent;
		this.Image = Image;
		this.Icon = new ImageIcon(Image);
		this.nom = nom;
	}
	
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Image, 0, 0, null);
    }


	public BufferedImage rotate(int quarterTurn) {
		int w = Image.getWidth();
		int h = Image.getHeight();
		BufferedImage rotated = new BufferedImage(w, h, Image.getType());
		Graphics2D graphic = rotated.createGraphics();
		graphic.rotate(Math.toRadians(quarterTurn*90), w/2, h/2);
		graphic.drawImage(Image, null, 0, 0);
		graphic.dispose();
		Image = rotated;
		return rotated;
	}
	
	public String getNom() {
		return this.nom;
	}
}


