import java.util.Scanner;

public class Volume2
{
    public static void main(String[] args)
    {
        // read price per pack
        Scanner in = new Scanner(System.in);

        // input prompt 1
        System.out.print("Input price per pack: ");
        float pricePerPack = in.nextFloat();

        // input prompt 2
        System.out.print("Input volume per can: ");
        float volumePerCan = in.nextFloat();

        // compute pack volume
        final int CANSPERPACK = 6;
        float packVolume = CANSPERPACK * volumePerCan;

        // compute price per liter
        float pricePerLiter = packVolume / pricePerPack;
        System.out.printf("Price per liter: %.2f\n", pricePerLiter);
    }
}
