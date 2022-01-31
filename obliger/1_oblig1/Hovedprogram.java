import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hovedprogram {
    public static void main(String[] args) throws FileNotFoundException {

        // oppretter ny dataklynge og et foerste rack        
        Dataklynge saga = new Dataklynge("saga");
        saga.opprettRack();

        /*
        Her sjekker jeg om et filnavn er oppgitt i kommandolinjen naar programmet kjoeres.
        Hvis ikke, blir brukeren bedt om aa oppgi et filnavn, som programmet saa er kjort paa.
        */

        String navnPaaInputFile = new String();

        if (args.length > 0) {
        navnPaaInputFile = args[0];
        }
        else {
        System.out.print("Oppgi filnavn: ");
        Scanner userInput = new Scanner(System.in);
        navnPaaInputFile = userInput.nextLine();
        }

        File inputFile = new File(navnPaaInputFile);
        Scanner in = new Scanner(inputFile);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(" ");

            int antallNoder = Integer.parseInt(parts[0]);
            int antallProsessorer = Integer.parseInt(parts[1]);
            int minne = Integer.parseInt(parts[2]);

            // feilmelding for illegale verdier
            if (antallProsessorer > 16 || minne > 4096) {
                System.out.println("Programmet avsluttes pga feil i oppgitt fil. "
                        + "Vaer obs paa at maks antall prosessorer er 16, og maks minne er 4096GB.");
                throw new IllegalArgumentException("Se feilmelding ovenfor.");
            }
         
            // legg til noder
            for (int i = 0; i < antallNoder; i++) {
                Node node = new Node(antallProsessorer, minne);
                saga.leggInnNode(node); 
            }
        }

        // hent og skriv ut informasjo om dataklyngen
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
