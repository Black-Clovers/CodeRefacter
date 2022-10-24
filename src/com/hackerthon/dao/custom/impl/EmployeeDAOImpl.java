package com.hackerthon.dao.custom.impl;

import com.hackerthon.dao.CrudUtil;
import com.hackerthon.dao.custom.EmployeeDAO;
import com.hackerthon.db.DBConnection;
import com.hackerthon.entity.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override public void getEmployeeOutPut(ArrayList<Employee> employeeList)
			throws Exception { // get the employee output

		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println(
				"================================================================================================================");

		for (Employee employee : employeeList) { // This loop is used to get the employee details
			System.out.println(
					employee.getEmployeeID() + "\t" + employee.getFullName() + "\t\t" + employee.getAddress() + "\t"
							+ employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
							+ employee.getDesignation() + "\n");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
		}
	}

	@Override public void createTable() throws Exception {
		CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q2"));//create the table in the database
		CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q1"));// create the table in the database
	}

	@Override public void save(Employee employee) throws Exception {// save the data to the database
		PreparedStatement ps = CrudUtil.getPreparedStatement(CrudUtil.getEmployeeQueryById("q3"),
				employee.getEmployeeID(), employee.getFullName(), employee.getAddress(), employee.getFacultyName(),
				employee.getDepartment(), employee.getDesignation());// get the prepared statement
		DBConnection.getInstance().getConnection().setAutoCommit(false);// set the auto commit
		ps.addBatch();// add the batch
		ps.executeBatch();// execute the batch
		DBConnection.getInstance().getConnection().commit();//  commit the connection
	}

	@Override public boolean update(Employee employee) throws Exception {
		return CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q4"), employee.getFullName(),
				employee.getAddress(), employee.getFacultyName(), employee.getDepartment(), employee.getDesignation(),
				employee.getEmployeeID());// update the data in the database
	}

	@Override public boolean delete(String id) throws Exception {
		return CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q6"), id);// delete the data from the database
	}

	@Override public Employee getByID(String id) throws Exception {
		ResultSet rst = CrudUtil.executeQuery(CrudUtil.getEmployeeQueryById("q5"),
				id);// get the data from the database by id
		Employee employee = null;// This method is used to get the employee details
		while (rst.next()) {// This loop is used to get the employee details
			employee = new Employee();// This method is used to get the employee details
			employee.setEmployeeID(rst.getString(1));// set the employee id
			employee.setFullName(rst.getString(2));// set the full name
			employee.setAddress(rst.getString(3));// set the address
			employee.setFacultyName(rst.getString(4));// set the faculty name
			employee.setDepartment(rst.getString(5));// set the department
			employee.setDesignation(rst.getString(6));// set the designation
		}
		return employee;// return the employee details
	}

	@Override public List<Employee> getAll() throws Exception { // create the list to get all the data from the database
		ResultSet rst = CrudUtil.executeQuery(CrudUtil.getEmployeeQueryById("q5"));// get the data from the database
		ArrayList<Employee> allEmployees = new ArrayList<>();// create the array list
		while (rst.next()) {// This loop is used to get the employee details
			Employee employee = new Employee();// create the employee object
			employee.setEmployeeID(rst.getString(1));// set the employee id
			employee.setFullName(rst.getString(2));// set the full name
			employee.setAddress(rst.getString(3));// set the address
			employee.setFacultyName(rst.getString(4));// set the faculty name
			employee.setDepartment(rst.getString(5));// set the department
			employee.setDesignation(rst.getString(6));// set the designation
			allEmployees.add(employee);// add the employee details to the array list
		}
		getEmployeeOutPut(allEmployees);// get the employee output
		return allEmployees;// return the employee details
	}

}
