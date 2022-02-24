
public class IndeksertListe<T> extends Lenkeliste<T> implements Liste<T>{

    public int stoerrelse (){
        return super.stoerrelse();
    }
    /**
     * Denne metoden setter inn x i posisjon pos.
     */
    @Override
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

            // Haanter spesialtilfelle 2: Elementet skal legges til sist i listen
            if (pos == this.stoerrelse()){

                while (aktuellNode.neste != null){
                    aktuellNode = aktuellNode.neste;
                }

                aktuellNode.neste = nyNode;
            }
              
            // Ellers: Gaar oppover gjennom nodene til node n-1
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

    /**
     * Denne metoden erstatter elementet i posisjon pos med x.
     */
    @Override
    public void sett(int pos, T x) throws UgyldigListeindeks{
        //
        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "sett")){
        throw new UgyldigListeindeks(pos);
        }
    }

    /**
     * Denne metoden henter elementet i posisjon x uten aa slette det.
     */
    @Override
    public T hent(int pos) throws UgyldigListeindeks{
        
        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "leggTil")){
        throw new UgyldigListeindeks(pos);
        }

    }

    /**
     * Denne metoden fjerner elementet i posisjon x og returnerer det.
     */
    @Override
    public T fjern(int pos) throws UgyldigListeindeks{
        
        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "leggTil")){
        throw new UgyldigListeindeks(pos);
        }
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
