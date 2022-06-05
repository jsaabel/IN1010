public class Stabel<T> extends Lenkeliste<T> {
    
    @Override
    public void leggTil (T x){
        
        Node nyNode = new Node(x);

        // Hvis ikke listen er tom ...
        if (this.start != null){
            nyNode.neste = start;
        }

        start = nyNode;

        super.antallNoder ++;
    }
}
