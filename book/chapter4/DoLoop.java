import java.util.Scanner;

public class DoLoop {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a number under 100: ");
            number = in.nextInt();
        }
        while (number >= 100);

        System.out.println("Hooray!");
    }
}
