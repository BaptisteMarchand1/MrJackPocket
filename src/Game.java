import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
	
	District[][] plateau;
	public static final String ANSI_RED = "\u001B[31m";
	
	// Initialise les jetons
	
	
	public void play() {
		
/********************** INITIALISATIONS ***********************/
		
		LinkedList<Alibis> pile = new LinkedList<>();
		pile.addFirst(new Alibis("Inspecteur Lestrade",0));
		pile.addFirst(new Alibis("Miss Stealthy",1));
		pile.addFirst(new Alibis("Jeremy Bert",1));
		pile.addFirst(new Alibis("John Pizer",1));
		pile.addFirst(new Alibis("Joseph Lane",1));
		pile.addFirst(new Alibis("Madame", 2));				
		pile.addFirst(new Alibis("Sgt Goodley", 0));
		pile.addFirst(new Alibis("William Gull",1));
		Collections.shuffle(pile);
		
		JoueurEnqueteur J1 = new JoueurEnqueteur();
		J1.initSuspects();
		JoueurJack J2 = new JoueurJack(pile.pollFirst().getNom());
		
		
		LinkedList<District> lesDistricts = this.initDistricts();
		this.plateau = new District[3][3];
		Random rand = new Random();
		for (int l=0;l<3;l++) {
			for (int c=0;c<3;c++) {
				int index = rand.nextInt( lesDistricts.size());
				District carte = lesDistricts.remove(index);
				this.plateau[l][c] = carte;
				if (l==0 & c==0) {
					carte.mur = 3;
				}
				
				else if(l==0 && c==2) {
					carte.mur = 1;
				}
				
				else if(l == 2 && c == 1) {
					carte.mur = 2;
				}
				
				else {
					carte.mur = rand.nextInt(4);
				}
				
			}
		}
		lesDistricts = this.initDistricts();

		Enqueteurs Sherlock = new Enqueteurs(11);
		Enqueteurs Watson = new Enqueteurs(3);
		Enqueteurs Tobi = new Enqueteurs(7);
		ArrayList<Enqueteurs> listEnqueteurs = new ArrayList<Enqueteurs>(); 	// Liste des trois enqueteurs pour l'appel à témoins
		listEnqueteurs.add(Sherlock);
		listEnqueteurs.add(Watson);
		listEnqueteurs.add(Tobi);		
		
		Jeton1 jeton1 = new Jeton1();
		Jeton2 jeton2 = new Jeton2();
		Jeton3 jeton3 = new Jeton3();
		Jeton4 jeton4 = new Jeton4();
		ArrayList<Integer> listJetons = initJetons();
		

		int jetonChoisi = 0;
		Scanner scanner = new Scanner(System.in);
		int k = 0;
		int i = 0;
				

		//System.out.println("Rouge" + ANSI_RED);
/**************************** JEU ****************************/

		this.affichePlateau(plateau, listEnqueteurs);
		/*plateau[0][0].getSuspect();
		plateau[0][0].retourner();
		plateau[0][0].getId();
		System.out.println("\n");

		this.affichePlateau(plateau, listEnqueteurs);*/
		/*lesDistricts.get(1).retourner();
		lesDistricts.get(2).retourner();
		lesDistricts.get(3).retourner();
		lesDistricts.get(4).retourner();*/


		for(int tour = 1; tour < 9; tour++) {
			
			if (tour%2 == 1) { 				// Tour impair				
				jeton1.tirageAuSort();
				jeton2.tirageAuSort();
				jeton3.tirageAuSort();
				jeton4.tirageAuSort();
				
				System.out.println("\nTirage au sort des jetons...");
				
				actionEnqueteur(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
				System.out.println();
				this.affichePlateau(plateau, listEnqueteurs);
				actionJack(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
				System.out.println();
				this.affichePlateau(plateau, listEnqueteurs);
				actionJack(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
				System.out.println();
				this.affichePlateau(plateau, listEnqueteurs);
				actionEnqueteur(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
			}
			
			else { 		// Tour Pair
				jeton1.retourner();
				jeton2.retourner();
				jeton3.retourner();
				jeton4.retourner();

				System.out.println("\nTirage au sort des jetons...");
			
				actionJack(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
				System.out.println();
				this.affichePlateau(plateau, listEnqueteurs);
				actionEnqueteur(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
				System.out.println();
				this.affichePlateau(plateau, listEnqueteurs);
				actionEnqueteur(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
				System.out.println();
				this.affichePlateau(plateau, listEnqueteurs);
				actionJack(listJetons, jeton1, jeton2, jeton3, jeton4, jetonChoisi, scanner, k, i, pile, Sherlock, Watson, Tobi, J1, J2, listEnqueteurs);
				}
			
			System.out.println();				
			//Appel à témoins + incrémentation du sablier
			appelATemoins(listEnqueteurs, J1, J2, lesDistricts);
			this.affichePlateau(plateau, listEnqueteurs);
			J2.addSabliers(1);
			listJetons = initJetons();
			
			// Vérifications de la fin du jeu
			if (J1.getSuspects().size() == 1) {
				System.out.println("\n\n   L'enquêteur remporte la partie !");
				break;
			}
			if (tour == 8) {
				System.out.println("\n\n   Mr Jack remporte la partie !");
				break;
			}
		}
		
	}

	
	
	
	
	
	
	
	
	/**************************** METHODES UTILES ****************************/
	
public void actionEnqueteur (ArrayList<Integer> listJetons, Jeton1 jeton1, Jeton2 jeton2, Jeton3 jeton3, Jeton4 jeton4,
		int jetonChoisi, Scanner scanner, int k, int i, LinkedList<Alibis> pile, Enqueteurs Sherlock, Enqueteurs Watson, Enqueteurs Tobi,
		JoueurEnqueteur J1, JoueurJack J2, ArrayList<Enqueteurs> listEnqueteurs) {
	// Choix du jeton
	System.out.print( "\nEnqueteur, choisissez un jeton parmi ");
	for (k = 0; k < listJetons.size() -1; k++) {
		System.out.print(listJetons.get(k) + ", ");
	}
	System.out.print(listJetons.get(listJetons.size()-1) +" : \n" );
	afficheNomActions(listJetons, jeton1,jeton2,jeton3,jeton4);
	jetonChoisi = scanner.nextInt();
	
// Action du jeton
	switch (jetonChoisi) {
		case 1:
			if (jeton1.getRecto() == true) {
				jeton1.actionRecto(pile);
				System.out.println(jeton1.actionRecto(pile).getNom() + " est innocent ! Il reste "+ J1.getSuspects().size() + " suspects.");
				J1.remove(jeton1.actionRecto(pile).getNom());
			}
			
			else {
				System.out.println("De combien de cases voulez-vous faire avancer Sherlock ?");
				int nbCases = scanner.nextInt();
				jeton2.actionRecto(Watson,nbCases);
				System.out.println("Sherlock avance de " + nbCases + " cases");
			}
			listJetons.remove(listJetons.indexOf(1));
			break;

		case 2:
			if (jeton2.getRecto() == true) {
				System.out.println("De combien de cases voulez-vous faire avancer Watson ?");
				int nbCases = scanner.nextInt();
				jeton2.actionRecto(Watson,nbCases);
				System.out.println("Watson avance de " + nbCases + " cases");
			}
			
			else {
				System.out.println("De combien de cases voulez-vous faire avancer Tobi ?");
				int nbCases = scanner.nextInt();
				jeton2.actionVerso(Tobi,nbCases);
				System.out.println("Tobi avance de " + nbCases +" cases");
			}
			listJetons.remove(listJetons.indexOf(2));
			break;						
			
			
		case 3:
			if (jeton3.getRecto() == true) {
				System.out.println( "Choisissez la ligne et la colonne du district à pivoter (LigneColonne) : " );
	            int p = scanner.nextInt();

				System.out.println( "Choisissez l'orientation du mur : " );
	            int nouveauMur = scanner.nextInt();

				jeton3.actionRecto(plateau, p/10, p%10, nouveauMur);
			}
			
			else {		
				System.out.println( "Choisissez la ligne et la colonne du 1er district à échanger (LigneColonne) : " );
	            int p1 = scanner.nextInt();

				System.out.println( "Choisissez la ligne et la colonne du 2nd district à échanger (LigneColonne) : " );
	            int p2 = scanner.nextInt();

				jeton3.actionVerso(plateau, p1/10, p1%10, p2/10, p2%10);
			}
			listJetons.remove(listJetons.indexOf(3));
			break;	
			
		case 4:
			if (jeton4.getRecto() == true) {
				System.out.println( "Choisissez la ligne et la colonne du district à pivoter (LigneColonne) : " );
	            int p = scanner.nextInt();

				System.out.println( "Choisissez l'orientation du mur : " );
	            int nouveauMur = scanner.nextInt();

				jeton4.actionRecto(plateau, p/10, p%10, nouveauMur);
			}
			
			else {				
				System.out.println( "Choisissez l'enquêteur à déplacer d'une case :\n1 : Sherlock\n2 : Watson\n3: Tobi\n" );
	            int enq = scanner.nextInt();

				jeton1.actionVerso(listEnqueteurs.get(enq-1),1);
			}
			listJetons.remove(listJetons.indexOf(4));
			break;
	} // fin du switch
	
}
	
	
public void actionJack (ArrayList<Integer> listJetons, Jeton1 jeton1, Jeton2 jeton2, Jeton3 jeton3, Jeton4 jeton4,
		int jetonChoisi, Scanner scanner, int k, int i, LinkedList<Alibis> pile, Enqueteurs Sherlock, Enqueteurs Watson, Enqueteurs Tobi,
		JoueurEnqueteur J1, JoueurJack J2, ArrayList<Enqueteurs> listEnqueteurs) {
// Choix du jeton
	System.out.print( "\nMrJack, choisissez un jeton parmi ");
	for (k = 0; k < listJetons.size() -1; k++) {
		System.out.print(listJetons.get(k) + ", ");
	}
	if(listJetons.size() > 1) {
		System.out.print(listJetons.get(listJetons.size()-1) +" : \n");
	}

	afficheNomActions(listJetons, jeton1,jeton2,jeton3,jeton4);
    jetonChoisi = scanner.nextInt();
     	
// Action du jeton
	switch (jetonChoisi) {
		case 1:
			if (jeton1.getRecto() == true) {
				jeton1.actionRecto(pile);
				System.out.println(jeton1.actionRecto(pile).getNom() + " est innocent ! Il reste "+ J1.getSuspects().size() + " suspects.");
				J1.remove(jeton1.actionRecto(pile).getNom());
			}
			
			else {
				System.out.println("De combien de cases voulez-vous faire avancer Sherlock ?");
				int nbCases = scanner.nextInt();
				jeton2.actionRecto(Watson,nbCases);
				System.out.println("Sherlock avance de " + nbCases + " cases");
			}
			listJetons.remove(listJetons.indexOf(1));
			break;

		case 2:
			if (jeton2.getRecto() == true) {
				System.out.println("De combien de cases voulez-vous faire avancer Watson ?");
				int nbCases = scanner.nextInt();
				jeton2.actionRecto(Watson,nbCases);
				System.out.println("Watson avance de " + nbCases + " cases");
			}
		
			else {
				System.out.println("De combien de cases voulez-vous faire avancer Tobi ?");
				int nbCases = scanner.nextInt();
				jeton2.actionVerso(Tobi,nbCases);
				System.out.println("Tobi avance de " + nbCases +" cases");
			}
			listJetons.remove(listJetons.indexOf(2));
			break;						
		
		case 3:
			if (jeton3.getRecto() == true) {
				System.out.println( "Choisissez la ligne et la colonne du district à pivoter (LigneColonne) : " );
	            int p = scanner.nextInt();

				System.out.println( "Choisissez l'orientation du mur : " );
	            int nouveauMur = scanner.nextInt();

				jeton3.actionRecto(plateau, p/10, p%10, nouveauMur);
			}
			
			else {				
				System.out.println( "Choisissez la ligne et la colonne du 1er district à échanger (LigneColonne) : " );
	            int p1 = scanner.nextInt();

				System.out.println( "Choisissez la ligne et la colonne du 2nd district à échanger (LigneColonne) : " );
	            int p2 = scanner.nextInt();

				jeton3.actionVerso(plateau, p1/10, p1%10, p2/10, p2%10);
			}
			listJetons.remove(listJetons.indexOf(3));
			break;	
			
		case 4:
			if (jeton4.getRecto() == true) {
				System.out.println( "Choisissez la ligne et la colonne du district à pivoter (LigneColonne) : " );
	            int p = scanner.nextInt();

				System.out.println( "Choisissez l'orientation du mur : " );
	            int nouveauMur = scanner.nextInt();

				jeton4.actionRecto(plateau, p/10, p%10, nouveauMur);
			}
			
			else {				
				System.out.println( "Choisissez l'enquêteur à déplacer :\n1 : Sherlock\n2 : Watson\n3: Tobi\n" );
	            int enq = scanner.nextInt();
	            
				System.out.println( "De combien de cases ? 0 ou 1 \n" );
	            int nbCases = scanner.nextInt();
				jeton1.actionVerso(listEnqueteurs.get(enq-1),nbCases);

			}
			listJetons.remove(listJetons.indexOf(4));
			break;
	} // fin du switch
	
}
	
	public List<String> appelATemoins(ArrayList<Enqueteurs> listEnqueteurs, JoueurEnqueteur J1, JoueurJack J2, List<District> lesDistricts) {
		List<String> visibles = new ArrayList<String>();
		int j;			// Ligne à vérifier
		for (int i = 0 ; i < 3 ; i++) {  // Itération sur chaque enqueteur
			switch (listEnqueteurs.get(i).getPosition()) { 		// Switch selon la position de chaque enqueteur
			
				// Lorsque l'enqueteur se trouve à droite du plateau :
				case 0: case 1: case 2:
					int h = listEnqueteurs.get(i).getPosition(); 					// On stocke la colonne de l'enqueteur
					if (plateau[0][h].getMur() != 0) {
						if (!visibles.contains(plateau[0][h].getSuspect())) { 		// On vérifie que le district n'ait pas déjà été ajouté
							visibles.add(plateau[0][h].getSuspect());
						}
						for (j = 0 ; j < 2 ; j++) {									// Parcourt les lignes du plateau
							if (plateau[j][h].getMur() != 2 && plateau[j+1][h].getMur() != 0) {
								if (!visibles.contains(plateau[j+1][h].getSuspect())) {
									visibles.add(plateau[j+1][h].getSuspect());
								}
							}
							else {
								break;
							}
						}
					}
					else {
						break;
					}
					break;
					
					
				// Lorsque l'enqueteur se trouve à droite du plateau :
				case 3: case 4: case 5:
					int d = listEnqueteurs.get(i).getPosition()-3; 					// On stocke la ligne de l'enqueteur
					if (plateau[d][2].getMur() != 1) {
						if (!visibles.contains(plateau[d][2].getSuspect())) {
							visibles.add(plateau[d][2].getSuspect());
						}
						for (j = 2 ; j > 0 ; j--) {									// Parcourt les colonnes du plateau de la droite vers la gauche
							if (plateau[d][j].getMur() != 3 && plateau[d][j-1].getMur() != 1) {
								if (!visibles.contains(plateau[d][j-1].getSuspect())) {
									visibles.add(plateau[d][j-1].getSuspect());
								}
							}
							else {
								break;
							}
						}
					}
					else {
						break;
					}
					break;					
					
				// Lorsque l'enqueteur se trouve en bas du plateau :
				case 6: case 7: case 8:
					int b = Math.abs(listEnqueteurs.get(i).getPosition()-8); 		// On stocke la colonne de l'enqueteur
					if (plateau[2][b].getMur() != 2) {
						if (!visibles.contains(plateau[2][b].getSuspect())) {
							visibles.add(plateau[2][b].getSuspect());
						}
						for (j = 2 ; j > 0 ; j--) {									// Parcourt les lignes du plateau du bas vers le haut
							if (plateau[j][b].getMur() != 0 && plateau[j-1][b].getMur() != 2) {
								if (!visibles.contains(plateau[j-1][b].getSuspect())) {
									visibles.add(plateau[j-1][b].getSuspect());
								}
							}
							else {
								break;
							}
						}
					}
					else {
						break;
					}
					break;
					
				// Lorsque l'enqueteur se trouve à gauche du plateau :
				case 9: case 10: case 11:
					int g = Math.abs(listEnqueteurs.get(i).getPosition()-11); 		// On stocke la ligne de l'enqueteur
					if (plateau[g][0].getMur() != 3) {
						if (!visibles.contains(plateau[g][0].getSuspect())) {
							visibles.add(plateau[g][0].getSuspect());
						}
						for (j = 0 ; j < 2 ; j++) {									// Parcourt les colonnes du plateau de la gauche vers la droite
							if (plateau[g][j].getMur() != 1 && plateau[g][j+1].getMur() != 3) {
								if (!visibles.contains(plateau[g][j+1].getSuspect())) {
									visibles.add(plateau[g][j+1].getSuspect());
								}
							}
							else {
								break;
							}
						}
					}
					else {
						break;
					}
					break;
			} 	// fin du switch
		}
		if (visibles.contains(J2.getCoupable())) {
			System.out.println("Jack est visible ! \n");
			for (int p = 0 ; p < lesDistricts.size() ; p++) {
				if (!visibles.contains(lesDistricts.get(p).getSuspect())) {
					String a = lesDistricts.get(p).getSuspect(); 		// Nom du district à retourner
					for (int m = 0; m<3; m++) {
						for (int n = 0; n<3; n++) {
							if (a == plateau[m][n].getSuspect()) {
								plateau[m][n].retourner();
							}
						}
					}
				}
			}
			
		}
		else {
			System.out.println("Jack est invisible ! \n");
			for (int p = 0 ; p < lesDistricts.size() ; p++) {
				if (visibles.contains(lesDistricts.get(p).getSuspect())) {
					String a = lesDistricts.get(p).getSuspect();
					for (int m = 0; m<3; m++) {
						for (int n = 0; n<3; n++) {
							if (a == plateau[m][n].getSuspect()) {
								plateau[m][n].retourner();
							}
						}
					}
				}
			}
		}
		return visibles;
	}
	


	public void affichePlateau(District[][] plateau, ArrayList<Enqueteurs> listEnqueteurs) {
		System.out.print("Positions des enquêteurs : Sherlock " + listEnqueteurs.get(0).getPosition() +" ; Watson " +
				listEnqueteurs.get(1).getPosition() + " ; Tobi " + listEnqueteurs.get(2).getPosition() + "\n");
		
		for (int l=0; l<3; l++) {
			for (int c=0;c<3;c++) {
				District carte = this.plateau[l][c];
				if (carte.mur == 0) {
					System.out.print("   ");
				} else {
					System.out.print(" # ");
				}
			}
			System.out.println(); 	// Passe à la ligne suivante
						
			
			for (int c=0;c<3;c++) {
				District carte = this.plateau[l][c];
				// Ouest est vide si Nord = 3(230)
				if (carte.mur == 3) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
				// centre de la carte: suspect ou vide
				if (carte.vide) {
					System.out.print("+");				// Caractère des personnages innocentés
				} else {
					System.out.print(carte.id);
				}
				// Est est vide si Nord = 1(012)
				if (carte.mur == 1) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			
			System.out.println();
			for (int c=0;c<3;c++) {
				District carte = this.plateau[l][c];
				// Sud est vide si Nord = 2(301)
				if (carte.mur == 2) {
					System.out.print("   ");
				} else {
					System.out.print(" # ");
				}
			}
			System.out.println();
			
		}
	}
	
	public ArrayList<Integer> initJetons() {
		ArrayList<Integer> listJetons = new ArrayList<Integer>();
		listJetons.add(1);
		listJetons.add(2);
		listJetons.add(3);
		listJetons.add(4);

		return listJetons;
	}
	
	// Initialise les districts
	public LinkedList<District> initDistricts() {
		LinkedList<District> listDistricts = new LinkedList<>();
		listDistricts.add( new District("Inspecteur Lestrade","I"));
		listDistricts.add( new District("Miss Stealthy","S"));
		listDistricts.add( new District("Jeremy Bert", "B"));
		listDistricts.add( new District("John Pizer", "P"));
		listDistricts.add( new District("John Smith", "J"));
		listDistricts.add( new District("Joseph Lane", "L"));
		listDistricts.add( new District("Madame", "M"));
		listDistricts.add( new District("Sgt Goodley", "G"));
		listDistricts.add( new District("William Gull", "W"));
		//Collections.shuffle(listDistricts);
		return listDistricts;
	}
	
	public void afficheNomActions(ArrayList<Integer> listJetons, Jetons jeton1,Jeton2 jeton2,Jeton3 jeton3,Jeton4 jeton4) {
		for (int i = 0; i < listJetons.size(); i++) {
			switch (listJetons.get(i)) {
			case 1:
				System.out.println("1 : " + jeton1.getName());
				break;
			case 2:
				System.out.println("2 : " + jeton2.getName());
				break;
			case 3:
				System.out.println("3 : " + jeton3.getName());
				break;
			case 4:
				System.out.println("4 : " + jeton4.getName());
				break;
			}
		}
	}

}