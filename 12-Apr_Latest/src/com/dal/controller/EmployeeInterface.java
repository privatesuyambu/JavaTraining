package com.dal.controller;

import java.io.IOException;

public interface EmployeeInterface {
	public void addEmployee();
	public void viewEmployee() ;
	public void sortByEmpId();
	public void sortByEmpName();	
	public void serialiseemp() throws IOException;
	public void deserialiseemp() throws IOException;
	public void updateEmployee();
	public void deleteEmployee(int id);;
}
