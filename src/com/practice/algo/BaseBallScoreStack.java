package com.practice.algo;

import java.util.Stack;

public class BaseBallScoreStack {

	public static void main(String[] args) {
		BaseBallScoreStack baseBall = new BaseBallScoreStack();
		//String [] ops = {"5","2","C","D","+"};
		String [] ops = {"5","-2","4","C","D","9","+","+"};
		System.out.println(baseBall.calPoints(ops));
	}
	
	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int sum= 0;
		for(int i=0 ; i < ops.length; i++) {
			try {
				int value = Integer.parseInt(ops[i]);
				sum += value;
				System.out.println(String.format("NUMBER Value = %d, Sum= %d", value,sum));
				stack.push(value);
			}catch(NumberFormatException exe) {
				
				if("C".equals(ops[i])) {
					sum -= stack.pop();
					System.out.println(String.format("C Value = X, Sum= %d", sum));
				}
				if("D".equals(ops[i])) {
					int value = 2*(stack.peek());
					sum += value;
					stack.push(value);
					System.out.println(String.format("D Value = %d, Sum= %d", value,sum));
				}
				if("+".equals(ops[i])) {
					int lastValid = stack.pop();
					int nextlastValid = stack.pop();
					stack.push(nextlastValid);
					stack.push(lastValid);
					stack.push(lastValid+nextlastValid);
					sum += (lastValid+nextlastValid);
					System.out.println(String.format("+ nextlastvalid, nextlastvalid, Value = %d, Sum= %d",nextlastValid,lastValid, lastValid+nextlastValid,sum));
					
				}
			}
		}
		stack=null;
		return sum;
	}
}
