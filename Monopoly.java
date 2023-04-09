
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	private Plateau plateau=new Plateau();;
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
					int deplacement[]=j.lancerDesDes();
					if ((j.getPosition() + (deplacement[0]+deplacement[1])) > 39) {
						casDepart.action(j);
					}
					j.setPosition((j.getPosition() + (deplacement[0]+deplacement[1])) % plateau.getNB_CASES());
					plateau.getCase(j.getPosition()).action(j);
				}

				if(j.estEnfaillite()){
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
 * public void jouer() {
		int nbRounds = 0;
		boolean finDePartie = false;

		while (!finDePartie) {
			nbRounds++;

			System.out.println("***********************************");
			System.out.println("Round N°" + nbRounds + " :");

			for (Joueur j : joueurs) {
				System.out.println("- C'est au tour de " + j);
				int nbToursPrison = j.getNbToursPrison();
				if (nbToursPrison > 0 && nbToursPrison < 3) {
					System.out.println("Il ne joue pas il est en prison!");
					j.resteEnPrison();
				} else {
					if (nbToursPrison == 3) {
						System.out.println("Il sort de prison!");
						j.sortDePrison();
					}
					int de1 = lancerDe();
					int de2 = lancerDe();
					int totalDe = de1 + de2;
					System.out.println(j.getNom() + " lance les dés et fait " + de1 + " + " + de2 + " = " + totalDe);
					if (j.getPosition() + totalDe > NB_CASES)
						// passage case depart
						j.ajouterArgent(200);
					int positionCourante = (j.getPosition() + totalDe) % NB_CASES;
					Case c = plateau[positionCourante];
					System.out.println(j.getNom() + " tombe sur la case N° " + positionCourante + " : " + c.getNom());
					j.setPosition(positionCourante);
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
		}
	}
 */
