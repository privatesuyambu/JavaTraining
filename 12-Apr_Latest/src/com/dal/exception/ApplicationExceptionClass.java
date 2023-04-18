package com.dal.exception;

import java.io.*;

class ApplicationExceptionClass {

	public static void main(String[] args) throws IOException
	{
		try
		{
		// TODO Auto-generated method stub
		String uname = null;
		String pwd = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bsr = new BufferedReader(isr);
		System.out.println("Enter Username:");
		uname=bsr.readLine();
		System.out.println("Enter password:");
		pwd= bsr.readLine();

		if(uname.equals("jbh") && pwd.equals("abc"))
		{
			System.out.println("Welcome " + uname);
		}
		else{
			throw new UserNotFoundException();
		
		}
		}
			
		catch(UserNotFoundException unf)
		{
			System.out.println(unf);
		}

	}
}
