package unit.tests.mobilebilling;

import static org.junit.Assert.*;

import java.util.Date;

import mobilebilling.dummy.Call;

import org.junit.Test;

public class CallTests {

	@Test
	public void testGetStuffInAndGetStuffOut() {
		int type = 991;
		String callingNumber = "07777123456";
		String calledNumber = "08362537255";
		Date startTime = new Date();
		int duration = 62;
		
		Call c = new Call(type, callingNumber, calledNumber, startTime, duration);
		
		assertEquals(type, c.getType());
		assertEquals(callingNumber, c.getCallingNumber());
		assertEquals(calledNumber, c.getCalledNumber());
		assertEquals(startTime, c.getStartTime());
		assertEquals(duration, c.getDuration());
	}

}
