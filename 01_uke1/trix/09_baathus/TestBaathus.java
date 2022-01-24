public class TestBaathus {
    public static void main(String[] args) {

        Baathus mittBaathus = new Baathus(3);

        Baat baat1 = new Baat("Baat 1");
        Baat baat2 = new Baat("Baat 2");
        Baat baat3 = new Baat("Baat 3");
        Baat baat4 = new Baat("Baat 4");

        mittBaathus.settInn(baat1);
        mittBaathus.settInn(baat2);
        mittBaathus.settInn(baat3);
        mittBaathus.settInn(baat4);

        mittBaathus.skrivBaater();
    }
}
