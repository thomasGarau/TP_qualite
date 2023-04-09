import java.util.Scanner;

public class Ihm {
    Scanner scanner = new Scanner(System.in);

    public Ihm(){
       new Controleur(this);
    }

    public void displayRound(int nbRounds){
        System.out.println("***********************************");
        System.out.println("Round N°" + nbRounds + " :");
    }

    public void displayPlayerTurn(String joueur){
        System.out.println("- C'est au tour de " + joueur);
    }

    public void displayDice(String nom, int[] des){
        System.out.println(nom + " lance les dés et fait " + des[0] + " + " + des[1] + " = " + des[0] + des[1]);
    }

    public void displayPlayerPosition(String nom, int nbCase, String nomCase){
        System.out.println(nom + " tombe sur la case N° " + nbCase + " : " + nomCase);
    }

    public void displayLeaveJail(){
        System.out.println("Il sort de prison!");
    }
    
    public void displayIsInJail(){
        System.out.println("Il ne joue pas il est en prison!");
    }

    public void displayWin(String joueur){
        System.out.println("***********************************");
		System.out.println("Fin de la partie ! Le gagnant est " + joueur);
    }

    public void displayPlayerLooseGame(String joueur){
        System.out.println(joueur + " n'a plus d'argent et quitte le jeu !");
    }

    public String askPlayerName(int numJoueur) {
        System.out.println("Le nom du joueur "+ numJoueur +" : ");
        return this.scanner.nextLine();
    }

}
