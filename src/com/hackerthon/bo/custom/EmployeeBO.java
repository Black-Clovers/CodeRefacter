package com.hackerthon.bo.custom;

import com.hackerthon.bo.SuperBO;
import com.hackerthon.entity.Employee;

import java.util.ArrayList;

public interface EmployeeBO extends SuperBO { // create the interface class to implement the methods
	void addEmployee() throws Exception;// This method is used to add the employee to the database

	boolean deleteEmployee(String id) throws Exception;// This method is used to delete the employee from the database

	Employee searchEmployee(String id) throws Exception;// This method is used to search the employee from the database

	ArrayList<Employee> getAllEmployee()
			throws Exception;// This method is used to get all the employee from the database

	void loadAllEmployees() throws Exception;// This method is used to load all the employee

}
