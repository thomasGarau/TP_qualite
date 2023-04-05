public class caseTaxe extends CaseMalus{
    private int montant;
    public caseTaxe(String nom,int montant) {
        super(nom);
        this.montant=montant;
    }
   
    @Override
    public void action(Joueur j) {
        j.modifierArgent(-montant);
    }
    
}
