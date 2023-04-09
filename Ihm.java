import java.util.ArrayList;

public class Ihm {
    
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

}
