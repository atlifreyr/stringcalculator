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
			int index = text.indexOf( '-', 0 );
			while(index != -1){
				String neg = text.substring(index,index+2);
				ex += neg + ",";
				index = text.indexOf( '-', index+1 );
			}
			ex = ex.substring(0, ex.length()-1);
			throw new IllegalArgumentException(ex);

		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
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
			total += toInt(number);
		}
		return total;
	}
}
