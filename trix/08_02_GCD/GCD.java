class GCD{

  public static void main(String[] args){

    int a = Integer.parseInt(args[0]); int b = Integer.parseInt(args[1]);
    System.out.println(gcd(a, b));

  }


  public static int gcd(int a, int b){

    // if (a >= b){
    //   int gammelA = a;
    //   int gammelB = b;
    //   a = gammelB;
    //   b = gammelA;
    // }

    int c = a % b;

    if (c==0){
      return b;
    }
    else {
      return gcd(b, c);
    }
  }
}
