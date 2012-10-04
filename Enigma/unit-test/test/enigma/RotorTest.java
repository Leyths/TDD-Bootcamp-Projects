package test.enigma;

import static org.junit.Assert.*;

import org.junit.Test;

import enigma.Rotor;
import enigma.RotorType;

public class RotorTest {

	@Test
	public void testRotorIMapsAToEInPositionA() {
		Rotor rotor = new Rotor(RotorType.I);
		rotor.setPosition('A');
		assertEquals('E', rotor.codeInput('A'));
	}
	
	@Test
	public void testRotorIMapsBToKInPositionA() {
		Rotor rotor = new Rotor(RotorType.I);
		rotor.setPosition('A');
		assertEquals('K', rotor.codeInput('B'));
	}
	
	@Test
	public void testRotorIMapsAToJInPositionB() {
		Rotor rotor = new Rotor(RotorType.I);
		rotor.setPosition('B');
		assertEquals(String.valueOf('J'), String.valueOf(rotor.codeInput('A')));
	}
	
	@Test
	public void testRotorIIIMapsAToBInPositionA() {
		Rotor rotor = new Rotor(RotorType.III);
		rotor.setPosition('A');
		assertEquals(String.valueOf('B'), String.valueOf(rotor.codeInput('A')));
	}
	
	@Test
	public void testRotorIIMapsGToXInPositionY() {
		Rotor rotor = new Rotor(RotorType.II);
		rotor.setPosition('Y');
		assertEquals(String.valueOf('X'), String.valueOf(rotor.codeInput('G')));
	}
}
