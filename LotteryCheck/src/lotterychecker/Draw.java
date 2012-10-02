package lotterychecker;

public class Draw {

	Integer[] winningNumbers = { 1, 2, 3, 4, 5, 6 };
	Integer[] prizes = {0, 0, 0, 430000, 10, 1000000000, 39407};
	
	public Integer[] getNumbers() {
		return winningNumbers;
	}

	public int getPrizeValue(int i) {
		if (i > 0 && i < 7) {
			return prizes[i];
		}
		else {
			return 0;
		}
	}

}
