class DuplikatException extends Exception{

  DuplikatException(Bok b){
    super(b + " finnes allerede i hyllen.");
  }
}
