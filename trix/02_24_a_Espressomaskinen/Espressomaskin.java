class Espressomaskin{

  int vannmengde;
  int MAKSVANNMENGDE = 1000;

  public void lagEspresso(){

    if (vannmengde < 40){
      System.out.println("Ikke nok vann");
    }

    else {
      vannmengde -= 40;
      System.out.println("Espresso laget");
    }

  }

  public void lagLungo(){
    
    if (vannmengde < 110){
      System.out.println("Ikke nok vann");
    }

    else{
      vannmengde -= 110;
      System.out.println("Lungo laget");
    }
  }

  public void fyllVann(int ml){
    
    if (vannmengde + ml > MAKSVANNMENGDE){
      vannmengde = MAKSVANNMENGDE;
    }
    else {
      vannmengde += ml;
    }

  }
  
  public int hentVannmengde(){

    return vannmengde;
  }
}
