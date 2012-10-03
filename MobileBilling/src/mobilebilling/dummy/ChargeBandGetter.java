package mobilebilling.dummy;

import java.util.HashMap;
import java.util.Map;

import mobilebilling.ChargeBandGetterInterface;

public class ChargeBandGetter implements ChargeBandGetterInterface {
	
	Map<String, String> chargeBands = new HashMap<String, String>() {{
		put("08362537255", "national A rate");
		put("07837123456", "national A rate");
	}};

	@Override
	public String getChargeBand(String calledNumber) {
		return chargeBands.get(calledNumber);
	}

}
