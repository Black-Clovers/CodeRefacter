package com.hackerthon.main;

import com.hackerthon.controller.EmployeeController;
import com.hackerthon.utils.FileConverter;

public class Main {
	public static void main(String[] args) {
		//create object from EmployeeController
		EmployeeController employeeController = new EmployeeController();
		try {
			// Read the file and request to transform
			FileConverter.getRequestTransform();
			// Get the xpaths from the transformed file
			employeeController.loadAllEmployees();
			// Create the table
			employeeController.createEmployeeTable();
			// Insert the data to the table
			employeeController.insertEmployee();
			// Get all the data from the table
			employeeController.getAllEmployees();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
