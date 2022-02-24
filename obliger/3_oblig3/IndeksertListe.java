
public class IndeksertListe<T> extends Lenkeliste<T> implements Liste<T>{

    @Override
    public int stoerrelse (){
        return super.stoerrelse();
    }
    /**
     * Denne metoden setter inn x i posisjon pos.
     */
    public void leggTil(int pos, T x){

        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "leggTil")){
        throw new UgyldigListeindeks(pos);
        }

        Node nyNode = new Node(x);

        // Haandter spesialtilfelle 1: Listen er tom
        if (this.start == null){
            this.start = nyNode;
        }

        else{

            // Hvis ikke: Start med foerste noden i listen.
            Node aktuellNode = this.start;

            // Haanter spesialtilfelle: Elementet skal legges foerst i listen
            if (pos == 0){
                nyNode.neste = aktuellNode.neste;
                this.start = nyNode;
            }
            // Haanter spesialtilfelle: Elementet skal legges til sist i listen
            else if (pos == this.stoerrelse()){

                while (aktuellNode.neste != null){
                    aktuellNode = aktuellNode.neste;
                }

                aktuellNode.neste = nyNode;
            }
              
            // Ellers: Gaar oppover gjennom nodene til node n-1
            else{
                int aktuellPos = 0;
                while (aktuellPos < pos -1){
                    aktuellNode = aktuellNode.neste;
                    aktuellPos ++;
                }
            
                // Den nye noden faar node n som neste. 
                nyNode.neste = aktuellNode.neste;

                // Node n-1 faar den nye noden som neste 
                aktuellNode.neste = nyNode;
            }
        } 

    super.antallNoder ++;
    }

    /**
     * Denne metoden erstatter elementet i posisjon pos med x.
     */
    public void sett(int pos, T x) throws UgyldigListeindeks{
        //
        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "sett")){
        throw new UgyldigListeindeks(pos);
        }
        
        // Hvis ja: Oppretter ny node
        Node nyNode = new Node(x);

        // Haandter spesialtilfelle 1: Listen er tom
        if (this.start == null){
            this.start = nyNode;
        }

        else{

            // Hvis ikke: Start med foerste noden i listen.
            Node aktuellNode = this.start;

            // Haandter spesieltilfelle 2: nyNode skal erstatte start
            if (pos == 0){
                nyNode.neste = aktuellNode.neste;
                this.start = nyNode;
            }
            // Haandter spesialtilfelle 2: Elementet skal legges til sist i listen
            if (pos == this.stoerrelse()){

                // gaa til nest-siste element i listen og overskriv dens neste
                int aktuellPos = 0;
                while (aktuellPos < pos -1){
                    aktuellNode = aktuellNode.neste;}
                aktuellNode.neste = nyNode;
            }
              
            // Ellers: Gaar oppover gjennom nodene til node n-1
            int aktuellPos = 0;
            while (aktuellPos < pos -1){
                aktuellNode = aktuellNode.neste;
                aktuellPos ++;
            }
            
            // Den nye noden faar node n + 1 som neste. 
            nyNode.neste = aktuellNode.neste.neste;

            // Node n-1 faar den nye noden som neste 
            aktuellNode.neste = nyNode;
        } 

    super.antallNoder ++;


    }

    /**
     * Denne metoden henter elementet i posisjon x uten aa slette det.
     */
    public T hent(int pos) throws UgyldigListeindeks{
        
        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "hent")){
        throw new UgyldigListeindeks(pos);
        }

        T res;
        // Gaa gjennom nodene til posisjon X
        Node aktuellNode = this.start;
        int aktuellPos = 0;
        while (aktuellPos < pos){
            aktuellNode = aktuellNode.neste;
            aktuellPos ++;
        }

        res = aktuellNode.data;
        return res;
    }

    /**
     * Denne metoden fjerner elementet i posisjon x og returnerer det.
     */
    public T fjern(int pos) throws UgyldigListeindeks{
        
        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "fjern")){
        throw new UgyldigListeindeks(pos);
        }

        T res;
        Node aktuellNode = this.start;

        // Spesialtilfelle: Elementet er det eneste i listen
        if (pos == 0 && this.stoerrelse() == 1){
            res = aktuellNode.data;
            this.start = null;
        }
        // Spesialtilfelle: Elementet er det foerste i listen (legge begge sammen?)
        else if (pos == 0 && this.stoerrelse() > 1){
            res = aktuellNode.data;
            this.start = aktuellNode.neste;
        }

        // Spesialtilfelle: Elementet er det siste i listen
        else if (pos == this.stoerrelse()){
            // gaa oppover gjennom nodene til node n-1, lagrer data fra 
            // node n og setter node n-1s neste til null
            int aktuellPos = 0;
            while (aktuellPos < pos -1){
                aktuellNode = aktuellNode.neste;
            }
            res = aktuellNode.neste.data;
            aktuellNode.neste = null;

        }
        // "Vanlig tilfelle" (Elementet ligger mellom andre)
        else{

            // Gaar oppover gjennom nodene til node n-1
            int aktuellPos = 0;
            while (aktuellPos < pos -1){
                aktuellNode = aktuellNode.neste;
                aktuellPos ++;
            }
            
            // Lagre dataen i noden n
            res = aktuellNode.neste.data;

            // Node n-1 faar node n+1 som neste 
            aktuellNode.neste = aktuellNode.neste.neste;
        } 
        // Clean up
        super.antallNoder --;
        return res;
    }

    /**
     * Dette er en hjelpemetode som sjekker om argumentet pos er en 
     * gyldig indeks gitt metoden som skal utfoeres og listens aktuelle tilstand.
     */
    public boolean gyldigIndeks(int indeks, String metode){

        if (metode == "leggTil"){
            return (0 <= indeks && indeks <= stoerrelse());
        }

        else{
            return (0 <= indeks && indeks < stoerrelse());
        }
    }
}
