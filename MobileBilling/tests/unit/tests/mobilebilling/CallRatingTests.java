package unit.tests.mobilebilling;

import static org.junit.Assert.*;

import java.util.Date;

import mobilebilling.CallInterface;
import mobilebilling.CallRatingInterface;
import mobilebilling.dummy.Call;
import mobilebilling.dummy.CallRater;
import mobilebilling.dummy.ChargeBandGetter;

import org.junit.Test;

public class CallRatingTests {
	
	CallRatingInterface callRater = new CallRater(new ChargeBandGetter());
	String callingNumber = "07777654321";
	String calledNumberSameNetwork = "07777123456";
	String calledNumberDifferentNetwork = "07837123456";
	int sameNetworkChargeRate = 90;
	int differentNetworkRate = 200;
	Date startTime = new Date();
	int duration = 60;
	String differentNetworkBand = "national A rate";


	@Test
	public void testSameNetworkCallRate() {
		int callRate = 56;
		callRater.setSameNetworkCallRate(callRate);
		assertEquals(callRate, callRater.getSameNetworkCallRate());
	}
	
	@Test
	public void testChargeBandCallRate() {
		int callRate = 56;
		String chargeBand = "national A rate";
		callRater.setChargeBandCost(chargeBand, callRate);
		assertEquals(callRate, callRater.getChargeBandCost(chargeBand));
	}
	
	@Test
	public void testSameNetworkCallCharge()
	{
		int type = Call.TYPE_DIRECTDIAL;
		Call call = new Call(type, this.callingNumber, this.calledNumberSameNetwork, this.startTime, this.duration);
		callRater.setSameNetworkCallRate(this.sameNetworkChargeRate);
		assertEquals(90,callRater.calculateCallCost(call));
	}
	
	@Test
	public void testChargeBandCallCharge()
	{
		int type = Call.TYPE_DIRECTDIAL;
		Call call = new Call(type, this.callingNumber, this.calledNumberDifferentNetwork, this.startTime, this.duration);
		callRater.setChargeBandCost(this.differentNetworkBand, this.differentNetworkRate);
		assertEquals(200,callRater.calculateCallCost(call));
	}
	
	@Test
	public void testReverseCallDiferentNetworkCharge()
	{
		int type = Call.TYPE_REVERSEDIAL;
		Call call = new Call(type, this.callingNumber, this.calledNumberDifferentNetwork, this.startTime, this.duration);
		callRater.setChargeBandCost(this.differentNetworkBand, this.differentNetworkRate);
		callRater.setReverseCallFactor(2.0);
		assertEquals(2.0, callRater.getReverseCallFactor());
		assertEquals(400,callRater.calculateCallCost(call));
	}
	
	@Test	
	public void testReverseCallSameNetworkCharge()
	{
		int type = Call.TYPE_REVERSEDIAL;
		Call call = new Call(type, this.callingNumber, this.calledNumberSameNetwork, this.startTime, this.duration);
		callRater.setReverseCallFactor(2.0);
		callRater.setSameNetworkCallRate(this.sameNetworkChargeRate);
		assertEquals(180,callRater.calculateCallCost(call));
	}

}
