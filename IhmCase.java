import java.util.Scanner;

public class IhmCase {
    Scanner scanner = new Scanner(System.in);

    public String askPlayerWantToBuy(String jNom, String pNom, int pPrix){
        System.out.print(jNom + " veut-il acheter la " + pNom + " (" + pPrix + " euros) (o-n)? ");
        return scanner.nextLine().toLowerCase();
    }

    public void displayPlayerBuy(String joueur, String propriete){
        System.out.println(joueur + " a acheté " + propriete);
    }

    public void displayPlayerPaidRent(String jNom, int loyer, String pNom){
        System.out.println(jNom + " a payé " + loyer + " à " + pNom);
    }

    public void displayPlayerDrawLuck(){
        System.out.print("Tirage d'une carte chance : ");
    }

    public void displayLooseMoney(String joueur, int montant){
        System.out.println(joueur+ " doit payer " + montant + " euros");
    }

    public void displayEarnMoney(String joueur, int montant){
        System.out.println(joueur + " reçoit " + montant + " euros");
    }

    public void displayPlayerGoInJail(String joueur){
        System.out.println(joueur + " va en prison !");
    }

    public void displayPlayerGoesByDepart(String joueur){
        System.out.println(joueur + " passe par la case départ et reçoit 200 euros");
    }

    public void displayPlayerInPark(){
        System.out.println("profitez de la journee au parc");
    }

}
