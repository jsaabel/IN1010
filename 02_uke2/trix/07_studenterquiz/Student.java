public class Student{
    private String navn;
    private int totalScore; 
    private int antQuiz;
     
    public Student(String sNavn, int sTotalScore, int sAntQuiz) {
        navn = sNavn;
        totalScore = sTotalScore;
        antQuiz = sAntQuiz;
    }

    public String hentNavn() {
        return navn;
    }

    public void leggTilQuizScore(int score) {
        totalScore += score;
        antQuiz++;
    }

    public int hentTotalScore() {
        return totalScore;
    }

    public double hentGjennomsnittligScore() {
        return totalScore / antQuiz;
    }
        

}
