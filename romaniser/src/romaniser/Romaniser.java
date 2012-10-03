package romaniser;

import java.util.HashMap;

public class Romaniser {
	
	private static Integer[] baseArabic = {0,   1,   5,   10,  50,  100, 500, 1000};
	private static String[] baseRoman =   {"", "I", "V", "X", "L", "C",  "D", "M"};
	
	public static void main(String[] args)
	{
		Romaniser r = new Romaniser();
		for(int i=0; i<=500; i++)
			System.out.println(i+" | "+r.romanise(i));
	}

	
	/**
	 * Given 
	 * @param number Base 0-9
	 * @param powOften Multiple, eg if number = 6 and multiple = 1 the numeral wanted is 60 (6*(10^1))
	 * @return
	 */
	public String getSubNumeral(int number, int powOfTen)
	{
		int totalNum = (int) (number*(Math.pow(10, powOfTen)));
		System.out.println("Working out subnumeral of "+totalNum);
		
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
		for(int i=0; i<=lower; i++)
		{
			if((baseArabic[upper] - baseArabic[i]) == totalNum) // Eg 9 => IX or 40 => XL
				return baseRoman[i]+baseRoman[upper];
		}
		String numeral = baseRoman[lower];
		int remainder = totalNum-baseArabic[lower];
		numeral += getSubNumeral(remainder, 0);
		return numeral;
	}
	
	public String romanise(int number) {
		System.out.println("Romanising "+number);
		String roman = "";
		String convertedNum = ((Integer)number).toString();
		for(int i=0; i<convertedNum.length(); i++)
		{
			roman = getSubNumeral(Integer.parseInt(((Character)convertedNum.charAt(convertedNum.length()-i-1)).toString()), i)+roman;
		}
		return roman;
	}

}
