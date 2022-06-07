class Parkeringsplass<E>{

  E parkert;

  public void settInn(E element){
    this.parkert = element;
  }

  public E taUt(){
    
    E kjoeretoy = parkert;
    parkert = null;
    return kjoeretoy;

    
  }
}
