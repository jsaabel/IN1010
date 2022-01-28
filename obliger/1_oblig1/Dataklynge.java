import java.util.ArrayList;

public class Dataklynge {
    
    String navn;
    ArrayList<Rack> racks;

    public Dataklynge(String navnPaaDataklynge) {
        navnPaaDataklynge = navn;
        racks = new ArrayList<Rack>();
    }

    public void opprettRack() { // opprett og legg til et nytt rack
        Rack enRack = new Rack();
        racks.add(enRack);    
    }

    public void leggInnNode(Node enNode) {
        
        boolean alleRagsErFyltOpp = true;
        
        for (Rack r: racks) {
            if (r.harPlassTilFlere()) {
                alleRagsErFyltOpp = false;
            }
        }

        if (alleRagsErFyltOpp) {
            opprettRack();
        }

        boolean lagtInn = false;
        while (!lagtInn) {
            for (Rack r : racks) {
                if (r.harPlassTilFlere()) {
                    r.settInnNode(enNode);
                    lagtInn = true;
                }
            }
        }

    }

    public int noderMedNokMinne(int paakrevdMinne) {
        
        int antallFunnet = 0;

        for (Rack r : racks) {
            antallFunnet += r.noderMedNokMinne(paakrevdMinne);
        }

        return antallFunnet;

    }

    public int antallProsessorer() {
        
        int antall = 0;
        
        for (Rack r: racks) {
            antall += r.antallProsessorer();
        }

        return antall;
    }
    
    public int antallRacks() {
        return racks.size();
    }

}

