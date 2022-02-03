public class Hovedprogram{
    public static void main(String[] args){
        Student joakim = new Student("Joakim",5, 1);
        Student kristin = new Student("Kristin", 10, 2);
        Student dag = new Student("Dag", 0, 2);

        joakim.leggTilQuizScore(5);
        joakim.leggTilQuizScore(5);
        joakim.leggTilQuizScore(5);
        
        
        kristin.leggTilQuizScore(5);
        kristin.leggTilQuizScore(9);
        kristin.leggTilQuizScore(5);
        
        dag.leggTilQuizScore(5);
        dag.leggTilQuizScore(0);
        dag.leggTilQuizScore(5);

        System.out.println("Joakim: " + joakim.hentTotalScore() +" ("+ joakim.hentGjennomsnittligScore() + ")");
        System.out.println("Kristin: " + kristin.hentTotalScore() +" ("+ kristin.hentGjennomsnittligScore() + ")");
        System.out.println("Dag: " + dag.hentTotalScore() +" ("+ dag.hentGjennomsnittligScore() + ")");
    }

}    

