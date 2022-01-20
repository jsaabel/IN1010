import java.util.Scanner;

public class BoxText {
    public static void boxText(String inText) {
        // print -- for each character in inText
        for (int i = 1; i <= inText.length() + 2; i++) {
            System.out.print("-");
        }
        System.out.println("");
        // print original string with ! before and after
        System.out.println("!" + inText + "!");
        // print last line
        for (int i = 1; i <= inText.length() + 2; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String userInput = in.nextLine();

        boxText(userInput);
    }
}
