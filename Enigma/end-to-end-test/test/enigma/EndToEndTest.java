package test.enigma;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import enigma.Enigma;
import enigma.Reflector;
import enigma.ReflectorType;
import enigma.Rotor;
import enigma.RotorType;



public class EndToEndTest {
	LoggingLamps lamps = new LoggingLamps();
	
	@Test
	public void encryptsInput() {
		Enigma wermachtStandard = new Enigma(lamps, 
				new Reflector(ReflectorType.B), 
				new Rotor(RotorType.I), 
				new Rotor(RotorType.II), 
				new Rotor(RotorType.III));
		assertConverts(wermachtStandard, "Hello world", "ILBDAAMTAZ");
	}
	
	private void assertConverts(Enigma enigma, String inputString,
			String outputString) {
		for (char next : enigmatize(inputString)) {
			enigma.input(next);
		}
		assertThat(lamps.characters(), equalToOutput(outputString));
	}

	private Matcher<List<Character>> equalToOutput(String string) {
		List<Character> expected = new ArrayList<Character>();
		for (char next: string.toCharArray()) {
			expected.add(new Character(next));
		}
		return equalTo(expected);
	}

	private char[] enigmatize(String inputString) {
		String uppercase = inputString.toUpperCase();
		String deblanked = uppercase.replace(" ", "");
		return deblanked.toCharArray();
	}

}
