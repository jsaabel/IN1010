class Kontroll{
  GUI gui;
  Modell modell;

  public Kontroll(){

    gui = new GUI(this);
    modell = new Modell();
  }
}
