package test.lotterychecker;
import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;
import lotterychecker.DrawChecker;

public class DrawCheckerTest extends TestCase {

	DrawChecker check = new DrawChecker();
	@Test
	public void testWonTicket() {
		Integer[] lotteryNum = {1,2,3,4,5,6};
		Integer[] lotteryNumFail = {23,24,25,26,27,28};
		assertTrue(check.hasWon(lotteryNum, new Date()));
		assertFalse(check.hasWon(lotteryNumFail, new Date()));
	}
	
	@Test
	public void testPrizeAmount() {
		assertEquals(430000, check.prizeAmount(3, new Date()));
		assertEquals(0, check.prizeAmount(0, new Date()));
		assertEquals(39407, check.prizeAmount(6, new Date()));
	}
}
