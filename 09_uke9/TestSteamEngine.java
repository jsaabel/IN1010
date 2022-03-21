package steamEngineObserverPackage;

public class TestSteamEngine {
	public static void main(String arg[]) {
		SimpleObserverI myObs, myObs2, myAlarmObs;
		SteamEngineC myEngine;

		myEngine = new SteamEngineC();
		myObs = new SteamEngineObserverC(myEngine);
		myObs2 = new SteamEngineObserverDotsC(myEngine);
		myAlarmObs = new SteamEngineObserverAlarm(myEngine, 85);
		
		for(int i = 30; i <= 100; i += 10) {
			myEngine.setTemp(i);
		}
	}
}
