public class Counter {

    private int value;

    public Counter() { // constructor!    
        value = 0;
    }

    public void count() {
        value += 1;
    }

    public int getValue() {
        return value;
    }
}
