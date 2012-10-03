package unit.tests.mobilebilling;

import static org.junit.Assert.*;

import java.util.Date;

import mobilebilling.CallRatingInterface;
import mobilebilling.dummy.Call;
import mobilebilling.dummy.CallRater;
import mobilebilling.dummy.ChargeBandGetter;

import org.junit.Test;

public class CallRatingTests {
	
	CallRatingInterface callRater = new CallRater(new ChargeBandGetter());

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
		int sameNetworkChargeRate = 90;
		int type = 991;
		String callingNumber = "07777654321";
		String calledNumber = "07777123456";
		Date startTime = new Date();
		int duration = 60;
		Call call = new Call(type, callingNumber, calledNumber, startTime, duration);
		callRater.setSameNetworkCallRate(sameNetworkChargeRate);
		assertEquals(90,callRater.calculateCallCost(call));
	}
	
	@Test
	public void testChargeBandCallCharge()
	{
		int differentNetworkRate = 200;
		String differentNetworkBand = "national A rate";
		int type = 991;
		String callingNumber = "07777654321";
		String calledNumber = "07837123456";
		Date startTime = new Date();
		int duration = 60;
		Call call = new Call(type, callingNumber, calledNumber, startTime, duration);
		callRater.setChargeBandCost(differentNetworkBand, differentNetworkRate);
		assertEquals(200,callRater.calculateCallCost(call));
	}
	
	@Test
	public void testReverseCallDiferentNetworkCharge()
	{
		int differentNetworkRate = 200;
		String differentNetworkBand = "national A rate";
		int type = 634;
		String callingNumber = "07777654321";
		String calledNumber = "07837123456";
		Date startTime = new Date();
		int duration = 60;
		Call call = new Call(type, callingNumber, calledNumber, startTime, duration);
		callRater.setChargeBandCost(differentNetworkBand, differentNetworkRate);
		callRater.setReverseCallFactor(2.0);
		assertEquals(2.0, callRater.getReverseCallFactor());
		assertEquals(400,callRater.calculateCallCost(call));
	}
	
	@Test	
	public void testReverseCallSameNetworkCharge()
	{
		int sameNetworkChargeRate = 56;
		int type = 634;
		String callingNumber = "07777654321";
		String calledNumber = "07777123456";
		Date startTime = new Date();
		int duration = 60;
		Call call = new Call(type, callingNumber, calledNumber, startTime, duration);
		callRater.setReverseCallFactor(2.0);
		callRater.setSameNetworkCallRate(sameNetworkChargeRate);
		assertEquals(56*2,callRater.calculateCallCost(call));
	}

}
