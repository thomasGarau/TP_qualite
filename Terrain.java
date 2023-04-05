public class Terrain extends Propriete {
    public Terrain(String nom, int prix, int loyer){
        super(nom, prix, loyer);
    }

    @Override
    public void action(Joueur j) {
        super.action(j);
    }
}
