package steamEngineObserverPackage;

public class SteamEngineObserverC implements SimpleObserverI {
	SteamEngineC mySteamEngine;
	
	SteamEngineObserverC(SteamEngineC myEngine) {
		mySteamEngine = myEngine;
		myEngine.add(this);
	}
	
	@Override
	public void update() {
		System.out.println("Current Steam Temperature is " + mySteamEngine.getTemp());
	}

}
