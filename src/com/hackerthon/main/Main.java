package com.hackerthon.main;

import com.hackerthon.controller.EmployeeController;
import com.hackerthon.utils.FileConverter;

public class Main {
	public static void main(String[] args) {
		EmployeeController employeeController = new EmployeeController();
		try {
			FileConverter.getRequestTransform();
			employeeController.loadAllEmployees();
			employeeController.createEmployeeTable();
			employeeController.insertEmployee();
			employeeController.getAllEmployees();
			//			employeeController.insertEmployee();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
