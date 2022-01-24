public class Person {

    public Bil3 bil;

    public Person(Bil3 enBil3) {
        bil = enBil3;
    }

    public void skrivUtBilnummer() {
        System.out.println("Bilnummeret til denne personen er " + bil.hentNummer());
    }
}
