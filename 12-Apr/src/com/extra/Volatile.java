package com.extra; 

public class Volatile {
	private volatile int counter = 0;   
	public int getCounter()   
	{  
	return counter;  
	}  
	public void increaseCounter()   
	{  
	++counter;      //increases the value of counter by 1   
	}  
	static volatile int var =5;  
	public static void main(String[] args) {
		
	}

}
