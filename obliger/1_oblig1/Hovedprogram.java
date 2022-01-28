public class Hovedprogram {
    public static void main(String[] args) {
        
        Dataklynge saga = new Dataklynge("saga");
        
        saga.opprettRack();
        for (int i = 0; i < 450; i++) {
            Node node = new Node(4, 512);
            saga.leggInnNode(node); 
        }
  
        for (int i = 0; i < 16; i++) {
            Node node = new Node(8, 1024);
            saga.leggInnNode(node); 
        }

        int noder128 = saga.noderMedNokMinne(128);
        int noder512 = saga.noderMedNokMinne(512);
        int noder1024 = saga.noderMedNokMinne(1024);

        System.out.println("Noder med minst 128 GB: " + noder128);
        System.out.println("Noder med minst 512 GB: " + noder512);
        System.out.println("Noder med minst 1024 GB: " + noder1024);
        
        int antProsessorer = saga.antallProsessorer();

        System.out.println("Antall prosessorer: " + antProsessorer);

        int antallRack = saga.antallRacks();

        System.out.println("Antall racks: " + antallRack);



    }
}    
