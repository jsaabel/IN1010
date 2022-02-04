import java.util.Scanner;
import java.io.File;

public class FraFil{
    public static void main(String[] args) throws Exception{
        Scanner fil = new Scanner(new File("tekst.txt"));
        
        String linje = "";
        
        while (fil.hasNextLine()) {
            linje = fil.nextLine();
            System.out.println(linje);
        }
     

    }

}    

