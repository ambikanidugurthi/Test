package com.example.demo;

import java.util.Properties;
import java.util.stream.IntStream;

public class Test {

	public static void main(String... args) {
		
		Properties p = new Properties();
		String s = p.getProperty("a");
		p.setProperty("b", "value");
		 s += p.getProperty("b");
		 
		 System.out.println(s);
		 
		//1.
			System.out.println("Method 1");
			IntStream.range(1, 10).forEach(
	                val -> System.out.println(val)
	        );
	    
	    System.out.println("Method 2");
	    //range excludes the 
	    IntStream.range(1, 10).forEach(System.out::println);
	    
	    	System.out.println("Using rangeClosed");
	    //rangeClosed includes the number
	    IntStream.rangeClosed(1, 10).skip(5).forEach(System.out::println);
	    
	}

}
