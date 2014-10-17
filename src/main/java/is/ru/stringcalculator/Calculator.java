package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("//")){
			String delimiter = Character.toString(text.charAt(2));
			String newStr = text.substring(4);
			return sum(splitDelimiter(newStr, delimiter));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}
	private static String[] splitDelimiter(String numbers, String del) {
		return numbers.split(del);
        }
	private static int sum(String[] numbers){
		int total = 0;
        	for(String number : numbers){
			total += toInt(number);
		}
		return total;
	}



}
