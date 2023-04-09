
public class AllerPrison extends Case {

    public AllerPrison() {
        super("Aller en Prison");
    }

    public void action(Joueur j){
        j.setPosition(10);
        j.vaEnPrison();
        this.getCtrl().ctrlDisplayPlayerGoInJail(j.getNom());
    }
}

