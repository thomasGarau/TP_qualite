import java.util.ArrayList;
import java.util.List;

public class Monopoly {
	private Plateau plateau = new Plateau();;
	private List<Joueur> joueurs = new ArrayList<>();
	// permet de conserver en mémoire les joueur devant être supprimer pour ne pas
	// avoir à les supprimer
	// dans la boucle for j in joueur ce qui provoquerais une erreur
	private List<Joueur> joueursEnFaillite = new ArrayList<>();
	private Controleur ctrl;
	private int nbRounds = 0;
	private boolean hasWin = false;

	public Monopoly(Controleur ctrl) {
		this.ctrl = ctrl;
		initJoueur(2);
	}

	//initilalise la liste des joueurs
	public void initJoueur(int nbJoueur) {
		for (int i = 0; i < nbJoueur; i++) {
			String res = this.ctrl.ctrlAskName(i + 1);
			this.joueurs.add(new Joueur(res));
		}

	}

	//permet de supprimer les joueur en faillite de la liste des joueurs
	private void removeJoueurEnFaillite(){
		for(Joueur jFaillite : joueursEnFaillite){
			joueurs.remove(jFaillite);
		}
		joueursEnFaillite.clear();
	}

	public void hasWin(boolean win) {
		this.hasWin = true;
	}

	public void jouerMieux() {
		while (this.hasWin != true) {
			this.nbRounds++;
			//affiche le nouveau tour
			this.ctrl.ctrlDisplayRound(this.nbRounds);
			for (Joueur j : joueurs) {
				//si la partie est finie alors on quite la boucle en executant jamais le code
				if(!hasWin){
					//verifie si le joueur ce trouve actuellement en prison
					if (j.getNbToursPrison() != -1) {
						//si oui verifie si il doit en sortir
						if (j.getNbToursPrison() == 0) {
							this.ctrl.ctrlDisplayLeaveJail();
							j.sortDePrison();
						//si non retire un tour au temps qu'il doit passer en prison
						} else {
							this.ctrl.ctrlDisplayIsInJail();
							j.resteEnPrison();
						}
					} else {
						int[] des = j.lancerDesDes();
						//affiche le lancer de des
						this.ctrl.ctrlDisplayDice(j.getNom(), des);
						//si jamais le joueur à fait un tour complet du plateau alors on lui ajoute les 200€
						if ((j.getPosition() + (des[0] + des[1])) > this.plateau.getNbCase() -1) {
							//on effectue l'action correspondant à la case sur laquel le joueur atterit
							this.plateau.getCase(0).action(j);
						}
						//on ajoute à la position du joueur sont lancer de des modulo la taille du plateau
						j.setPosition((j.getPosition() + (des[0] + des[1])) % this.plateau.getNbCase());
						this.ctrl.ctrlDisplayPlayerPosition(j.getNom(), j.getPosition(),plateau.getCase(j.getPosition()).getNom());
						this.plateau.getCase(j.getPosition()).action(j);
					}
					// verifie si le joueur à encore de l'argent
					// si jamais il n'en à plus ajoute le joueur à la liste teporaire
					// joueursEnFaillite pour pouvoir
					// le supprimer à la fin de la boucle for
					if (j.estEnfaillite()) {
						this.ctrl.ctrlDisplayPlayerLooseGame(j.getNom());
						joueursEnFaillite.add(j);
						// si jamais il n'y a plus qu'un joueur en jeu alors on set hasWin à true pour
						// break le jeu
						if ((joueurs.size() - joueursEnFaillite.size()) < 2) {
							this.hasWin = true;
						}
					}
				}
			}
			if (joueursEnFaillite != null) {
				this.removeJoueurEnFaillite();
			}
		}
		this.ctrl.ctrlDisplayWin(joueurs.get(0).getNom());
	}
}
