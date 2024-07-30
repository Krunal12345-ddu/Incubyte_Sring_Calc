package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static String delimiter;
	
	public int add(String number)throws Exception{
		if (number.isEmpty()) return 0;
		
		if (number.startsWith("//"))
			number = customDelimiter(number);
		else
			this.delimiter = ",|\n";
		
		findException(number);
		
		if(number.length() > 1){
			String a[] = number.split(delimiter);
			return findSum(a);
		}
		
		return Integer.parseInt(number);
	}
	
	private String customDelimiter(String number){
		Pattern p = Pattern.compile("//(.*)\n(.*)");
		Matcher m = p.matcher(number);
		m.matches();
		this.delimiter = Pattern.quote(m.group(1));
		return m.group(2);
	}
	
	private int findSum(String[] numbers){
		int sum = 0;
		for(String i : numbers){
			if (Integer.parseInt(i) <= 1000)
				sum += Integer.parseInt(i);
		}
		return sum;
	}
	
	private void findException(String number) throws Exception{
		String a[] = number.split(delimiter);
		List<Integer> list = new ArrayList<Integer>();
		for(String i : a){
			if(Integer.parseInt(i) < 0)
				list.add(Integer.parseInt(i));
		}
		if(!list.isEmpty())
			throw new Exception("Negative number:" + list);
	}

}