class IkkeMerPlassException extends Exception{

  IkkeMerPlassException(String boktittel){
    super("Ikke mer plass til " + boktittel + ".");
  }
}
