public class Carte {
    private String text;
    private int tp;
    private int deplacement;
    private int montant;

    public Carte(String text, int tp, int deplacement, int montant){
        this.text = text;
        this.tp = tp;
        this.deplacement = deplacement;
        this.montant = montant;
    }

    public int getMontant() {
        return 0;
    }

    public int getDeplacement(){
        return deplacement;  
    }

    public int getTP() {
        return 0;
    }
}
