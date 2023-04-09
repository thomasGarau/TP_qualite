public class Controleur {
    private Ihm ihm;

    public Controleur(Ihm ihm){
        this.ihm = ihm;
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

}
