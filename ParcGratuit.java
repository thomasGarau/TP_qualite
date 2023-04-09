public class ParcGratuit extends Case {

    public ParcGratuit(String nom) {
        super(nom);
    }

    @Override
    public void action(Joueur j) {
        System.out.println("profitez de la journee au parc");
    }
    
}
