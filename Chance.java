public class Chance extends CasePioche{

    public Chance(String nom){
        super(nom);
    }

    @Override
    public void action(Joueur j) {
        this.getCtrl().ctrlDisplayPlayerDrawLuck();
        int montant= (int) (Math.random() * this.getMontant() -  Math.random() * this.getMontant()) +1;
        j.modifierArgent(montant);
    }

}