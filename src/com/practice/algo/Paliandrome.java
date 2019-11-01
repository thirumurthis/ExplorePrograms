package com.practice.algo;

public class Paliandrome {
	
	public static void main(String args[]) {
		int input = 121;
		System.out.println(input+ " is a paliandrome ? "+paliandrome(input));
		 input = 1221;
		System.out.println(input+" is a paliandrome ? "+paliandrome(input));
		 input = 12121;
			System.out.println(input+" is a paliandrome ? "+paliandrome(input));
			input = 13121;
			System.out.println(input+" is a paliandrome ? "+paliandrome(input));
	}
	
	public static boolean paliandrome(int input) {
		int cntr =0;
		int a[] = new int[100];
		while (input !=0) {
			a[cntr]=input%10;
			input = input/10;
			++cntr;
		}
		if(cntr ==1 || cntr ==0) return false;
		for (int startindx=0,lastindx=cntr-1;startindx<cntr-1 && lastindx>0;startindx++,lastindx--)
				if(a[startindx]==a[lastindx])
				   continue;
				else
				   return false;
		return true;
	}

}
