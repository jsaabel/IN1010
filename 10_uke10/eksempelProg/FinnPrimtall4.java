class FinnPrimtall4 {
    public static void main (String[] arg) {
	long a1 = 1_000_000_000;
	Thread t1 = new Thread(new Leter(a1, a1+25));
	Thread t2 = new Thread(new Leter(a1+26, a1+50));
	Thread t3 = new Thread(new Leter(a1+51, a1+75));
	Thread t4 = new Thread(new Leter(a1+76, a1+100));
	t1.start();  t2.start();  t3.start();  t4.start();
    }
}

class Leter implements Runnable {
    long fra, til;

    Leter (long v1, long v2) {
	fra = v1;  til = v2;
    }

    private static boolean erPrimtall (long x) {
	for (long i = 2;  i < x;  ++i)
	    if (x%i == 0) return false;
	return true;
    }

    @Override
    public void run () {
	for (long i = fra;  i <= til;  ++i)
	    if (erPrimtall(i))
		System.out.print(i + " ");
    }
}
