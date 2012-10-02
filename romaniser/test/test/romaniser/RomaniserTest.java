package test.romaniser;

import org.junit.Test;

import romaniser.Romaniser;

import junit.framework.TestCase;

public class RomaniserTest extends TestCase{
	
	Romaniser romaniser = new Romaniser();
	
	@Test public void testConvertsOne()
	{
		assertEquals("I", romaniser.romanise(1));
	}
	
	@Test public void testBaseCases()
	{
		assertEquals("I", romaniser.romanise(1));
		assertEquals("II", romaniser.romanise(2));
		assertEquals("III", romaniser.romanise(3));
		assertEquals("IV", romaniser.romanise(4));
		assertEquals("V", romaniser.romanise(5));
		assertEquals("VI", romaniser.romanise(6));
		assertEquals("VII", romaniser.romanise(7));
		assertEquals("VIII", romaniser.romanise(8));
		assertEquals("IX", romaniser.romanise(9));
	}
	
	@Test public void testDecades()
	{
		assertEquals("X", romaniser.romanise(10));
		assertEquals("XX", romaniser.romanise(20));
		assertEquals("XXX", romaniser.romanise(30));
		assertEquals("XL", romaniser.romanise(40));
		assertEquals("XLIX", romaniser.romanise(49));
		assertEquals("L", romaniser.romanise(50));
		assertEquals("LX", romaniser.romanise(60));
		assertEquals("LXX", romaniser.romanise(70));
		assertEquals("LXXII", romaniser.romanise(72));
		assertEquals("LXXXVII", romaniser.romanise(87));
		assertEquals("XCVI", romaniser.romanise(96));
		assertEquals("LXXIV", romaniser.romanise(74));
	}
	
	@Test public void testSubNumeral()
	{
		assertEquals("X", romaniser.getSubNumeral(1, 1));
		assertEquals("XL", romaniser.getSubNumeral(4, 1));
		assertEquals("V", romaniser.getSubNumeral(5, 0));
		assertEquals("LXXX", romaniser.getSubNumeral(8, 1));
	}
	
//	@Test public void testCenturies()
//	{
//		assertEquals("C", romaniser.romanise(100));
//	}
}
