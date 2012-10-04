package enigma;

public class Rotor {

	RotorType type;
	char position = 'A';
	
	public Rotor(RotorType rotortype) {
		this.type = rotortype;
	}

	public void setPosition(char position) {
		this.position = position;
	}

	public char codeInput(char inputchar) {
		int offset = position - 'A';
		int charIndexInAlphabet = RotorType.ALPHABET.map().indexOf(inputchar);
		
		int offsettedPosition = (charIndexInAlphabet - offset) % 26;
		if (offsettedPosition < 0)
			offsettedPosition += 26;

		return type.map().charAt(offsettedPosition);
	}
	
	public char codeOutput(char inputchar) {
		int offset = position - 'A';
		int charIndexInMap = type.map().indexOf(inputchar);
		
		int offsettedPosition = (charIndexInMap - offset) % 26;
		if (offsettedPosition < 0)
			offsettedPosition += 26;

		return RotorType.ALPHABET.map().charAt(offsettedPosition);
	}
	
	private void incrementRotor()
	{
		
	}

}
