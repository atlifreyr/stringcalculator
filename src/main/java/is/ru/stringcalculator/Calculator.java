package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("//")){
			return sum(splitDelimiter(text, getDel(text)));
		}
		else if(text.contains("-")){
			String ex = "Negatives not allowed: ";
			ex += getNegatives(text);
			throw new IllegalArgumentException(ex);

		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static String getNegatives(String numbers){
		String neg = "";
		int index = numbers.indexOf( '-', 0 );
		while(index != -1){
			String num = numbers.substring(index,index+2);
			neg += num + ",";
			index = numbers.indexOf( '-', index+1 );
		}
		neg = neg.substring(0, neg.length()-1);
		return neg;
	}
	private static String getDel(String numbers){
		return Character.toString(numbers.charAt(2));
	}
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}
	private static String[] splitDelimiter(String numbers, String del) {
		return (numbers.substring(4)).split(del);
        }
	private static int sum(String[] numbers){
		int total = 0;
        	for(String number : numbers){
			if(Integer.parseInt(number) <= 1000) total += toInt(number);
		}
		return total;
	}
}
