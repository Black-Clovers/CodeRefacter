package com.hackerthon.controller;

import com.hackerthon.bo.BOFactory;
import com.hackerthon.bo.custom.EmployeeBO;

public class EmployeeController {

	static EmployeeBO bo = (EmployeeBO) BOFactory.getInstance().getBOType(BOFactory.BOType.EMPLOYEE);

	public void createEmployeeTable() throws Exception {
		bo.createEmployeeTable();
	}

	public void insertEmployee() throws Exception {
		bo.addEmployee();
	}

	public void loadAllEmployees() throws Exception {
		bo.loadAllEmployees();
	}

	public void getAllEmployees() throws Exception {
		bo.getAllEmployee();
	}
}
