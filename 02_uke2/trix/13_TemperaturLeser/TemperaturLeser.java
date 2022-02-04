import java.util.Scanner;
import java.io.File;

public class TemperaturLeser{
    public static void main(String[] args) throws Exception{

        String[] temperaturer = new String[12];

        Scanner fil = new Scanner(new File("temperatur.txt"));

        int i = 0;

        while (fil.hasNextLine()) {

            String temp = fil.nextLine();
            temperaturer[i] = temp;
            i++;
            
        }

        for (String t: temperaturer) {
            System.out.println(t);
        }
    }
        
            




}    

