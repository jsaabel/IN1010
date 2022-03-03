public class Person implements Comparable<Person>{
     
    String fornavn;
    String etternavn;
    int alder;

    public Person(String fornavn, String etternavn, int alder){

        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
    
        
    }

    @Override
    public String toString(){
        return this.fornavn + " " + this.etternavn;}

    public int compareTo(Person annen){

        if (this.alder != annen.alder) {return this.alder - annen.alder;}

        else {
            return this.toString().compareTo(annen.toString());
        }
            

    
    }
}    

