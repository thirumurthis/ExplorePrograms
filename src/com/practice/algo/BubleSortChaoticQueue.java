package com.practice.algo;

import java.util.HashMap;
import java.util.Map;

public class BubleSortChaoticQueue {
	
	public static void main(String[] args) {
		//int qSize = 5;
		int input1[] =  {2,1,5,3,4};
		System.out.println(chaoticqminBribe(input1));
		int input2[] = {2,5,1,3,4};
		System.out.println(chaoticqminBribe(input2));
		int input3[] = {1, 2, 5, 3, 7, 8, 6, 4};
		System.out.println(chaoticqminBribe(input3));
		
	}
	
	public static String chaoticqminBribe(int[] q) {
		int minBribe = 0;
		Map<Integer,Integer> bribeTracker = new HashMap<>();
		for(int j=0;j<q.length-1;j++)
		for (int i =j; i< q.length-1;i++) {
			//System.out.println(q[i]+" "+q[i+1]);
			if(q[i]>q[i+1]) {
				
				//swap or bribed 1's
				if(!bribeTracker.containsKey(q[i])) {
					//first encounter of bribe
					bribeTracker.put(q[i], 1);
					minBribe +=1;
				}else {
					//second encounter of bribe
					bribeTracker.put(q[i], bribeTracker.get(q[i])+1);
					minBribe +=1;
				}
				//bribeTracker.forEach((k,v)->{System.out.println(">>>"+k+" - "+v);});
				//System.out.println("----- "+minBribe);
				if(!bribeTracker.isEmpty() && bribeTracker.get(q[i])>2) {
					minBribe = -1;
					break;
				}
				int temp = q[i];
				q[i] = q [i+1];
				q[i+1] = temp;
			}
			
		}
		
		return minBribe>0?(minBribe+""):"Too Chaotic";
	}

}
