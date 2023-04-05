public class CaseMalus extends Case {
    private int montant;
    public CaseMalus(String nom, int montant) {
        super(nom);
        this.montant = montant;
    }

    @Override
    public void action(Joueur j) {
        j.modifierArgent(this.montant);
    }
    
}
