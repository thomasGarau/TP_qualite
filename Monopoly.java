
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	private Plateau plateau = new Plateau();;
	private List<Joueur> joueurs;
	Scanner scanner = new Scanner(System.in);
	private Controleur ctrl;
	public int nbRounds = 0;

	public Monopoly(Controleur ctrl) {
		joueurs = new ArrayList<Joueur>();
		System.out.print("Nom du joueur 1 : ");
		String nom = scanner.next();
		joueurs.add(new Joueur(nom));
		System.out.print("Nom du joueur 2 : ");
		nom = scanner.next();
		joueurs.add(new Joueur(nom));
	}

	public void jouerMieux() {
		while (joueurs.size() != 1) {
			this.nbRounds++;
			this.ctrl.ctrlDisplayRound(this.nbRounds);
			for (Joueur j : joueurs) {
				 if (j.getNbToursPrison() != -1) {
					if (j.getNbToursPrison() == 0) {
						System.out.println("Il sort de prison!");
						j.sortDePrison();
					}else{
						System.out.println("Il ne joue pas il est en prison!");
						j.resteEnPrison();
					}
				} else {
					int[] des = j.lancerDesDes();
					this.ctrl.ctrlDisplayDice(j.getNom(), des);
					if ((j.getPosition() + (des[0] + des[1])) > 39) {
						this.plateau.getCase(0).action(j);
					}
					j.setPosition((j.getPosition() + (des[0] + des[1])) % plateau.getNB_CASES());
					this.ctrl.ctrlDisplayPlayerPosition(j.getNom(), j.getPosition(), plateau.getCase(j.getPosition()).getNom());
					this.plateau.getCase(j.getPosition()).action(j);
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






	
		/*
		if (c instanceof Terrain) {
			Propriete p = (Propriete) c;
			if (p.getProprietaire() == null) {
				System.out.print(j.getNom() + " veut-il acheter la " + p.getNom() + " (" + p.getPrix()
						+ " euros) (o-n)? ");
				String reponse = scanner.nextLine().toLowerCase();
				if (reponse.equals("o")) {
					p.setProprietaire(j);
					j.retirerArgent(p.getPrix());
					System.out.println(j + " a acheté " + p.getNom());
				}
			} else if (p.getProprietaire() != j) {
				j.retirerArgent(p.getLoyer());
				p.getProprietaire().ajouterArgent(p.getLoyer());
				System.out.println(
						j.getNom() + " a payé " + p.getLoyer() + " à " + p.getProprietaire().getNom());
			}
		} else if (c instanceof Chance) {
			Chance chance = (Chance) c;
			System.out.print("Tirage d'une carte chance : ");
			int montant = chance.getMontant();
			if (montant > 0) {
				j.ajouterArgent(montant);
				System.out.println(j.getNom() + " reçoit " + montant + " euros");
			} else {
				j.retirerArgent(-montant);
				System.out.println(j.getNom() + " doit payer " + (-montant) + " euros");
			}
		} else if (c instanceof AllerPrison) {
			j.setPosition(10);
			j.vaEnPrison();
			System.out.println(j.getNom() + " va en prison !");

		} else if (c instanceof Depart) {
			j.ajouterArgent(200);
			System.out.println(j.getNom() + " passe par la case départ et reçoit 200 euros");
		}
		if (j.getArgent() < 0) {
			System.out.println(j + " n'a plus d'argent et quitte le jeu !");
			joueurs.remove(j);
			break;
		}

	}
}
*/
