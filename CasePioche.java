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

    public void action(Joueur j){
        Carte piocher = deck.get((int) (Math.random() * deck.size()));
        
        if(piocher.getMontant() != 0){
            j.modifierArgent(piocher.getMontant());
        }
        if(piocher.getTP() != 0){
            j.setPosition(piocher.getTP());
        }else if(piocher.getDeplacement() > 0){
            j.setPosition(j.getPosition() + piocher.getDeplacement());
        }

        if(piocher.getMontant() > 0){
            this.getCtrl().ctrlDisplayEarnMoney(j.getNom(), piocher.getMontant());
        }else{
            this.getCtrl().ctrlDisplayLooseMoney(j.getNom(), piocher.getMontant());
        }
    }
}
