import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class StringCal{
	public static void main(String args[]){
		ReturnZeroIfNull();
		ReturnNumbersIfNotNull();
		ReturnSumIfDelimByComma();
		ReturnSumIfDelimByNewLine();
		ReturnSumWhenDiffDelim();
		SplitUsingCustomDelim();
	}
	
	public static int add(String str){
		if(str == ""){
			return 0;
		}
		else if(str.contains(",")){
			String[] numbers = tokens(str,",|\n");
			
			return compute(numbers);
		}
		else if(str.startsWith("//")){
			Pattern p = Pattern.compile("//(.)\n(.*)");
			Matcher m = p.matcher(str);
			boolean b = m.matches();
			if(m.matches()){
			String delim = m.group(1);
			String num = m.group(2);
			
			String numbers[] = tokens(num,Pattern.quote(delim));
			return compute(numbers);
			}
			else 
			return 0;
		}
		else{
			return Integer.parseInt(str);
		}
	}
	
	public static void ReturnZeroIfNull(){
		
		compare(0,add(""));
		
	}
	
	public static void ReturnNumbersIfNotNull(){
		
		compare(12,add("12"));
	}
	public static void ReturnSumIfDelimByComma(){

		compare(6,add("1,2,3"));
	}
	
	public static void ReturnSumIfDelimByNewLine(){

		compare(6,add("1\n2,3"));
	}
	
	public static void ReturnSumWhenDiffDelim(){
		compare(3,add("//;\n1;2"));
	}
	public static void SplitUsingCustomDelim(){
		compare(3,add("//.\n1.2"));
	}
	
	public static String[] tokens(String s1, String s2) {
		String tokens[] = s1.split((s2));
		return tokens;
	}
	public static int compute(String[] numbers){
		int j = 0;
		for (int i = 0;i<numbers.length;i++){
				j = j + Integer.parseInt(numbers[i]);
			}
			return j;
	}
	public static void compare(int sum, int val){
		if(sum == val){
			System.out.println("OK - " + sum);
		}
		else{
			System.out.println("NOT OK");
		}
	}
}