package com.dal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.BiPredicate;

import com.dal.controller.EmployeeController;
import com.dal.controller.EmployeeInterface;
import com.dal.exception.UserNotFoundException;
//import com.model.Employee;

public class MainClass {

	public static void main(String[] args) throws IOException 
	{

		EmployeeInterface econtol = new EmployeeController();

		Scanner sc = new Scanner(System.in);
		String Choice = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bsr = new BufferedReader(isr);
		try {
			
			// Use of inputsteamreader and buffered reader
		/*	String uname = null;
			String pwd = null;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bsr = new BufferedReader(isr);
			System.out.println("Enter Username:");
			uname = bsr.readLine();
			System.out.println("Enter password:");
			pwd = bsr.readLine();

			if (uname.equals("jbh") && pwd.equals("abc")) {
				System.out.println("Welcome " + uname);
			} else {
				throw new UserNotFoundException();

			}*/
			
			//10th Apr Use of BiPredicate to perform username and password validation
			String uname = null;
			String pwd = null;
			
			System.out.println("Enter Username:");
			uname = bsr.readLine();
			System.out.println("Enter password:");
			pwd = bsr.readLine();
			
			BiPredicate<String,String> res = (username,passwrd) -> username.equals("JBH");
				
			BiPredicate<String, String> res1 = (username, passwrd) -> passwrd.equals("abc");
			//if username is JBH then welcome else welcome guest
			if (res.and(res1).test(uname,pwd)) {
				System.out.println("Welcome ");
			} else {
				throw new UserNotFoundException();
			}
		}	

		catch (UserNotFoundException unf) {
			System.out.println(unf);
			return;
		} finally {
			System.out.println("Finally block");
		}

		do {
			System.out.println("enter your choice");
			System.out.println(("1. Add Employee"));
			System.out.println(("2. View Employee"));
			System.out.println(("3. Serialise Employee"));
			System.out.println(("4. DeSerialise Employee"));
			System.out.println(("5. Sort By EmpId"));
			System.out.println(("6. Sort By EmpName"));
			System.out.println(("7. Update EmpName"));
			System.out.println(("8. Delete employee"));
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				econtol.addEmployee();
				break;
			}

			case 2: {
				econtol.viewEmployee();
				break;
			}
			case 3: {
				econtol.serialiseemp();
				break;	
			}
			case 4: {
				econtol.deserialiseemp();
				break;
			}
			case 5: {
				econtol.sortByEmpId();
				break;
				
			}
			case 6: {
				econtol.sortByEmpName();
				break;
				
			}
			case 7: {
				econtol.updateEmployee();
				break;
				
			}
			case 8: {
				System.out.println("enter the employee id to be deleted");
				int empid=  Integer.parseInt(bsr.readLine());
						econtol.deleteEmployee(empid);
				break;
				
			}
			default: {
				System.out.println(("enter your choice"));
				break;
			}
			
			}
			System.out.println("Do u wanna continue? Y or n");
			Choice = sc.next();

		} while (Choice.equals("Y") || Choice.equals("y"));
		System.out.println("Exited");
		System.exit(0);
	}
	
	

}