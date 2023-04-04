
public abstract class Case {
    private String nom;

    public Case(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return nom;
    }

    public abstract void action(Joueur j);

}
