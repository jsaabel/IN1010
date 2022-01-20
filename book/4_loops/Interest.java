import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your interest rate: ");
        double interestRate = input.nextFloat();
        double total = 1;
        int iterations = 0;
        while(total < 2) {
            total *= 1 + interestRate;
            iterations ++;
        }
        System.out.println("With a yearly interest rate of " + interestRate +
        " %, it will take " + iterations + " years for the seed capital to double.");
    }
}
