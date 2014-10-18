package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(0, Calculator.add("0,0"));
	}	

	@Test
    	public void testMultipleNumbers(){
    		assertEquals(6, Calculator.add("1,2,3"));
    	}

    	@Test
	public void testUnknownNumbers() {		
		int numCount = 4+(int)(Math.random()*(20-4));
		int sum = 0;
		String randStr = "";
		for (int i = 0; i < numCount; i++) {
			int randNum = 1+(int)(Math.random()*(10-1));
			sum += randNum;
			randStr += randNum + ",";
		}
		assertEquals(sum, Calculator.add(randStr));
	}

	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
		assertEquals(6, Calculator.add("1,2\n3"));
	}

	@Test
	public void testDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();	
	@Test
	public void testNegatives() {
		thrown.expect( IllegalArgumentException.class );
		thrown.expectMessage("Negatives not allowed: -4,-5");
		Calculator.add("2,-4,3,-5");
		
	}

	@Test
	public void testOver1k() {
		assertEquals(2, Calculator.add("1001,2"));
		assertEquals(0, Calculator.add("0,1001"));
	}
}
