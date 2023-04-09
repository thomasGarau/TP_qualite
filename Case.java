
public abstract class Case {
    private String nom;
    private static ControleurCase ctrl = new ControleurCase();

    public Case(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public ControleurCase getCtrl(){
        return this.ctrl;
    }

    public String toString() {
        return nom;
    }

    public abstract void action(Joueur j);

}
