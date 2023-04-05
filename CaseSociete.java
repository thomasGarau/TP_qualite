public class CaseSociete extends CaseMalus {

    public CaseSociete(String nom) {
        super(nom);
    }

    @Override
    public void action(Joueur j) {
        j.modifierArgent(10*j.lancerDesDes());
        
    }
    
}
