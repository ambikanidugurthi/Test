package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.IntRange;
import org.springframework.scheduling.config.ExecutorBeanDefinitionParser;

public class ExecutorServiceTest {

	public static void main(String[] args) {
		
		String[] str = new String[4];
		str[0]= "eee";
		str[1]= "bbb";
		str[2]= "aaa";
		str[3]= "ddd";
		
		Collections.sort(Arrays.asList(str)); 
		
		Stream.of(str).sorted().forEach(System.out::println);
		
		String str1 = "Ambika Nidugurthi".toUpperCase();
		
		for(int i =0 ; i < str1.length();i++) {
			char tmp = str1.charAt(i);
			int count = 0;
			for(int j =0 ;j <str1.length();j++) {
				if(str1.charAt(j)== tmp) {
					count++;
				}
			}
			System.out.print(tmp+""+count);
			
		}
		System.out.print("------------------------------------------");

		int x = 3&5;
		int y = 3|5;
		System.out.println("x= "+x+" y= "+y);
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		es.execute(()->{
			for(int i =1 ;i<= 100;i++) {
			System.out.println(String.format("starting expensive task thread %s", Thread.currentThread().getName()));
			}
		});
		Callable<List<Employee>> callableTask = null;
		List<Employee> list = new ArrayList<>();
		
		Future<List<Employee>> res = es.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            for(int i =1 ;i<= 100;i++) {
            	//System.out.println(String.format("starting expensive task thread %s", Thread.currentThread().getName()));
            	Employee e1 = new Employee();
                e1.setId(i);
                e1.setName("emp"+i);
                e1.setAddress("street"+i);
                list.add(e1);
            }            
            return list;
        });
        try {
			System.out.println(res.get());
		} catch (InterruptedException | ExecutionException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
	}
}


class Employee {
	private String name;
	private int id;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", address=" + address + "]";
	}
	
	
}