
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	private Case[] plateau;
	private List<Joueur> joueurs;
	private final int NB_CASES = 40;
	Scanner scanner = new Scanner(System.in);

	public Monopoly() {
		plateau = new Case[NB_CASES];
		joueurs = new ArrayList<Joueur>();
		System.out.print("Nom du joueur 1 : ");
		String nom = scanner.next();
		joueurs.add(new Joueur(nom));
		System.out.print("Nom du joueur 2 : ");
		nom = scanner.next();
		joueurs.add(new Joueur(nom));
		initialiserPlateau();
	}

	public void initialiserPlateau() {
		plateau[0] = new Depart();
		plateau[1] = new Propriete("Belleville", 60, 2);
		plateau[2] = new Case("Caisse communauté");
		plateau[3] = new Propriete("Rue Lecourbe", 60, 4);
		plateau[4] = new Case("Impot sur le revenu");
		plateau[5] = new Propriete("Gare Montparnasse", 200, 25);
		plateau[6] = new Propriete("Rue de Vaugirard", 100, 6);
		plateau[7] = new Chance();
		plateau[8] = new Propriete("Rue de Courcelles", 100, 6);
		plateau[9] = new Propriete("Avenue de la république", 120, 8);
		plateau[10] = new Prison();
		plateau[11] = new Propriete("Boulevard de La Vilette", 140, 10);
		plateau[12] = new Case("Compagnie Electricité");
		plateau[13] = new Propriete("Avenue de Neuilly", 140, 10);
		plateau[14] = new Propriete("Rue de Paradis", 160, 12);
		plateau[15] = new Propriete("Gare de Lyon", 200, 25);
		plateau[16] = new Propriete("Avenue Mozart", 180, 14);
		plateau[17] = new Case("Caisse communauté");
		plateau[18] = new Propriete("Boulevard Saint-Michel Rue Saint-Honoré", 180, 14);
		plateau[19] = new Propriete("Place Pigalle", 200, 16);
		plateau[20] = new Case("Parc gratuit");
		plateau[21] = new Propriete("Avenue Matignon", 220, 18);
		plateau[22] = new Chance();
		plateau[23] = new Propriete("Boulevard Malesherbes", 220, 18);
		plateau[24] = new Propriete("Avenue Henri-Martin", 220, 20);
		plateau[25] = new Propriete("Gare du Nord", 200, 25);
		plateau[26] = new Propriete("Faubourg Saint Honoré", 240, 22);
		plateau[27] = new Propriete("Place de la Bourse", 260, 22);
		plateau[28] = new Case("Compagnie des eaux");
		plateau[29] = new Propriete("Rue la Fayette", 260, 22);
		plateau[30] = new AllerPrison();
		plateau[31] = new Propriete("Avenue de Breteuil", 280, 24);
		plateau[32] = new Propriete("Avenue Foch", 300, 24);
		plateau[33] = new Case("Caisse communauté");
		plateau[34] = new Propriete("Boulevard des capucines", 300, 26);
		plateau[35] = new Propriete("Gare Saint Lazare", 200, 25);
		plateau[36] = new Chance();
		plateau[37] = new Propriete("Avenue des Champs-Élysées", 320, 28);
		plateau[38] = new Case("Taxe de luxe");
		plateau[39] = new Propriete("Rue de la paix", 400, 50);
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
					if ((j.getPosition() + j.lancerDesDes()) > 39) {
						casDepart.action(j);
					}
					j.setPosition((j.getPosition() + j.lancerDesDes()) % NB_CASES);
					plateau[j.getPosition()].action(j);
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
					if (c instanceof Propriete) {
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
