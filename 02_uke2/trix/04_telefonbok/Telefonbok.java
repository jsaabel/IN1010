import java.util.HashMap;
import java.util.Scanner;

public class Telefonbok {
    public static void main(String[] args) {
        HashMap<String, String> telefonBok = new HashMap<String, String>();

        telefonBok.put("Arne", "22334455");
        telefonBok.put("Lisa", "95959595");
        telefonBok.put("Jonas", "40196425");
        telefonBok.put("Peder", "12345678");

        while (true) {
            String navn = null;
            Scanner in = new Scanner(System.in);
            System.out.print("Oppgi navn: ");
            navn = in.nextLine();

            String nummer = telefonBok.get(navn);

            if (nummer == null) {
                System.out.println("Fant ikke dette navnet!");
            }

            else {
                System.out.println("Nummeret til " + navn + " er " + nummer + ".");
            }


        }

    }
}
