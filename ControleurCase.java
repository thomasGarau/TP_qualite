public class ControleurCase {
    private IhmCase ihm;

    public ControleurCase(){
        this.ihm = new IhmCase();
    }

    public void controleSaisie(){}

    public String ctrlAskPlayerWantToBuy(String jNom, String pNom, int pPrix){
        return this.ihm.askPlayerWantToBuy(jNom, pNom, pPrix);
    }

    public void ctrlDisplayPlayerBuy(String joueur, String propriete){
        this.ihm.displayPlayerBuy(joueur, propriete);
    }

    public void ctrlDisplayPlayerPaidRent(String jNom, int loyer, String pNom){
        this.ihm.displayPlayerPaidRent(jNom, loyer, pNom);
    }

    public void ctrlDisplayPlayerDrawLuck(String joueur, int montant){
        this.ihm.displayPlayerDrawLuck(joueur, montant);
    }

    public void ctrlDisplayEarnMoney(String joueur, int montant){
        this.ihm.displayEarnMoney(joueur, montant);
    }

    public void ctrlDisplayLooseMoney(String joueur, int montant){
        this.ihm.displayLooseMoney(joueur, montant);
    }

    public void ctrlDisplayPlayerGoInJail(String joueur){
        this.ihm.displayPlayerGoInJail(joueur);
    }

    public void ctrlDisplayPlayerGoesByDepart(String joueur){
        this.ihm.displayPlayerGoesByDepart(joueur);
    }

    public void ctrlDisplayPlayerInPark(){
        this.ihm.displayPlayerInPark();
    }

    public void ctrlShowFunds(Joueur joueur) {
        this.ihm.showFunds(joueur);
    }
}
