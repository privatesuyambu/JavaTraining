package com.dal.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.dal.exception.UserNotFoundException;
import com.dal.model.Employee;
import java.util.Collections;
import java.io.*;

import com.dal.dao.EmployeeDaoImplmentation;
import com.dal.dao.EmployeeDao;

import com.dal.model.Employee;

public class EmployeeController implements EmployeeInterface {
	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	UserNotFoundException obj = new UserNotFoundException();
	EmployeeDao dao = new EmployeeDaoImplmentation();
	
	public void addEmployee()
	{		
		
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eid");
		int eid= sc.nextInt();
		emp.setEid(eid);
		
		System.out.println("Enter Ename");
		String ename= sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		
		dao.insertEmployee(emp);
		System.out.println("Employee Added Succesfully");
		
	}
	
	public void viewEmployee() {
		//System.out.println(emp);
//		Iterator i = emplist.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
		//emplist.forEach(emplist->System.out.println(emplist));
			//emplist.forEach(System.out::println);// Use of Foreach and lambda in this 10th Mayx`
		//}
		dao.showEmployee();
	}
		
	
		
		public void serialiseemp() throws IOException
		{
			try{
			
		
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(emplist);
			System.out.println("Serialized to file dedalus.txt");
			oos.close();
			fos.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
		}
		
		public  void deserialiseemp() throws IOException
		{
			try{
			
		
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			List<Employee> emp = (List<Employee>)ois.readObject();
			
			System.out.println("DeSerilized from file dedalus.txt");
			System.out.println(emp);
			//System.out.println(emp.getEname());
			ois.close();
			fis.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
			}

		}
		@Override
		public void sortByEmpId() {
			// TODO Auto-generated method stub
			Collections.sort(emplist);
			System.out.println("After sorting by EID");
			System.out.println(emplist);
			
		}

		@Override
		public void sortByEmpName() {
			// TODO Auto-generated method stub
			Collections.sort(emplist, Employee.NameComparator);
			System.out.println(emplist);
			
		}

		@Override
		public void updateEmployee() {
			dao.updateEmployee(emp);
			
		}

		@Override
		public void deleteEmployee(int id) {
			dao.deleteEmployee(id);
		}
	
	
}
