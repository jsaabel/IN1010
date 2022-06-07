class CDAlbum implements Comparable<CDAlbum>{
  String artistnavn, albumnavn, utgivelsesaar;

  public CDAlbum(String artistnavn, String albumnavn, String utgivelsesaar){
    this.artistnavn = artistnavn;
    this.albumnavn = albumnavn;
    this.utgivelsesaar = utgivelsesaar;
  }

  public String hentArtistnavn(){
    return this.artistnavn;
  }

  @Override
  public String toString(){
    return this.artistnavn + ": " + this.albumnavn + " (" + this.utgivelsesaar + ")";
  }

  @Override
  public int compareTo(CDAlbum a){
    return this.artistnavn.compareTo(a.artistnavn);
  }
}
