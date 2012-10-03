package mobilebilling.dummy;

import java.util.HashMap;
import java.util.Map;

import mobilebilling.CallInterface;
import mobilebilling.CallRatingInterface;

public class CallRater implements CallRatingInterface{
	
	Map<String, Integer> chargeBandRates = new HashMap<String, Integer>();
	private int sameNetworkRate;
	private double reverseCallFactor;
	ChargeBandGetter chargeBandGetter;
	
	public CallRater(ChargeBandGetter chargeBandGetter) {
		this.chargeBandGetter = chargeBandGetter;
	}
	
	int secondsToMinutes(int seconds) {
		return (seconds % 60 == 0) ? seconds / 60 : (seconds / 60) + 1;
	}
	
	String getNetwork(String number) {
		return number.substring(0, 5);
	}

	@Override
	public int calculateCallCost(CallInterface call) {
		int minutes = secondsToMinutes(call.getDuration());
		boolean sameNetwork = getNetwork(call.getCallingNumber())
		                      .equals(getNetwork(call.getCalledNumber()));
		
		int callRate;	
		if (sameNetwork) {
			callRate = sameNetworkRate;
		} else {
			String band = chargeBandGetter.getChargeBand(call.getCalledNumber());
			callRate = chargeBandRates.get(band);
		}
		
		if (call.getType() == 634)
			callRate *= reverseCallFactor;
		
		return minutes * callRate;
	}

	@Override
	public void setSameNetworkCallRate(int costPerMinute) {
		sameNetworkRate = costPerMinute;
	}

	@Override
	public int getSameNetworkCallRate() {
		return sameNetworkRate;
	}

	@Override
	public void setChargeBandCost(String chargeBand, int costPerMinute) {
		chargeBandRates.put(chargeBand, costPerMinute);
	}

	@Override
	public int getChargeBandCost(String chargeBand) {
		return chargeBandRates.get(chargeBand);
	}

	@Override
	public void setReverseCallFactor(double reverseCallFactor) {
		this.reverseCallFactor = reverseCallFactor;
	}

	@Override
	public Object getReverseCallFactor() {
		return reverseCallFactor;
	}

}
