
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	private Case[] plateau;
	private List<Joueur> joueurs;
	private final int NB_CASES = 40;
	Scanner scanner = new Scanner(System.in);
	private Controleur ctrl;

	public Monopoly(Controleur ctrl) {
		plateau = new Case[NB_CASES];
		joueurs = new ArrayList<Joueur>();
		System.out.print("Nom du joueur 1 : ");
		String nom = scanner.next();
		joueurs.add(new Joueur(nom));
		System.out.print("Nom du joueur 2 : ");
		nom = scanner.next();
		joueurs.add(new Joueur(nom));
		initialiserPlateau();
		this.ctrl = ctrl;
	}

	public void initialiserPlateau() {
		plateau[0] = new Depart();
		plateau[1] = new Terrain("Belleville", 60, 2);
		plateau[2] = new CaisseDeCom("Caisse communauté");
		plateau[3] = new Terrain("Rue Lecourbe", 60, 4);
		plateau[4] = new caseTaxe("Impot sur le revenu", 200);
		plateau[5] = new Gare("Gare Montparnasse", 200, 25);
		plateau[6] = new Terrain("Rue de Vaugirard", 100, 6);
		plateau[7] = new Chance("chance");
		plateau[8] = new Terrain("Rue de Courcelles", 100, 6);
		plateau[9] = new Terrain("Avenue de la république", 120, 8);
		plateau[10] = new Prison();
		plateau[11] = new Terrain("Boulevard de La Vilette", 140, 10);
		plateau[12] = new CaseSociete("Compagnie Electricité");
		plateau[13] = new Terrain("Avenue de Neuilly", 140, 10);
		plateau[14] = new Terrain("Rue de Paradis", 160, 12);
		plateau[15] = new Gare("Gare de Lyon", 200, 25);
		plateau[16] = new Terrain("Avenue Mozart", 180, 14);
		plateau[17] = new CaisseDeCom("Caisse communauté");
		plateau[18] = new Terrain("Boulevard Saint-Michel Rue Saint-Honoré", 180, 14);
		plateau[19] = new Terrain("Place Pigalle", 200, 16);
		plateau[20] = new ParcGratuit("Parc gratuit");
		plateau[21] = new Terrain("Avenue Matignon", 220, 18);
		plateau[22] = new Chance("chance");
		plateau[23] = new Terrain("Boulevard Malesherbes", 220, 18);
		plateau[24] = new Terrain("Avenue Henri-Martin", 220, 20);
		plateau[25] = new Gare("Gare du Nord", 200, 25);
		plateau[26] = new Terrain("Faubourg Saint Honoré", 240, 22);
		plateau[27] = new Terrain("Place de la Bourse", 260, 22);
		plateau[28] = new CaseSociete("Compagnie des eaux");
		plateau[29] = new Terrain("Rue la Fayette", 260, 22);
		plateau[30] = new AllerPrison();
		plateau[31] = new Terrain("Avenue de Breteuil", 280, 24);
		plateau[32] = new Terrain("Avenue Foch", 300, 24);
		plateau[33] = new CaisseDeCom("Caisse communauté");
		plateau[34] = new Terrain("Boulevard des capucines", 300, 26);
		plateau[35] = new Gare("Gare Saint Lazare", 200, 25);
		plateau[36] = new Chance("chance");
		plateau[37] = new Terrain("Avenue des Champs-Élysées", 320, 28);
		plateau[38] = new caseTaxe("Taxe de luxe", 100);
		plateau[39] = new Terrain("Rue de la paix", 400, 50);
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

				if(j.estEnfaillite()){
					joueurs.remove(j);
				}

			}
		}
		System.out.println("***********************************");
		System.out.println("Fin de la partie ! Le gagnant est " + joueurs.get(0));
		scanner.close();
	}




	public void jouer() {
		int nbRounds = 0;
		boolean finDePartie = false;

		while (!finDePartie) {
			nbRounds++;
			this.ctrl.ctrlDisplayRound(nbRounds);
			for (Joueur j : joueurs) {
				this.ctrl.ctrlDisplayPlayerTurn(j.getNom());
				int nbToursPrison = j.getNbToursPrison();
				if (nbToursPrison > 0 && nbToursPrison < 3) {
					System.out.println("Il ne joue pas il est en prison!");
					j.resteEnPrison();
				} else {
					if (nbToursPrison == 3) {
						System.out.println("Il sort de prison!");
						j.sortDePrison();
					}
					int[] des = j.lancerDesDes();
					this.ctrl.ctrlDisplayDice(j.getNom(), des);
					j.setPosition(des[0] + des[1]);
					this.ctrl.ctrlDisplayPlayerCase(j.getNom(), j.getCurrentPosition(), plateau.getCase(j.getPosition()).getNom());				
					this.plateau.getCase()[j.getPosition()].action();
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
		}
	}
}
 
