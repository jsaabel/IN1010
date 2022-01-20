import java.util.Scanner;
import java.lang.Math;

public class InvestmentTable {
    public static void main(String[] args) {
        int seedInvestment;
        double rate;
        int numberOfYears;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter seed investment: ");
        seedInvestment = in.nextInt();
        System.out.println("Enter projected interest rate: ");
        rate = in.nextDouble();
        System.out.println("Enter number of years to project: ");
        numberOfYears = in.nextInt();

        for (int i = 1; i <= numberOfYears; i++) {
            double total = seedInvestment * Math.pow(1 + rate, i);
            System.out.println("Year " + i + " : " + total);
        }

    }
}
