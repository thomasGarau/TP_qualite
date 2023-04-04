
public class Depart extends Case {

    public Depart() {
        super("Depart");
    }

    public void action(){
        for(Joueur j :getJoueurPresent()){
            j.modifierArgent(200);
        }
    }
}

