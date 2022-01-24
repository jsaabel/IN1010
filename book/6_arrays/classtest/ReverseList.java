import java.util.ArrayList;

public class ReverseList {
    public static ArrayList<String> main(ArrayList<String> oldList) {
        ArrayList<String> output = new ArrayList<String>();

        for (int i = oldList.size() -1; i >= 0; i--) {
            output.add(oldList.get(i));
        }

        return output;
    }
}
