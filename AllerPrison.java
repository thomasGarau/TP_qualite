package TP_QUALITE;

public class AllerPrison extends Case {

    public AllerPrison() {
        super("Aller en Prison");
    }

    public void action(){
        for(Joueur j:getJoueurPresent()){
            j.setPosition(10);
        }
    }
}

