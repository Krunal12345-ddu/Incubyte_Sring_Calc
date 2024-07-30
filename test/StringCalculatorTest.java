package test;

import junit.framework.Assert;
import main.StringCalculator;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	
	private StringCalculator st;
	
	@Before
	public void setup(){
		st = new StringCalculator();
	}
	
	@Test
	public void testAddEmpty(){
		
		String str = "";
		
		Assert.assertEquals(0, st.add(str));
	}

    @Test
    public void testAddOne(){
		
		String str = "1";
		
		Assert.assertEquals(1, st.add(str));
	}

    @Test
	public void testAddTwoDelimitedByComma(){
		
		String str = "1,3";
		
		Assert.assertEquals(4, st.add(str));
	}

    @Test
	public void testAddTwoDelimitedByNewLine(){
		
		String str = "1\n2";
		
		Assert.assertEquals(3, st.add(str));
	}

    @Test
	public void testAddThreeDelimitedByBoth(){
		
		String str = "1\n2,3";
		
		Assert.assertEquals(6, st.add(str));
	}

    @Test(expected=Exception.class)
	public void testAddNegativeException() throws Exception{
		
		String str = "-1";
		
		st.add(str);
	}

    @Test
	public void testIgnoreGreaterThan1000() throws Exception{
		
		String str = "1\n4,1005";
		
		Assert.assertEquals(5, st.add(str));
	}

    @Test
	public void testCustomDelimiter1() throws Exception{
		
		String str = "//;\n1;4;8";
		
		Assert.assertEquals(13, st.add(str));
	}

   

}