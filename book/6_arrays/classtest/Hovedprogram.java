import java.util.ArrayList;

public class Hovedprogram {
    public static void main (String[] args) {
        ArrayList<String> old = new ArrayList<String>();
        old.add("Anton");
        old.add("Berit");
        old.add("Charlie");

        ArrayList<String> newList = new ArrayList<String>();
        newList = ReverseList.main(old);

        for (String e: newList) {
            System.out.println(e);
        }
    }
}
