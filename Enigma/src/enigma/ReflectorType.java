package enigma;


public enum ReflectorType {
	ALPHABET("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
	B("YRUHQSLDPXNGOKMIEBFZCWVJAT"),
	c("FVPJIAOYEDRZXWGCTKUQSBNMHL");
	private final String map;
	public String map() { return map; }
	ReflectorType(String map) { this.map = map; }
}
