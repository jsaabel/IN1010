public class Baathus {
    private Baat[] baathus;

    public Baathus(int antallPlasser) {
        baathus = new Baat[antallPlasser];
    }

    public void settInn(Baat enBaat) {
        boolean sattInn = false;
        int teller = 0;

        while (teller < baathus.length && !sattInn) {
            if (baathus[teller] == null) {
                baathus[teller] = enBaat;
                sattInn = true;
            }

            teller ++;
        }

        if (!sattInn) {
            System.out.println("Det er ikke plass til flere baater!");
        }

    }

    public void skrivBaater() {
        for (Baat baat: baathus) {
            String description = baat.hentInfo();
            System.out.println(description);
        }
    }

}
