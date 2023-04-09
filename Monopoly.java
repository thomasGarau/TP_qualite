import java.util.ArrayList;
import java.util.List;

public class Monopoly {
	private Plateau plateau = new Plateau();;
	private List<Joueur> joueurs = new ArrayList<>();
	//permet de conserver en mémoire les joueur devant être supprimer pour ne pas avoir à les supprimer
	//dans la boucle for j in joueur ce qui provoquerais une erreur
	private List<Joueur> joueursEnFaillite = new ArrayList<>();
	private Controleur ctrl;
	private int nbRounds = 0;
	private boolean hasWin = false;

	public Monopoly(Controleur ctrl) {
		this.ctrl = ctrl;
		initJoueur(2);
	}

	public void initJoueur(int nbJoueur) {
		for (int i = 0; i < nbJoueur; i++) {
			String res = this.ctrl.ctrlAskName(i + 1);
			this.joueurs.add(new Joueur(res));
		}

	}

	public void hasWin(boolean win) {
		this.hasWin = true;
	}

	public void jouerMieux() {
		while (this.hasWin != true) {
			this.nbRounds++;
			this.ctrl.ctrlDisplayRound(this.nbRounds);
			for (Joueur j : joueurs) {
				//si la partie est finie alors on quite la boucle en executant jamais le code
				if(!hasWin){
					if (j.getNbToursPrison() != -1) {
						if (j.getNbToursPrison() == 0) {
							this.ctrl.ctrlDisplayLeaveJail();
							j.sortDePrison();
						} else {
							this.ctrl.ctrlDisplayIsInJail();
							j.resteEnPrison();
						}
					} else {
						int[] des = j.lancerDesDes();
						this.ctrl.ctrlDisplayDice(j.getNom(), des);
						if ((j.getPosition() + (des[0] + des[1])) > 39) {
							this.plateau.getCase(0).action(j);
						}
						j.setPosition((j.getPosition() + (des[0] + des[1])) % plateau.getNB_CASES());
						this.ctrl.ctrlDisplayPlayerPosition(j.getNom(), j.getPosition(),
								plateau.getCase(j.getPosition()).getNom());
						this.plateau.getCase(j.getPosition()).action(j);
					}
					//verifie si le joueur à encore de l'argent
					//si jamais il n'en à plus ajoute le joueur à la liste teporaire joueursEnFaillite pour pouvoir
					//le supprimer à la fin de la boucle for
					if (j.estEnfaillite()) {
						this.ctrl.ctrlDisplayPlayerLooseGame(j.getNom());
						joueursEnFaillite.add(j);
						//si jamais il n'y a plus qu'un joueur en jeu alors on set hasWin à true pour break le jeu
						if((joueurs.size() - joueursEnFaillite.size()) < 2){
							this.hasWin = true;
						} 
					}
				}
			}
			if(joueursEnFaillite != null){
				this.removeJoueurEnFaillite();
			}
		}
		this.ctrl.ctrlDisplayWin(joueurs.get(0).getNom());
	}

	private void removeJoueurEnFaillite(){
		for(Joueur jFaillite : joueursEnFaillite){
			joueurs.remove(jFaillite);
		}
		joueursEnFaillite.clear();
	}
}
