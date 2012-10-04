package test.enigma;

import static org.junit.Assert.*;

import org.junit.Test;

import enigma.Reflector;
import enigma.ReflectorType;

public class ReflectorTest {

	@Test
	public void testReflectorTypeBReflectsAToY() {
		Reflector reflectorTypeB = new Reflector(ReflectorType.B);
		assertEquals("Y", String.valueOf(reflectorTypeB.reflect('A')));
	}
	
	@Test
	public void testReflectorTypeCReflectsLToZ() {
		Reflector reflectorTypeC = new Reflector(ReflectorType.c);
		assertEquals("Z", String.valueOf(reflectorTypeC.reflect('L')));
	}

}
