public class ParcGratuit extends Case {

    public ParcGratuit(String nom) {
        super(nom);
    }

    @Override
    public void action(Joueur j) {
        this.getCtrl().ctrlDisplayPlayerInPark();
    }
    
}
