package mobilebilling;

public interface CallRatingInterface {
	
	int calculateCallCost(CallInterface call);
	
	void setSameNetworkCallRate(int costPerMinute);
	int  getSameNetworkCallRate();
	
	void setChargeBandCost(String chargeBand, int costPerMinute);
	int  getChargeBandCost(String chargeBand);

	void setReverseCallFactor(double d);

	Object getReverseCallFactor();
}
