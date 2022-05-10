
  class KlokkeTraad implements Runnable{

    private Kontroll kontroll;

    public KlokkeTraad(Kontroll kontroll){

      this.kontroll = kontroll;
    }

    @Override
    public void run(){

      try{
        while (kontroll.spillErAktiv()){
          Thread.sleep(1000);
          kontroll.oppdater();
        }
      }

      catch (InterruptedException e){
        System.out.println("KlokkeTraad avbrutt.");
      }
    }
  }
