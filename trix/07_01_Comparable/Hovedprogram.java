import java.util.ArrayList;

class Hovedprogram{

  public static void main(String[] args) {

    ArrayList<Katt> katter = new ArrayList();

    Katt katt1 = new Katt("Toni", 22);
    Katt katt2 = new Katt("Chili", 3);
    Katt katt3 = new Katt("Zora", 25);

    katter.add(katt1);
    katter.add(katt2);
    katter.add(katt3);

    Katt eldst = katter.get(0);
    for (Katt k:katter){
      if (k.compareTo(eldst) > 0){
        eldst = k;
      }
    }

    System.out.println(eldst);
    
  }
}
