import java.util.ArrayList;
import java.util.List;

public abstract class Case {
    private String nom;
    private List<Joueur> joueurs;

    public Case(String nom) {
        this.nom = nom;
        joueurs=new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Joueur> getJoueurPresent(){
        return joueurs;
    }

    public String toString() {
        return nom;
    }

    public abstract void action();

}
