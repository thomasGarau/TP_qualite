
import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private int argent;
    private int position;
    private int nbToursEnPrison;
    private List<Propriete> proprietes;

    public Joueur(String nom) {
        this.nom = nom;
        this.argent = 200;
        this.position = 0;
        this.nbToursEnPrison = 0;
        this.proprietes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getNbToursPrison() {
        return nbToursEnPrison;
    }

    public void resteEnPrison() {
        nbToursEnPrison--;
    }

    public void vaEnPrison() {
        nbToursEnPrison = 3;
    }

    public int getArgent() {
        return argent;
    }

    public void modifierArgent(int montant) {
        argent += montant;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Propriete> getProprietes() {
        return proprietes;
    }

    public void ajouterPropriete(Propriete propriete) {
        proprietes.add(propriete);
    }

    public String toString() {
        return nom + "(Fortune : " + argent + " euros)";
    }

}
