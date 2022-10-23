package com.hackerthon.controller;

import com.hackerthon.bo.BOFactory;
import com.hackerthon.bo.custom.EmployeeBO;
import com.hackerthon.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeController {

	static EmployeeBO bo = (EmployeeBO) BOFactory.getInstance().getBOType(BOFactory.BOType.EMPLOYEE);

	public boolean addEmployee(Employee employee) throws SQLException, Exception {
		return bo.addEmployee(employee);
	}

	public boolean deleteEmployee(String id) throws SQLException, Exception {
		return bo.deleteEmployee(id);
	}

	public boolean updateEmployee(Employee employee) throws SQLException, Exception {
		return bo.updateEmployee(employee);
	}

	public Employee searchEmployee(String id) throws SQLException, Exception {
		return bo.searchEmployee(id);
	}

	public ArrayList<Employee> getAllEmployee() throws SQLException, Exception {
		return bo.getAllEmployee();
	}

}
