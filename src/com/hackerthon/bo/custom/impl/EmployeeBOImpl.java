package com.hackerthon.bo.custom.impl;

import com.hackerthon.bo.custom.EmployeeBO;
import com.hackerthon.dao.DAOFactory;
import com.hackerthon.dao.custom.EmployeeDAO;
import com.hackerthon.entity.Employee;
import com.hackerthon.utils.FileConverter;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeBOImpl implements EmployeeBO {

	private final ArrayList<Employee> employees = new ArrayList<Employee>(); // create an array list to store the employees
	EmployeeDAO dao = (EmployeeDAO) DAOFactory.getInstance().getDAOType(
			DAOFactory.DAOType.EMPLOYEE); //create DAOFactory instance and get the employee DAO and cast it to EmployeeDAO

	@Override public void createEmployeeTable() throws Exception {// create a method to create the employee table
		dao.createTable();// call the createTable method from the DAO
	}

	@Override public void addEmployee() throws Exception {// create a method to add the employee to the database
		for (int i = 0; i < employees.size(); i++) {// loop through the employees
			Employee employeeEn = employees.get(i);// get the employee
			dao.save(employeeEn);// call the save method from the DAO
		}
	}

	@Override public boolean deleteEmployee(String id)
			throws Exception { // create a method to delete the employee from the database
		return dao.delete(id);// call the delete method from the DAO
	}

	@Override public Employee searchEmployee(String id)
			throws Exception {// create a method to search the employee from the database
		Employee searchEmployee = dao.getByID(id);// call the getByID method from the DAO
		Employee employee = new Employee();// create a new employee
		employee.setEmployeeID(searchEmployee.getEmployeeID());// set the employee id
		employee.setFullName(searchEmployee.getFullName());// set the full name
		employee.setAddress(searchEmployee.getAddress());// set the address
		employee.setDepartment(searchEmployee.getDepartment());// set the department
		employee.setFacultyName(searchEmployee.getFacultyName());// set the faculty name
		employee.setDesignation(searchEmployee.getDesignation());// set the designation
		return employee;// return the employee
	}

	@Override public ArrayList<Employee> getAllEmployee()
			throws Exception {// create a method to get all the employee from the database
		ArrayList<Employee> allEmployee = new ArrayList<>();// create a new array list
		ArrayList<Employee> all = (ArrayList<Employee>) dao.getAll();// call the getAll method from the DAO
		for (Employee a : all) {// loop through the employees
			Employee employee = new Employee();// create a new employee
			employee.setEmployeeID(a.getEmployeeID());// set the employee id
			employee.setFullName(a.getFullName());// set the full name
			employee.setAddress(a.getAddress());// set the address
			employee.setFacultyName(a.getFacultyName());// set the faculty name
			employee.setDepartment(a.getDepartment());// set the department
			employee.setDesignation(a.getDesignation());// set the designation
			allEmployee.add(employee);// add the employee to the array list
		}
		return allEmployee;// return the array list
	}

	@Override public void loadAllEmployees() throws Exception {// create a method to load all the employee
		int pathSize = FileConverter.getXmlXPaths().size();// get the size of the xml paths
		for (int i = 0; i < pathSize; i++) {// loop through the xml paths
			Map<String, String> employeeList = FileConverter.getXmlXPaths().get(i);// get the employee list
			Employee employee = new Employee();// create a new employee
			employee.setEmployeeID(employeeList.get("XpathEmployeeIDKey"));// set the employee id
			employee.setFullName(employeeList.get("XpathEmployeeNameKey"));// set the full name
			employee.setAddress(employeeList.get("XpathEmployeeAddressKey"));// set the address
			employee.setFacultyName(employeeList.get("XpathFacultyNameKey"));// set the faculty name
			employee.setDepartment(employeeList.get("XpathDepartmentKey"));// set the department
			employee.setDesignation(employeeList.get("XpathDesignationKey"));// set the designation
			employees.add(employee);// add the employee to the array list
			System.out.println(employee + "\n");// print the employee
		}
	}
}
