package com.hackerthon.controller;

import com.hackerthon.bo.BOFactory;
import com.hackerthon.bo.custom.EmployeeBO;

public class EmployeeController { //create Employee Controller class

	//create BOFactory and get instance with BOType and cast to EmployeeBO
	static EmployeeBO bo = (EmployeeBO) BOFactory.getInstance().getBOType(BOFactory.BOType.EMPLOYEE);

	public void createEmployeeTable()
			throws Exception {//create employee table and throw exception if pass any exception
		bo.createEmployeeTable();//call createEmployeeTable method in EmployeeBO
	}

	public void insertEmployee() throws Exception {//insert employee and throw exception if pass any exception
		bo.addEmployee();//call addEmployee method in EmployeeBO
	}

	public void loadAllEmployees() throws Exception {//load all employees and throw exception if pass any exception
		bo.loadAllEmployees();//call loadAllEmployees method in EmployeeBO
	}

	public void getAllEmployees() throws Exception {//get all employees and throw exception if pass any exception
		bo.getAllEmployee();//call getAllEmployee method in EmployeeBO
	}
}
