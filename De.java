public class De {
    private int nbfaces=6;

    public int lancerDe(){
        return (int) (Math.random() * nbfaces) + 1;
    }
}
