import java.util.ArrayList;

public class ReverseList {
    public static void main (String[] args) {
        ArrayList<String> oldList = new ArrayList<String>();
        oldList.add("Anna");
        oldList.add("Berit");
        oldList.add("Charlie");

        ArrayList<String> output = new ArrayList<String>();

        for (int i = oldList.size() -1; i >= 0; i--) {
            output.add(oldList.get(i));
        }

        for (String e: output) {
            System.out.println(e);
        }
    }
}
