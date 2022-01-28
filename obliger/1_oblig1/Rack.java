public class Rack {
    
    final static int MAKSNODER = 12;

    
    Node[] noder = new Node[MAKSNODER];
    private int antallNoderIRack = 0;
    

    public void settInnNode(Node enNode) {
        
        boolean sattInn = false;
        int i = 0;

        while (!sattInn && i < MAKSNODER) {
            if (noder[i] == null) {
                noder[i] = enNode;
                sattInn = true;
            }
            else {i++;}    
        }
        antallNoderIRack++;
    }

    public int antallProsessorer() {
        int antall = 0;
        for (int i = 0; i < MAKSNODER; i++) {
            if (noder[i] != null) {
                antall += noder[i].antProsessorer();
                }
            }    
    
        return antall;
    }

    public int noderMedNokMinne(int paakrevdMinne) {
        int antallMedNokMinne = 0;
        for (int i = 0; i < MAKSNODER; i++) {
            if (noder[i] != null) {
                if (noder[i].minne() >= paakrevdMinne) {
                    antallMedNokMinne++;
                }
            }
        }
        return antallMedNokMinne;

    }

    public boolean harPlassTilFlere() {
        if (antallNoderIRack < MAKSNODER) {
            return true;
        }
        return false;
    }

}


