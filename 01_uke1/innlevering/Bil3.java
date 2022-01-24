public class Bil3 {
    private String bilNummer;

    public Bil3(String etBilNummer) {
        bilNummer = etBilNummer;
    }

    public void skrivUt() {
        System.out.println("Jeg er en bil med bilnummer " + bilNummer);
    }

    public String hentNummer() {
        return bilNummer;
    }
}
