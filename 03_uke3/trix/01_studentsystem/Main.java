import java.io.FileNotFoundException;
public class Main{
    public static void main(String[] args) throws FileNotFoundException{
     
        StudentSystem studentsystem = new StudentSystem();
        studentsystem.lesFraFil("emnestudenter.txt");

        // Tester
        studentsystem.skrivUt();
        studentsystem.mestPopulaertFag();
        studentsystem.mestAktivStudent();

        studentsystem.visMeny();
        studentsystem.brukerValg();
    
    }

}    

