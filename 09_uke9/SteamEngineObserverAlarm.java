package steamEngineObserverPackage;

public class SteamEngineObserverAlarm implements SimpleObserverI {
	int myAlarmTemp;

	SteamEngineC mySteamEngine;

	SteamEngineObserverAlarm(SteamEngineC myEngine, int initialAlarmTemp) {
		mySteamEngine = myEngine;
		myAlarmTemp = initialAlarmTemp;
		myEngine.add(this);
	}

	public void update() {
		if (mySteamEngine.getTemp() > 85) {
			System.out.println("**** ALARM ****");
		}
	}
	
}
