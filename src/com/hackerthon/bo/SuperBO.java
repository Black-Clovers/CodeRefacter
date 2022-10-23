package com.hackerthon.bo;

import com.hackerthon.entity.Employee;

import java.util.ArrayList;

public interface SuperBO {
	boolean addEmployee(Employee employee) throws Exception;

	boolean deleteEmployee(String id) throws Exception;

	boolean updateEmployee(Employee employee) throws Exception;

	Employee searchEmployee(String id) throws Exception;

	ArrayList<Employee> getAllEmployee() throws Exception;
}
