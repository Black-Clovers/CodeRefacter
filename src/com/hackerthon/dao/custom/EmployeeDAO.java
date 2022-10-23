package com.hackerthon.dao.custom;

import com.hackerthon.dao.CrudDAO;
import com.hackerthon.entity.Employee;

public interface EmployeeDAO extends CrudDAO<Employee, String> {
	void getEmployeeOutPut() throws Exception;
}
