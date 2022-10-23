package com.hackerthon.main;

import com.hackerthon.controller.EmployeeController;

public class Main {
	public static void main(String[] args) {
		EmployeeController employeeController = new EmployeeController();
		try {
			employeeController.loadAllEmployees();
			employeeController.createEmployeeTable();
			//			employeeController.insertEmployee();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
