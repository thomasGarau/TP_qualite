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

    public void ctrlAskName(int i) {
        this.ihm.askPlayerName(i);
    }

}
