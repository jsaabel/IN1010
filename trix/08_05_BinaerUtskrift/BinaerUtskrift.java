class BinaerUtskrift{

  String res;

  public static void main(String[] args){
    utskrift(Integer.parseInt(args[0]));

  }

  public static void utskrift(int n){

    if (n == 0){
      System.out.print(0);
    }
    else{
      if (n > 1){
        utskrift(n/2);
      }

      System.out.print(n%2);

    }
      


  }

}
