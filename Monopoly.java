
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	private Plateau plateau = new Plateau();;
	private List<Joueur> joueurs;
	Scanner scanner = new Scanner(System.in);

	public Monopoly() {
		joueurs = new ArrayList<Joueur>();
		System.out.print("Nom du joueur 1 : ");
		String nom = scanner.next();
		joueurs.add(new Joueur(nom));
		System.out.print("Nom du joueur 2 : ");
		nom = scanner.next();
		joueurs.add(new Joueur(nom));
	}

	public void jouerMieux() {
		int nbRounds = 0;
		Depart casDepart = new Depart();

		while (joueurs.size() != 1) {
			nbRounds++;

			System.out.println("***********************************");
			System.out.println("Round N°" + nbRounds + " :");

			for (Joueur j : joueurs) {
				if (j.getNbToursPrison() != 0) {
					j.resteEnPrison();
				} else {
					int deplacement[] = j.lancerDesDes();
					if ((j.getPosition() + (deplacement[0] + deplacement[1])) > 39) {
						casDepart.action(j);
					}
					j.setPosition((j.getPosition() + (deplacement[0] + deplacement[1])) % plateau.getNB_CASES());
					plateau.getCase(j.getPosition()).action(j);
				}

				if (j.estEnfaillite()) {
					joueurs.remove(j);
				}

			}
		}
		System.out.println("***********************************");
		System.out.println("Fin de la partie ! Le gagnant est " + joueurs.get(0));
		scanner.close();
	}

}


