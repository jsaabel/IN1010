abstract class Lenkeliste<T> implements Liste<T> {

    class Node{
        Node neste = null;
        T data;
        Node(T x){
            data = x;
        }

    }

    public Node start = null;

    public int antallNoder = 0;

    public int stoerrelse(){
        return antallNoder;
    }


    /**
     * Denne metoden legger til et nytt element sist i listen.
     */
    public void leggTil(T x){

        Node nyNode = new Node(x);

        // Hvis listen er tom blir den nye noden starten paa listen.
        if (this.start == null){
            start = nyNode;
        }

        // Hvis ikke gaar vi gjennom listen til vi finner siste noden (den som
        // ikke har en "neste") og legger den nye noden til etter denne.
        else {
            Node aktuellNode = start;
            while (aktuellNode.neste != null){
                aktuellNode = aktuellNode.neste;
            }
            aktuellNode.neste = nyNode;
        }

        // Til slutt inkrementer vi antallNoder
        antallNoder ++;
    }

    /**
     * Denne metoden returnerer det foerste elementet i listen.
     */
    public T hent(){

        if (this.start == null){
            return null; // temp
        }
        
        else{
            T res = start.data;
            return res;
        }
    }

    /**
     * Denne metoden fjerner det foerste elementet i listen og returnerer
     * det.
     */
    public T fjern(){
        
        // Hvis listen er tom...
        if (this.start == null){
            return null; // temp
        }

        // Hvis ikke listen er tom...
        else{
            T res = start.data; // det er dette vi vil hente ut
            start = start.neste; // den andre noden i listen blir nye "start"
            antallNoder --; // antallNoder -1
            return res;
        }
    }

    /**
     * Denne metoden bygger opp en svarstreng av elementene i listen.
     */
    public String toString(){

        String res = "";

        if (this.start == null){
            res = "(Tom liste.)";
        }

        else {
            Node aktuellNode = start;
            while (aktuellNode.neste != null){
                res += aktuellNode.data.toString() + "\n";
                aktuellNode = aktuellNode.neste;
            }
        }

        return res;
    }

}
