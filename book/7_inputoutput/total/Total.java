import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Total {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("input.txt");
        Scanner in = new Scanner(inputFile);

        int total = 0;

        while (in.hasNextInt()) {
            int value = in.nextInt();
            total += value;
        }
        
        System.out.println(total);
    }
}
