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
		int charIndexShifted = (charIndexInAlphabet + offset) % 26;
		
		int charInputTemp = type.map().charAt(charIndexShifted);
		
		int offsettedPosition = (RotorType.ALPHABET.map().indexOf(charInputTemp) - offset) % 26;
		if (offsettedPosition < 0)
			offsettedPosition += 26;

		return RotorType.ALPHABET.map().charAt(offsettedPosition);
	}
	
	public char codeOutput(char inputchar) { 
		int offset = position - 'A';
		int positionInAlphabet = inputchar - 'A';
		int rotatedInputCharPosition = (positionInAlphabet + offset) % 26;
			if (rotatedInputCharPosition < 0)
				rotatedInputCharPosition += 26;
		char character = RotorType.ALPHABET.map().charAt(rotatedInputCharPosition);
		int charIndexInMap = type.map().indexOf(character);
		
		int offsettedPosition = (charIndexInMap - offset) % 26;
		if (offsettedPosition < 0)
			offsettedPosition += 26;

		return RotorType.ALPHABET.map().charAt(offsettedPosition);
	}
	
	public void incrementRotor()
	{
		position++;
	}

}
