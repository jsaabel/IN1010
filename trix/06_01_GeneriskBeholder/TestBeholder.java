class TestBeholder{
  public static void main(String[] args) {

    Beholder<Sirkel> testBeholder = new Beholder();
    Sirkel test = new Sirkel();
    testBeholder.settInn(test);
    Kvadrat test2 = new Kvadrat();
    testBeholder.settInn(test2);
    
  }
}
