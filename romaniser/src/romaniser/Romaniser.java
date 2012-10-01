package romaniser;

import java.util.HashMap;

public class Romaniser {

	private static HashMap<Integer, String> unary = new HashMap<Integer, String>();
	private static HashMap<Integer, String> decade = new HashMap<Integer, String>();
	
	private static Integer[] baseArabic = {1, 5, 10, 50, 100};
	private static String[] baseRoman = {"I", "V", "X", "L", "C"};
	
	public Romaniser() {
		initUnary();
		initDecade();
	}
	
	private void initUnary()
	{
		unary.put(0, "");
		unary.put(1, "I");
		unary.put(2, "II");
		unary.put(3, "III");
		unary.put(4, "IV");
		unary.put(5, "V");
		unary.put(6, "VI");
		unary.put(7, "VII");
		unary.put(8, "VIII");
		unary.put(9, "IX");
	}
	
	private void initDecade()
	{
		decade.put(0, "");
		decade.put(10, "X");
		decade.put(20, "XX");
		decade.put(30, "XXX");
		decade.put(40, "XL");
		decade.put(50, "L");
		decade.put(60, "LX");
		decade.put(70, "LXX");
		decade.put(80, "LXXX");
		decade.put(90, "XC");
	}
	
	/**
	 * 
	 * @param number Base 0-9
	 * @param multiple Multiple, eg if number = 6 and multiple = 10 the numeral wanted is 60
	 * @return
	 */
	public String getSubNumeral(int number, int multiple)
	{
		int totalNum = number*multiple;
		
		int upper = 1;
		int lower = 0;
		for(int j=0; j<baseArabic.length; j++) //Iterate through possible base numerals
		{
			if(baseArabic[j] == totalNum) //If exact match return roman numeral
				return baseRoman[j];
			if(baseArabic[upper] > totalNum) //Upper is now larger than required number
			{
				lower = upper-1; //Set lower and return
				break;
			}
			upper++;
		}
		if((baseArabic[upper] - baseArabic[lower]) == totalNum) // Eg 9 => IX or 40 => XL
			return baseRoman[lower]+baseRoman[upper];
		else //Otherwise chain [lower] numeral to make totalNum
		{
			int total = 0;
			String numeral = "";
			while(total != totalNum)
			{
				total += baseArabic[lower];
				numeral += baseRoman[lower];
			}
			return numeral;
		}
	}
	
	public String romanise(int number) {
		int i= number%10;
		String roman = unary.get(i);
		
		i = (int)Math.floor(number/10) * 10;
		roman = decade.get(i)+roman;
		
		System.out.println(number + " " + i + " " + roman);
		return roman;
	}

}
