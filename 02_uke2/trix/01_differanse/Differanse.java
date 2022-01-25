import java.util.Scanner;

public class Differanse {
    public static void main (String[] args) {
        int tallEn, tallTo, diff;

        Scanner in = new Scanner(System.in);

        System.out.print("Oppgi det foerste tallet: ");
        tallEn = in.nextInt();

        System.out.print("\nOppgi det andre tallet: ");
        tallTo = in.nextInt();

        diff = tallEn - tallTo;

        if (diff < 0) {
            diff = - diff;
        }

        System.out.println("Differansen mellom tallene er " + diff);



    }
}
