package com.practice.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solutions{        
 List<List<String> > limitedProductSuggestions(int numProducts, 
                                             List<String> listOFProduct, 
                                             String userInput)
 {
     
      //variable to store the list
	    List<List<String>> matchingResult = new ArrayList<List<String>>();
	     if(userInput!=null && !"".equals(userInput) 
      		 && userInput.length() >2        		 
      		 && listOFProduct!=null && listOFProduct.size()>0) {
      	 for(int i=2;i<=userInput.length();i++) {
      		 int j =i;
      		 Predicate<String> stringCheck = a -> a.toLowerCase().startsWith(userInput.toLowerCase().substring(0,j));
      		matchingResult.add(listOFProduct.stream().filter(stringCheck).sorted().limit(3).collect(Collectors.toList()));
      	 }
       }
          return matchingResult;
  }
 
 
 public static void main(String...strings ) {
	 
	 Solutions s = new Solutions();
	 int numProducts = 5;
	 List<String> repository = new ArrayList<String>();
	 repository.add("mobile");
	 repository.add("mouse");
	 repository.add("moneypot");
	 repository.add("monitor");
	 repository.add("mousepad");
	 repository.add("baggage");
	 //repository.add("bag");
	 repository.add("bags");
	 repository.add("banner");
	 repository.add("coder");
	 repository.add("coalphone");
	 repository.add("coalgate");
	 repository.add("cored");
	 repository.add("codes");
	 //String userInput= "mouse";
	 //String userInput= "bags";
	 String userInput= "coder";
	 System.out.println(s.threeProductSuggestions(numProducts, repository, userInput));
 }
}
