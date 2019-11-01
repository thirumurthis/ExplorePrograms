package com.practice.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors; 

class CheckedExceptionEx { 
	public static void main(String[] args) { 
/*		FileReader file = new FileReader("C:\\test\\a.txt"); 
		BufferedReader fileInput = new BufferedReader(file); 
		
		// Print first 3 lines of file "C:\test\a.txt" 
		for (int counter = 0; counter < 3; counter++) 
			System.out.println(fileInput.readLine()); 
		
		fileInput.close();
		*/ 
		List<Sample> list = new ArrayList<>();
		list.add(new CheckedExceptionEx().new Sample(1,"one"));
		list.add(new CheckedExceptionEx().new Sample(2,"two"));
		list.add(new CheckedExceptionEx().new Sample(3,"three"));
	    Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(Sample::getId, Sample::getName));
	    result1.forEach((k,v) -> System.out.println(k+","+v));
	} 
	
	class Sample {
		//		 
		private int id;
		public Sample(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


	}
} 
