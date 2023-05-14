public class Chance extends CasePioche{

    public Chance(String nom){
        super(nom);
    }

    @Override
    public void action(Joueur j) {
        int montant= (int) (Math.random() * this.getMontant() -  Math.random() * this.getMontant()) +1;
        this.getCtrl().ctrlDisplayPlayerDrawLuck(j.getNom(), montant);
        j.modifierArgent(montant);
    }

}