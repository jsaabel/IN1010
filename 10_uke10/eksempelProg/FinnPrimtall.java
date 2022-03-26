class FinnPrimtall {
    private static boolean erPrimtall (long x) {
        for (long i = 2;  i < x;  ++i)
            if (x%i == 0) return false;
        return true;
    }

    public static void main (String[] arg) {
        long a1 = 1_000_000_000, a2 = a1+100;
        for (long i = a1;  i <= a2;  ++i)
            if (erPrimtall(i)) System.out.print(i + " ");
        System.out.println();
    }
}
