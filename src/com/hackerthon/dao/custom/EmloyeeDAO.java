package com.hackerthon.dao.custom;

import com.hackerthon.dao.CrudDAO;
import com.hackerthon.entity.Employee;

import java.util.ArrayList;

public interface EmloyeeDAO extends CrudDAO<Employee, String> {
	void getEmployeeOutPut(ArrayList<Employee> employeeList) throws Exception;
}
