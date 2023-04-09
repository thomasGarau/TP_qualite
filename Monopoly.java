
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monopoly {
	private Plateau plateau = new Plateau();;
	private List<Joueur> joueurs;
	Scanner scanner = new Scanner(System.in);
	private Controleur ctrl;
	private int nbRounds = 0;
	private boolean hasWin = false;

	public Monopoly(Controleur ctrl) {
		joueurs = new ArrayList<Joueur>();
		System.out.print("Nom du joueur 1 : ");
		String nom = scanner.next();
		joueurs.add(new Joueur(nom));
		System.out.print("Nom du joueur 2 : ");
		nom = scanner.next();
		joueurs.add(new Joueur(nom));
	}

	public void initJoueur(){}
	public void hasWin(boolean win){
		this.hasWin = true;
	}

	public void jouerMieux() {
		while (this.hasWin != true) {
			this.nbRounds++;
			this.ctrl.ctrlDisplayRound(this.nbRounds);
			for (Joueur j : joueurs) {
				if (j.getNbToursPrison() != -1) {
					if (j.getNbToursPrison() == 0) {
						this.ctrl.ctrlDisplayLeaveJail();
						j.sortDePrison();
					}else{
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
					this.ctrl.ctrlDisplayPlayerPosition(j.getNom(), j.getPosition(), plateau.getCase(j.getPosition()).getNom());
					this.plateau.getCase(j.getPosition()).action(j);
				}
				if (j.estEnfaillite()) {	
					this.ctrl.ctrlDisplayPlayerLooseGame(j.getNom());
					joueurs.remove(j);
				}
				if(joueurs.size() < 2){
					hasWin(true);
				}
			}
		}
		this.ctrl.ctrlDisplayWin(joueurs.get(0).getNom());
		scanner.close();
	}

}
