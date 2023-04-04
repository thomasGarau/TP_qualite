public class Chance extends Case {
    private int montant;
    private static final int MONTANT_MAX = 100;

    public Chance() {
        super("Chance");
        montant = (int) (Math.random() * MONTANT_MAX - Math.random() * MONTANT_MAX) + 1;
    }

    public int getMontant() {
        return montant;
    }
}
