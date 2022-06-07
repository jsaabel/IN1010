import java.util.Iterator;

class DobbelLenke<T> implements Iterable<T>{

  Node start;
  int stoerrelse;

  class Node {
    T data;
    Node neste, forrige;

    public Node(T data){
      neste = null;
      forrige = null;
      this.data = data;
    }
  }

  @Override public Iterator<T> iterator(){
    return new DobbelLenkeIterator();
  }

  class DobbelLenkeIterator implements Iterator<T>{

    private int pos = 0;

    @Override
    public boolean hasNext(){
      return pos < stoerrelse();
    }

    @Override
    public T next(){
      Node aktuellNode = start; // kan ogsaa init. i konstruktoeren!

      if (pos > 0){
        for (int i=0; i<pos;i++){
          aktuellNode = aktuellNode.neste;
        }
      }
      pos++;
      return aktuellNode.data;

    }
  }

  public int stoerrelse(){
    return stoerrelse;
  }

  public void settInn(T x){

    Node nyNode = new Node(x);
    stoerrelse++;

    if (start == null){
      start = nyNode;
    }

    else{
      Node aktuellNode = start;
      while(aktuellNode.neste != null){
        aktuellNode = aktuellNode.neste;
      }
      aktuellNode.neste = nyNode;
      nyNode.forrige = aktuellNode;
    }
  }

  public T hent(int index){
    return start.data;

  }

  public T fjern(int index){
    return start.data;
  }

  
}
