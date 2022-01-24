public class HovedProgram {
    public static void main(String[] args) {
        Counter testCounter = new Counter();

        testCounter.count();
        testCounter.count();

        int result = testCounter.getValue();

        System.out.println("Counter value: " + result);
    }
}
