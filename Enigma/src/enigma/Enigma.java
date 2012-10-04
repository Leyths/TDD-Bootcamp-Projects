package enigma;




public class Enigma implements KeyboardListener {


	private final Lamps lamps;
	private Reflector reflector;
	private Rotor rotorRight;
	private Rotor rotorMiddle;
	private Rotor rotorLeft;

	public Enigma(Lamps lamps, Reflector ref, Rotor left, Rotor middle, Rotor right) {
		this.lamps = lamps;
		this.reflector = ref;
		this.rotorLeft = left;
		this.rotorMiddle = middle;
		this.rotorRight = right;
	}

	@Override
	public void input(char input) {
		rotorRight.incrementRotor();
		char encodedInput = code(input);
		lamps.light(encodedInput);
	}
	
	private char code(char input)
	{
		char currentCoded = rotorRight.codeInput(input);
		currentCoded = rotorMiddle.codeInput(currentCoded);
		currentCoded = rotorLeft.codeInput(currentCoded);
		currentCoded = reflector.reflect(currentCoded);
		currentCoded = rotorLeft.codeOutput(currentCoded);
		currentCoded = rotorMiddle.codeOutput(currentCoded);
		currentCoded = rotorRight.codeOutput(currentCoded);
		
		return currentCoded;
	}

}
