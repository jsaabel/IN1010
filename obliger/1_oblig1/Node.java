public class Node {
    
    private int antallCpu;
    private int minneGigabyte;

    public Node(int antCpu, int minneGb) {
        antallCpu = antCpu;
        minneGigabyte = minneGb;
    }

    public int antProsessorer() {
        return antallCpu;
    }

    public int minne() {
        return minneGigabyte;
    }

}
