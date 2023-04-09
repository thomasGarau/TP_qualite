import java.util.ArrayList;

public abstract class CasePioche extends Case {

    private int montant;
    private static final int MONTANT_MAX = 100;
    protected ArrayList<Carte> deck = new ArrayList<>();

    public CasePioche(String nom) {
        super(nom);
    }

    public int getMontant() {
        return montant;
    }

    public int getMontantMax(){
        return MONTANT_MAX;
    }

    public void action(Joueur j){

    }
}
