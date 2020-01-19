package com.practice.algo;
/*
https://leetcode.com/problems/roman-to-integer/
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
*/
public class RomanTest {
	
	public static void main(String[] args) {
		String s = "IV";
		
		RomanTest roman = new RomanTest();
		System.out.println(s+" = "+ roman.roman(s));
	}
	
	public Integer roman(String s) {
		
		char previous='?';
		Integer output=0;
		for (int i=0; i<s.length(); i++) {
			if(i>=1 && i<s.length()) {
			  previous = s.charAt(i-1);
			}
			switch (s.charAt(i)) {
			case 'I':
				output = output+1;
				break;
			case 'V':
				output = output+5;
				if (previous == 'I') {
					output = output-2;
				}
				break;
			case 'X':
				output = output+10;
				if (previous == 'I') {
					output = output-2;
				}
				break;
			case 'L':
				output = output+50;
				if (previous == 'X') {
					output = output-20;
				}
				break;
			case 'C':
				output = output+100;
				if (previous == 'X') {
					output = output-20;
				}
				break;
			case 'D':
				output = output+500;
				if (previous == 'C') {
					output = output-200;
				}
				break;
			case 'M':
				output = output+1000;
				if (previous == 'C') {
					output = output-200;
				}
				break;
			default:
				break;
			}
		}
		
		return output;
	}

}
