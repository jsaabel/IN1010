import java.util.Scanner;

public class ActualFloor {
    public static void main(String[] args) {
        int actualFloor;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter floor number: ");
        int floor = userInput.nextInt();

        if (floor > 13) {
            actualFloor = floor - 1;
        }
        else {
            actualFloor = floor;
        }

        String message = "The actual floor is: " + actualFloor;
        System.out.println(message);

    }
}
