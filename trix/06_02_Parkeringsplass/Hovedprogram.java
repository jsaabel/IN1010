class Hovedprogram{
  public static void main(String[] args) {
    
    Parkeringsplass<Bil> bilParkeringsplass = new Parkeringsplass();
    Parkeringsplass<Motorsykkel> motorsykkelParkeringsplass = new Parkeringsplass();

    Bil bil = new Bil("HX-DR-88", 5);
    Motorsykkel motorsykkel = new Motorsykkel("HX-BS-2022", 500);

    bilParkeringsplass.settInn(bil);
    motorsykkelParkeringsplass.settInn(motorsykkel);

    bilParkeringsplass.settInn(motorsykkel);


     

  }
}
