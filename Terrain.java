public class Terrain extends Propriete {
    public Terrain(String nom, int prix, int loyer){
        super(nom, prix, loyer);
    }

    @Override
    public void action(Joueur j) {
        super.action(j);
        //si la propriété n'appartient à personne propose de l'acheter
        if (this.getProprietaire() == null) {
            //affiche la propriété sur laquel le joueurs atterit et lui demande si il souhaite l'acheter
            this.getCtrl().ctrlShowFunds(j);
            String res = this.getCtrl().ctrlAskPlayerWantToBuy(j.getNom(), this.getNom(), this.getPrix());
            if (res.equals("o")) {
                this.setProprietaire(j);
                //retire le prix de la propriété au solde du joueur
                j.modifierArgent(-this.getPrix());
                this.getCtrl().ctrlDisplayPlayerBuy(j.getNom(), this.getNom());
            }
        //si non fait payer au joueur le loyer au propriété de la case
        } else if (this.getProprietaire() != j) {
            j.modifierArgent(-this.getLoyer());
            this.getProprietaire().modifierArgent(this.getLoyer());
            this.getCtrl().ctrlDisplayPlayerPaidRent(j.getNom(), this.getLoyer(), this.getProprietaire().getNom());
        }
    }
}
