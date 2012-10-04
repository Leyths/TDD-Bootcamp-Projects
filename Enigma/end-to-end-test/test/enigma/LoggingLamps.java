package test.enigma;


import java.util.ArrayList;
import java.util.List;

import enigma.Lamps;

public class LoggingLamps implements Lamps {
	private List<Character> characters = new ArrayList<Character>();

	@Override
	public void light(char output) {
		characters.add(new Character(output));
	}
	
	public List<Character> characters() {
		return characters;
	}

}
