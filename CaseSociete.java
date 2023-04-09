public class CaseSociete extends CaseMalus {

    public CaseSociete(String nom) {
        super(nom);
    }

    @Override
    public void action(Joueur j) {
        int[] des = j.lancerDesDes();
        j.modifierArgent(10* (des[0] + des[1]));
        
    }
    
}
