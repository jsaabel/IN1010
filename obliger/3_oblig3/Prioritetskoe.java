public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T>{


    public int stoerrelse(){
        int res = super.stoerrelse();
        return res;
    }

    @Override
    public void leggTil(T x){

        // ...
        if (this.start == null){
            super.leggTil(x);
            return;
        }

        // Opprett nyNode
        Node nyNode = new Node(x);

        // ...
        boolean stoerreFunnet = false;
        int stoerreFunnetIndeks = 0;
        // Gaa gjennom nodene
        for (int i=0; i < this.stoerrelse(); i++){
        
            Node aktuellNode = super.hentNode(i);

            if (aktuellNode.compareTo(nyNode) >= 0){
                stoerreFunnetIndeks = i;
                stoerreFunnet = true;
                break;
            }
        }
        if (!stoerreFunnet){
        
            Node sisteNode = super.hentNode(this.stoerrelse() - 1);
            sisteNode.neste = nyNode;
        }

        else {
        
            if (stoerreFunnetIndeks == 0){
                nyNode.neste = this.start;
                this.start = nyNode;
            }

            else {
                
                Node forrigeNode = super.hentNode(stoerreFunnetIndeks - 1);
                Node nesteNode = super.hentNode(stoerreFunnetIndeks);
                forrigeNode.neste = nyNode; 
                nyNode.neste = nesteNode;
            }
        }

        super.antallNoder++;
    }

    @Override
    public T hent() throws UgyldigListeindeks{

        
        if (!super.gyldigIndeks(0, "hent")){
            throw new UgyldigListeindeks(0);
        }

        else {
            T res = this.start.data;
            return res;
        }
    }

    @Override
    public T fjern(){

        if (!super.gyldigIndeks(0, "fjern")){
            throw new UgyldigListeindeks(0);
        }

        else {

            T res = this.start.data;

            if (this.stoerrelse() >= 2){
                this.start = this.start.neste;
            }

            else { 
                this.start = null;
            }

            super.antallNoder--;
            return res;
        }
    }

}
