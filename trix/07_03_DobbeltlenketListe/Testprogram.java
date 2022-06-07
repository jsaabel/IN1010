class Testprogram{
  public static void main(String[] args) {
    DobbelLenke<Integer> dobbelLenke = new DobbelLenke<Integer>();

    int test1 = 1;
    int test2 = 2;
    int test3 = 3;

    dobbelLenke.settInn(test1);
    dobbelLenke.settInn(test2);
    dobbelLenke.settInn(test3);

    int test4 = dobbelLenke.hent(0);
    System.out.println(test4);

    for (int s : dobbelLenke){
      System.out.println(s);
    }

  }
}
