class Rektangel {

    double lengde;
    double bredde;

    public Rektangel (double l, double b) {
      lengde = l;
      bredde = b;  // Konstruktør
    }

    public void oekLengde (int okning) {
        lengde = lengde + okning;    // Oek lengden som angitt
    }

    public void oekBredde (int okning) {
        bredde = bredde + okning;    // Oek bredden som angitt
    }

    public double areal() {
      return lengde * bredde;
    }

    public double omkrets () {
        return 2 * lengde + 2 * bredde;   // Beregn min omkrets
    }
}
