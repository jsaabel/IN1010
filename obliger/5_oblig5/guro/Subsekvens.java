public class Subsekvens {

    final public String subsekvens;
    private int antall = 1;

    public Subsekvens(String ss) {
        subsekvens = ss;
    }

    public int hentAntall() {
        return antall;
    }

    public void endreAntall(int oekAntall) {
        antall += oekAntall;
    }

    @Override
    public String toString() {
        return ("(" + subsekvens + "," + antall+ ")");

    }

}
