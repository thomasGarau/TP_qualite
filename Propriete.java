public class Propriete extends Case {
    private Joueur proprietaire;
    private int prix;
    private int loyer;

    public Propriete(String nom, int prix, int loyer) {
        super(nom);
        this.prix = prix;
        this.loyer = loyer;
        this.proprietaire = null;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public int getPrix() {
        return prix;
    }

    public int getLoyer() {
        return loyer;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public boolean estAchetable() {
        return proprietaire == null;
    }

    public void action(Joueur j) {
        if (proprietaire != null) {
            if(!(j.equals(proprietaire))){
                j.modifierArgent(-loyer);
                proprietaire.modifierArgent(loyer);
            }
        }

    }

}
