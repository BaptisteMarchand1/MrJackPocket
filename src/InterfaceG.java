import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceG {
	
	public JPanel centralPanel;
	public JFrame frame;
	private JDistrict Sherlock;
	private JDistrict Watson;
	private JDistrict Tobi;
	private int[] positionsEnq = {1,2,3,9,14,19,23,22,21,15,10,5};
	private int[] positionsDistricts = {6,7,8,11,12,13,16,17,18};

	
	public ArrayList<JDistrict> jdistrictsSorted = new ArrayList<>();
	public ArrayList<String> listSortedSuspects = new ArrayList<>();
	public ArrayList<JDistrict> jdistricts = new ArrayList<>();
	
	public InterfaceG() throws IOException {
		
		frame = new JFrame("Mister Jack Pocket");
		frame.setSize(1600, 900);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Central Panel
				
		centralPanel = new JPanel();
		centralPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		centralPanel.setPreferredSize(new Dimension(600,750));
		centralPanel.setLayout(new GridLayout(5,5));
		
		BufferedImage Contour1 = ImageIO.read(new File("Relai.png"));
		JDistrict district1 = new JDistrict(Contour1, centralPanel);
		jdistricts.add(district1);
				
		BufferedImage Contour2 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB2 = new JDistrict(Contour2, centralPanel);
		jdistricts.add(ContourB2);
				
		BufferedImage Contour3 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB3 = new JDistrict(Contour3, centralPanel);
		jdistricts.add(ContourB3);
				
		BufferedImage Contour4 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB4 = new JDistrict(Contour4, centralPanel);
		jdistricts.add(ContourB4);
				
		BufferedImage Contour5 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB5 = new JDistrict(Contour5, centralPanel);
		jdistricts.add(ContourB5);
				
		BufferedImage SherlockC = ImageIO.read(new File("Sherlock.png"));
		this.Sherlock = new JDistrict(SherlockC, centralPanel);
		jdistricts.add(Sherlock);
		
				
		BufferedImage lestradeRecto = ImageIO.read(new File("InspLestrade-recto.png"));
		JDistrict RectoLestrade = new JDistrict(lestradeRecto, centralPanel);
		jdistricts.add(RectoLestrade);
		
		BufferedImage josephRecto = ImageIO.read(new File("JosephLane-recto.png"));
		JDistrict RectoJoseph = new JDistrict(josephRecto, centralPanel);
		jdistricts.add(RectoJoseph);
				
		BufferedImage gullRecto = ImageIO.read(new File("WilliamGull-recto.png"));
		JDistrict RectoGull = new JDistrict(gullRecto, centralPanel);
		jdistricts.add(RectoGull);
				
		BufferedImage WatsonC = ImageIO.read(new File("Watson.png"));
		JDistrict Watson = new JDistrict(WatsonC, centralPanel);
		jdistricts.add(Watson);
				
		BufferedImage Contour6 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB6 = new JDistrict(Contour6, centralPanel);
		jdistricts.add(ContourB6);
		
		BufferedImage madameRecto = ImageIO.read(new File("Madame-recto.png"));
		JDistrict RectoMadame = new JDistrict(madameRecto, centralPanel);
		jdistricts.add(RectoMadame);
				
		BufferedImage smithRecto = ImageIO.read(new File("JohnSmith-recto.png"));
		JDistrict RectoSmith = new JDistrict(smithRecto, centralPanel);
		jdistricts.add(RectoSmith);
		
		BufferedImage bertRecto= ImageIO.read(new File("JeremyBert-recto.png"));
		JDistrict RectoBert = new JDistrict(bertRecto, centralPanel);
		jdistricts.add(RectoBert);
				
		BufferedImage Contour7 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB7 = new JDistrict(Contour7, centralPanel);
		jdistricts.add(ContourB7);
				
		BufferedImage Contour8 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB8 = new JDistrict(Contour8, centralPanel);
		jdistricts.add(ContourB8);
		
		BufferedImage goodleyRecto = ImageIO.read(new File("SgtGoodley-recto.png"));
		JDistrict RectoGoodley = new JDistrict(goodleyRecto, centralPanel);
		jdistricts.add(RectoGoodley);
				
		BufferedImage stealthyRecto = ImageIO.read(new File("MissStealthy-recto.png"));
		JDistrict RectoStealthy = new JDistrict(stealthyRecto, centralPanel);
		jdistricts.add(RectoStealthy);
		
		BufferedImage pizerRecto = ImageIO.read(new File("JohnPizer-recto.png"));
		JDistrict RectoPizer = new JDistrict(pizerRecto, centralPanel);
		jdistricts.add(RectoPizer);
				
		BufferedImage Contour9 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB9 = new JDistrict(Contour9, centralPanel);
		jdistricts.add(ContourB9);
				
		BufferedImage Contour10 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB10 = new JDistrict(Contour10, centralPanel);
		jdistricts.add(ContourB10);
				
		BufferedImage Contour11 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB11 = new JDistrict(Contour11, centralPanel);
		jdistricts.add(ContourB11);
				
		BufferedImage tobiC = ImageIO.read(new File("Tobi.png"));
		JDistrict Tobi = new JDistrict(tobiC, centralPanel);
		jdistricts.add(Tobi);
				
		BufferedImage Contour12 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB12 = new JDistrict(Contour12, centralPanel);
		jdistricts.add(ContourB12);
				
		BufferedImage Contour13 = ImageIO.read(new File("Relai.png"));
		JDistrict ContourB13 = new JDistrict(Contour13, centralPanel);
		jdistricts.add(ContourB13);
		
		remplirGrid();
		
		frame.add(centralPanel, BorderLayout.CENTER);
		
		//Right panel
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightPanel.setPreferredSize(new Dimension(400,750));
		rightPanel.setLayout(new GridLayout(2,2));
		
		
		BufferedImage Jeton1 = ImageIO.read(new File("Jeton1-Face1.png"));
		JLabel JetonN1 = new JLabel(new ImageIcon(Jeton1));
		rightPanel.add(JetonN1);
		
		BufferedImage Jeton2 = ImageIO.read(new File("Jeton2-Face1.png"));
		JLabel JetonN2 = new JLabel(new ImageIcon(Jeton2));
		rightPanel.add(JetonN2);
		
		BufferedImage Jeton3 = ImageIO.read(new File("Jeton3-Face1.png"));
		JLabel JetonN3 = new JLabel(new ImageIcon(Jeton3));
		rightPanel.add(JetonN3);
		
		BufferedImage Jeton4 = ImageIO.read(new File("Jeton4-Face1.png"));
		JLabel JetonN4 = new JLabel(new ImageIcon(Jeton4));
		rightPanel.add(JetonN4);

		frame.add(rightPanel, BorderLayout.LINE_END);
		frame.setSize(1301, 900);
		frame.setLocation(0, 0);
	}
	
	public void remplirGrid(){
		for (int i = 0; i < 25;i++) {
			centralPanel.add(jdistricts.get(i), i);
	      }
	}
	
	public void permutation(int a,int b){
		Collections.swap(jdistricts, a, b);
	    centralPanel.removeAll();
	    remplirGrid();
	    frame.revalidate();
	    frame.repaint();
	}
	
	public void rotation(JDistrict jdistrict, int quarterTurn) {
		jdistrict.rotate(quarterTurn);
	    centralPanel.removeAll();
	    remplirGrid();
	    frame.revalidate();
	    frame.repaint();
	}
	
	public JDistrict getSherlock () {
		return this.Sherlock;
	}
	public JDistrict getWatson () {
		return this.Watson;
	}
	public JDistrict getTobi () {
		return this.Tobi;
	}
	
	public void replaceD(JDistrict a, int c) throws IOException {
		BufferedImage Buffered = ImageIO.read(new File("common-verso.png"));
		JDistrict Temp = new JDistrict(Buffered , centralPanel);
		a=Temp;
		jdistricts.add(a);
		permutation(jdistricts.indexOf(a), c);
	}
	
	
	public void deplacementEnqueteur (JDistrict enq, Enqueteurs enqueteur, int nbCases) {
		this.permutation(positionsEnq[enqueteur.getPosition()], positionsEnq[(enqueteur.getPosition()+nbCases)%12]);
	}


	
	public void shuffleJDistricts() {
		ArrayList<JDistrict> jdistrictsSorted = new ArrayList<>(jdistricts);
		
		for (int i : positionsDistricts) {
			for (int j = 0; j<9; j++) {
				if(jdistricts.get(i).getNom() == listSortedSuspects.get(j)) {
					jdistrictsSorted.set(i, jdistricts.get(positionsDistricts[j]));
				}
			}
		}
	}
}

