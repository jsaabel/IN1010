class KnivProdusent implements Runnable{

  KnivMonitor knivMonitor;
  int antallAaLage;
  int antallLaget;

  public KnivProdusent(KnivMonitor knivMonitor, int antallAaLage){
    this.knivMonitor = knivMonitor;
    this.antallAaLage = antallAaLage;
    this.antallLaget = 0;
  }

  @Override
  public void run(){
    
    try{
      while (this.antallLaget < this.antallAaLage){
        Kniv kniven = new Kniv();
        knivMonitor.settInnKniv(kniven);
        antallLaget++;
      }
    }

    catch (InterruptedException e){
      System.out.println("KnivProdusent avbrutt.");
    }

  }
}
