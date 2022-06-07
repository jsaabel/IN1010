class SaksProdusent implements Runnable{

  KnivMonitor knivMonitor;
  SaksMonitor saksMonitor;

  public SaksProdusent(KnivMonitor knivMonitor, SaksMonitor saksMonitor){
    this.knivMonitor = knivMonitor;
    this.saksMonitor = saksMonitor;
  }

  @Override
  public void run(){
    try{
      Kniv[] knivene = knivMonitor.hentToKniver();
      Saks saksen = new Saks(knivene[0], knivene[1]);
      saksMonitor.settInnSaks(saksen);
    }

    catch (InterruptedException e){
      System.out.println("SaksProdusent avbrutt.");
    }
  }

}
