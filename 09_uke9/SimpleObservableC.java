package steamEngineObserverPackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SimpleObservableC implements SimpleObservableI {
	Set<SimpleObserverI> obsSet = new HashSet<SimpleObserverI>();

	@Override
	public void add(SimpleObserverI o) {
		obsSet.add(o);	
		o.update();  // as to display current value
	}

	@Override
	public void notifyAllObs() {
		Iterator<SimpleObserverI> i = obsSet.iterator();
		while (i.hasNext()) {
			SimpleObserverI o = i.next();
			o.update();
		}
		
	}
}
