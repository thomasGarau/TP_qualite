public class Terrain extends Propriete {
    public Terrain(String nom, int prix, int loyer){
        super(nom, prix, loyer);
    }

    @Override
    public void action(Joueur j) {
        super.action(j);
        if (this.getProprietaire() == null) {
            this.getCtrl().ctrlShowFunds(j);
            String res = this.getCtrl().ctrlAskPlayerWantToBuy(j.getNom(), this.getNom(), this.getPrix());
            if (res.equals("o")) {
                this.setProprietaire(j);
                j.modifierArgent(-this.getPrix());
                this.getCtrl().ctrlDisplayPlayerBuy(j.getNom(), this.getNom());
            }
        } else if (this.getProprietaire() != j) {
            j.modifierArgent(-this.getLoyer());
            this.getProprietaire().modifierArgent(this.getLoyer());
            this.getCtrl().ctrlDisplayPlayerPaidRent(j.getNom(), this.getLoyer(), this.getProprietaire().getNom());
        }
    }
}
