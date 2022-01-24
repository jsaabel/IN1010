public class Bil2 {
    private String bilNummer;

    public Bil2(String etBilNummer) {
        bilNummer = etBilNummer;
    }

    public void skrivUt() {
        System.out.println("Jeg er en bil med bilnummer " + bilNummer);
    }
}
