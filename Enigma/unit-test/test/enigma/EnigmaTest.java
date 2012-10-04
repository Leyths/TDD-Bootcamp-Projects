package test.enigma;

import static org.junit.Assert.*;

import org.junit.Test;

import enigma.Reflector;
import enigma.ReflectorType;
import enigma.Rotor;
import enigma.RotorType;

public class EnigmaTest {

	@Test
	public void testIdentityReflectorReflectsAToAWithRotorIinPositionA() {
		Rotor rotor = new Rotor(RotorType.I);
		Reflector reflector = new Reflector(ReflectorType.ALPHABET);
		rotor.setPosition('A');
		
		char output = rotor.codeInput('A');
		System.out.println(output);
		output = reflector.reflect(output);
		System.out.println(output);
		output = rotor.codeOutput(output);
		
		assertEquals(String.valueOf('A'), String.valueOf(output));
	}

}
