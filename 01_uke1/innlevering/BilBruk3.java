public class BilBruk3 {
    public static void main(String[] args) {
        Bil3 minBil3 = new Bil3("EV-777");

        Person minPerson = new Person(minBil3);
        minPerson.skrivUtBilnummer();
    }
}
