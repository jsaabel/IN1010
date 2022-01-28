import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hovedprogram {
    public static void main(String[] args) throws FileNotFoundException {
        
        Dataklynge saga = new Dataklynge("saga");
        saga.opprettRack();

        File inputFile = new File(args[0]);

        Scanner in = new Scanner(inputFile);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(" ");

            int antallNoder = Integer.parseInt(parts[0]);
            int antallProsessorer = Integer.parseInt(parts[1]);
            int minne = Integer.parseInt(parts[2]);

            if (antallProsessorer > 16 || minne > 4096) {
                System.out.println("Programmet avsluttes pga feil i oppgitt fil. "
                        + "Vaer obs paa at maks antall prosessorer er 16, og maks minne er 4096GB.");
                throw new IllegalArgumentException("Se feilmelding ovenfor.");
            }
         
            for (int i = 0; i < antallNoder; i++) {
                Node node = new Node(antallProsessorer, minne);
                saga.leggInnNode(node); 
            }
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
