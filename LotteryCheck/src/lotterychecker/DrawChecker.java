package lotterychecker;
import java.util.Date;


public class DrawChecker {
	
	Draw draw;
	
	public DrawChecker()
	{
		draw = new Draw();
	}

	public boolean hasWon(Integer[] numbers, Date date) {
		
		int matchedNumbers = 0;
		for (int i=0; i<draw.winningNumbers.length; i++) {
			for (int k=0; k<numbers.length; k++) {
				if (draw.winningNumbers[i]==numbers[k]) {
					matchedNumbers++;
				}
			}
		}
		if (matchedNumbers > 2) {
			return true;
		} else {
			return false;
		}
	}

	public int prizeAmount(int i, Date date) {
		return draw.prizes[i];
	}
}
