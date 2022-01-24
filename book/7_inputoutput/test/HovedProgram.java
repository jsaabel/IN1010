import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class HovedProgram {
    public static void main(String[] args) throws FileNotFoundException {
        // File inputFile = new File("input.txt");
        // Scanner in = new Scanner(inputFile);

        // File outputFile = new File("output.txt");
        PrintWriter out = new PrintWriter("output.txt");

        out.printf("Hello World!");
        out.close();

    }
}
