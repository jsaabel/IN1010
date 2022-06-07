class Flytype{

  String type;
  String seteinfo;
  //
  // konstruktoer
  public Flytype(String type, String seteinfo){

    this.type = type;
    this.seteinfo = seteinfo;
  }

  public Flygning opprettFlygning(String no, String seteinfo){

    return new Flygning(no, seteinfo);
  }
}
