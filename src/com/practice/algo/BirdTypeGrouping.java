package com.practice.algo;

import java.util.Arrays;

public class BirdMinSitings {
	
	public static void main(String[] args) {
		
		//int input[] = {1,1,2,2,3};
		int input[] = {1,4,4,4,5,3};
		BirdMinSitings bird = new BirdMinSitings();
		System.out.println(bird.lowestMigratory(input));
		System.out.println("=====================");
		int input1[] = {1,1,2,2,3};
		System.out.println(bird.lowestMigratory(input1));
		System.out.println("=====================");
		int input2[] = {1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
		System.out.println(bird.lowestMigratory(input2));
		System.out.println("=====================");
	}
	
	public int lowestMigratory(int arr[]){
		
		//Map<String, Integer> result = new HashMap<>();
		int birdtypecnt[]= {0,0,0,0,0};
		for(int i=0;i<arr.length;i++) {
			birdtypecnt[arr[i]-1]++;
		}
		
		int previouscnt =birdtypecnt[0]; int index =0;
		for(int i=1;i<birdtypecnt.length;i++) {
			if(birdtypecnt[i]>previouscnt) {
				previouscnt= birdtypecnt[i];
				index =i;
			}
		}
		//Arrays.stream(birdtypecnt).mapToObj(Integer::new).forEach(a->{System.out.print(a+", ");}) ;
		System.out.println();
		return index+1;
	}

}
