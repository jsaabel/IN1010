package steamEngineObserverPackage;

public class SteamEngineC extends SimpleObservableC {
	int temp;
	public SteamEngineC() {
		temp = 20; // somewhat arbitrary initial value
	}
	public void setTemp(int t) {
		temp = t;
		notifyAllObs();
	}
	
	public int getTemp() {
		return temp;
	}
}
