import java.util.Scanner;

public class CubeVolume {
    public static double cubeVolume(double sideLength) {
        double volume = sideLength * sideLength * sideLength;
        return volume;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter side length: ");
        double userInput = in.nextDouble();
        System.out.println(cubeVolume(userInput));
    }
}
