package test.java;

public class PerfectoTestParams {

	String _repKey;
	device _device;
	String _platform;
	String _activityBandle;
	String _cloud = "https://demo.perfectomobile.com";
	String _user = "uzie@perfectomobile.com";
	String _password = "Perfecto1";

	public PerfectoTestParams(device device,String repKey,String platform,String ActivityBandle) {
		_device = device;
		_repKey = repKey;
		_platform =platform;
		_activityBandle = ActivityBandle;
	}

}
