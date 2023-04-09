public class Controleur {
    private Ihm ihm;

    public Controleur(Ihm ihm){
        this.ihm = ihm;
        Monopoly mono = new Monopoly(this);
        mono.jouerMieux();
    }

    public void ctrlDisplayRound(int Rounds){
        this.ihm.displayRound(Rounds);
    }

    public void ctrlDisplayPlayerTurn(String joueur){
        this.ihm.displayPlayerTurn(joueur);
    }

    public void ctrlDisplayDice(String nom, int[] des){
        this.ihm.displayDice(nom, des);
    }

    public void ctrlDisplayPlayerPosition(String nom, int nbCase, String nomCase){
        this.ihm.displayPlayerPosition(nom, nbCase, nomCase);
    }

    public void ctrlDisplayLeaveJail(){
        this.ihm.displayLeaveJail();
    }
    
    public void ctrlDisplayIsInJail(){
        this.ihm.displayIsInJail();
    }

    public void ctrlDisplayWin(String joueur){
        this.ihm.displayWin(joueur);
    }

    public void ctrlDisplayPlayerLooseGame(String joueur){
        this.ihm.displayPlayerLooseGame(joueur);
    }

    public String ctrlAskName(int numJoueur) {
        return this.ihm.askPlayerName(numJoueur);
    }

    public void ctrlShowFunds(Joueur joueur) {
        this.ihm.showFunds(joueur);
    }

}
