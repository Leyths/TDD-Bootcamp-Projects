package enigma;




public class Enigma implements KeyboardListener {


	private final Lamps lamps;

	public Enigma(Lamps lamps) {
		this.lamps = lamps;
	}

	@Override
	public void input(char input) {
		// your code here
		lamps.light(input);
	}

}
