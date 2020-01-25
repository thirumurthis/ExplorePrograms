package com.practice.algo;

import java.util.Stack;

public class LongestSubstringNoDuplicates {
	
	public static void main(String[] args) {
		String str = "abcabcbb";
		
		LongestSubstringNoDuplicates duplength = new LongestSubstringNoDuplicates();
		if(false) {
		System.out.println(3==duplength.lengthOfLongestSubstring(str));
		str="pwwkew";
		System.out.println(3==duplength.lengthOfLongestSubstring(str));
				str="aab";
		System.out.println(2==duplength.lengthOfLongestSubstring(str));
				str="dvdf";
		System.out.println(3==duplength.lengthOfLongestSubstring(str));
		str=" ";
		System.out.println(1==duplength.lengthOfLongestSubstring(str));
		}
		str = "bbtablud";
		System.out.println(6==duplength.lengthOfLongestSubstring(str));
	}
	
	 public int lengthOfLongestSubstring(String s) {
		 
		 String buildstr = "";
		 Stack<Integer> stack = new Stack<>();
		 int length =0;
		 for(int i=0;i<s.length();i++) {
			 //keep on added char by char to the string,
			 //if the contstructed string contains the character
			 //just get the length of the string -> store in a stack (assume first iteration)
			 //trim the string 
			 //for example dvdf
			 // itr1=d && buildstr=d, itr2=v buildstr=dv, itr3=d (buildstr contains d)
			 // get the length buildstr (dv)= 2 -> push to stack
			 // trim buildstr = vd
			 //itr4=f, buildstr=vdf (no matching char)
			 //additional check if the last buildstr length is greater than stack length
			 // push that value to stack.
			 //one edge case, if the length of input string is " " then simply return input string length
			 
			 if(buildstr.contains(s.charAt(i)+"")) {
				// System.out.println(buildstr);//a
				 length = buildstr.length();//1
				 boolean firstItreation = false;
				 if(stack.empty()) {
					 stack.push(length);//1
					 firstItreation = true;
					 
				 }
				 //3> 2 
				 if(length > stack.peek() && !firstItreation) {
					 stack.push(length);
					 buildstr = buildstr.substring(buildstr.indexOf(s.charAt(i)+"")+1);
				 }else {
					// System.out.println(buildstr+ " - - "+s.charAt(i));
					 buildstr = buildstr.substring(buildstr.indexOf(s.charAt(i)+"")+1);;
					 //System.out.println("after "+buildstr+ " - - "+s.charAt(i));
				 }
				 buildstr = buildstr+s.charAt(i);

			 }else {
				 buildstr = buildstr+s.charAt(i);
			 }
		 }
		 System.out.println(buildstr);
		 if(!stack.empty() && buildstr.length()>stack.peek()) {
			 stack.push(buildstr.length());
		 }
	     return !stack.empty()?stack.pop():s.length();   
	    }
}
