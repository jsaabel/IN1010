class Stringhjelper{

  // EI - t
  // STEIN - s
  public static int inneholder(String s, String t){

    for(int i=0; i < s.length(); i++){

      if (s.charAt(i) == t.charAt(0)){

        boolean funnet = true;
        int funnet_indeks = i;

        for (int x = 0; x < t.length(); x++){
          
          if(t.charAt(x) != s.charAt(funnet_indeks + x)){
            funnet = false;
          }
        }

        if (funnet){
          return i;
        }

      }
    }

    return -1;

  }
}
