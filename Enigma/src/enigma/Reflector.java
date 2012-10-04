package enigma;

public class Reflector {
	
	ReflectorType type;
	
	public Reflector(ReflectorType reflectortype) {
		this.type = reflectortype;
	}

	public char reflect(char inputchar) {
		int charIndexInAlphabet = ReflectorType.ALPHABET.map().indexOf(inputchar);
		return type.map().charAt(charIndexInAlphabet);
	}
	
}
