package com.hackerthon.bo.custom.impl;

import com.hackerthon.bo.custom.EmployeeBO;
import com.hackerthon.entity.Employee;

import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

	@Override public boolean addEmployee(Employee employee) throws Exception {
		return false;
	}

	@Override public boolean deleteEmployee(String id) throws Exception {
		return false;
	}

	@Override public boolean updateEmployee(Employee employee) throws Exception {
		return false;
	}

	@Override public Employee searchEmployee(String id) throws Exception {
		return null;
	}

	@Override public ArrayList<Employee> getAllEmployee() throws Exception {
		return null;
	}
}
