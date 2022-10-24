package com.hackerthon.dao.custom;

import com.hackerthon.dao.CrudDAO;
import com.hackerthon.entity.Employee;

import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee, String> {// create the interface class to implement the methods

	void getEmployeeOutPut(ArrayList<Employee> employeeList)
			throws Exception;// This method is used to get the employee output
}
