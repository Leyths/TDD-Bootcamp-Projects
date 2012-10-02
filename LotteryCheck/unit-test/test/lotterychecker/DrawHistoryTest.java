package test.lotterychecker;

import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;
import lotterychecker.Draw;
import lotterychecker.DrawHistory;

public class DrawHistoryTest extends TestCase {
	
	DrawHistory drawHistory = new DrawHistory();
	
	@Test 
	public void testReturnDrawResults() {
		Draw draw = drawHistory.getDraw(new Date());
		assertNotNull(draw);
		assertEquals(draw.getNumbers().length, 6);
		for(int i=0; i<draw.getNumbers().length; i++)
		{
			assertTrue(draw.getNumbers()[i]<50);
			assertTrue(draw.getNumbers()[i]>0); 
		}
	}
	
	public void testReturnPrizeValues() {
		Draw draw = drawHistory.getDraw(new Date());
		assertEquals(0, draw.getPrizeValue(0));
		assertEquals(0, draw.getPrizeValue(1));
		assertEquals(0, draw.getPrizeValue(2));		
		for(int i=3; i<7; i++) {
			assertTrue(draw.getPrizeValue(i)>0);
		}
	}
}
