
public class IndeksertListe<T> extends Lenkeliste<T> implements Liste<T>{

    @Override
    public int stoerrelse (){
        return super.stoerrelse();
    }

    
    /**
     * Denne metoden utfoeres hvis ingen pos blir spesifisert,
     * og legger til den nye noden sist i lista.
     */
    public void leggTil(T x){
        
        Node nyNode = new Node(x);
        
        // Spesialtilfelle: Listen er tom
        if (this.start== null){
            this.start = nyNode;
        }

        // Listen er ikke tom
        else{
        Node sisteNode = hentNode(this.stoerrelse() - 1);
        sisteNode.neste = nyNode;
        }

        super.antallNoder ++;
        
    }

    /**
     * Denne metoden setter inn x i posisjon pos.
     */
    public void leggTil(int pos, T x) throws UgyldigListeindeks{

        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "leggTil")){
        throw new UgyldigListeindeks(pos);
        }

        // Hvis ja: Oppretter nyNode
        Node nyNode = new Node(x);

        // Haandter spesialtilfelle: Listen er tom
        // --> Legg til noden som ny start og avslutt der
        if (this.start == null){
            this.start = nyNode;
        }

        else{
            
            // pos = 0 (ingen noder foran ny node)
            // --> nyNode faar "gamle" start som neste og blir nye start
            if (pos == 0){
                nyNode.neste = this.start;
                this.start = nyNode;
            }
             
            // pos == stoerrelse() (ingen noder bak ny node)
            // --> siste noden i lista faar nyNode som neste
            else if (pos == this.stoerrelse()){
                Node sisteNode = hentNode(pos -1);
                sisteNode.neste = nyNode;
            }

            // pos > 0 && pos < stoerrelse (node foran og bak ny node)
            // --> nyNode faar node i posisjon pos som neste
            // --> node i posisjon pos-1 faar nyNode som neste
            else if (pos < this.stoerrelse()){
                Node bak = hentNode(pos);
                nyNode.neste = bak;
                Node foran = hentNode(pos - 1);
                foran.neste = nyNode;
            }
        } 

        // inkrementer antallNoder
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

        // Haandter spesialtilfelle: Listen er tom
        // --> sett nyNode som start og inkrementer stoerrelse
        if (this.start == null){
            this.start = nyNode;
            super.antallNoder ++;
        }


        else{
            
            // pos = 0 
            // --> nyNode faar element i pos 1 som neste og blir nye start
            if (pos == 0){
                Node bak = hentNode(1);
                nyNode.neste = bak;
                this.start = nyNode;
            }
             
            // pos == stoerrelse() (ingen noder bak ny node)
            // --> nest-siste noden i lista faar nyNode som neste
            else if (pos == this.stoerrelse()){
                Node foran = hentNode(pos - 1);
                foran.neste = nyNode;
            }

            // pos > 0 && pos < stoerrelse (node foran og bak ny node)
            // --> nyNode faar node i posisjon pos + 1 som neste
            // --> node i posisjon pos-1 faar nyNode som neste
            else if (pos < this.stoerrelse()){
                Node bak = hentNode(pos + 1);
                nyNode.neste = bak;
                Node foran = hentNode(pos - 1);
                foran.neste = nyNode;
            }
        }

    }

    /**
     * Denne metoden henter elementet i posisjon x uten aa slette det.
     */
    public T hent(int pos) throws UgyldigListeindeks{
        
        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "hent")){
        throw new UgyldigListeindeks(pos);
        }

        // Hent node og data paa posisjon pos
        Node aktuellNode = hentNode(pos);

        T res = aktuellNode.data;
        return res;
    }

    /**
     * Denne metoden fjerner elementet i posisjon x og returnerer det.
     */
    public T fjern(int pos) throws UgyldigListeindeks{
        
        T res = null;

        // Sjekker om pos er en gyldig indeks.
        if (!gyldigIndeks(pos, "fjern")){
        throw new UgyldigListeindeks(pos);
        }


        // Spesialtilfelle: Elementet er det eneste i listen
        // --> hent data fra start og sett start til null
        if (this.start.neste == null){
            res = this.start.data;
            this.start = null;
        }

        // pos = 0 
        // --> hent data fra pos 0 og sett node i pos 1 som ny start
        else if (pos == 0){
            res = hentNode(pos).data;
            this.start = hentNode(1);
        }
         
        // pos == stoerrelse() (ingen noder bak noden som skal fjernes)
        // --> returner data fra noden i posisjon pos
        // --> nest-siste noden i lista faar neste = null
        else if (pos == this.stoerrelse()){

            res = hentNode(pos).data;
            Node foran = hentNode(pos - 1);
            foran.neste = null;
        }

        // pos > 0 && pos < stoerrelse (node foran og bak den som skal slettes)
        // --> returner data fra noden i posisjon pos
        // --> node i posisjon pos-1 faar node i posisjon pos+1 som neste
        else if (pos < this.stoerrelse()){
            res = hentNode(pos).data;
            Node bak = hentNode(pos + 1);
            Node foran = hentNode(pos - 1);
            foran.neste = bak;
        }

        // oppdater antall noder
        super.antallNoder --;

        // returner data
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

    /**
     * Dette er en hjelpemetode som returnerer noden paa angitt posisjon
     * (ikke bare dens data.)
     */
    public Node hentNode(int pos){

        // Begynner paa start og gaar oppover
        Node aktuellNode = this.start;
        int aktuellPos = 0;

        while (aktuellPos < pos){
            aktuellNode = aktuellNode.neste;
            aktuellPos ++;
        }

        return aktuellNode;
    }
}
