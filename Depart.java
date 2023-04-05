public class Depart extends Case {

    public Depart() {
        super("Depart");
    }

    public void action(Joueur j){
        j.modifierArgent(200);
    }
}

