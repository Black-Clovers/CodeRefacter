package com.hackerthon.bo.custom;

import com.hackerthon.bo.SuperBO;
import com.hackerthon.entity.Employee;

import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
	boolean addEmployee() throws Exception;

	boolean deleteEmployee(String id) throws Exception;

	Employee searchEmployee(String id) throws Exception;

	ArrayList<Employee> getAllCustomers() throws Exception;

	void loadAllEmployees() throws Exception;

}
