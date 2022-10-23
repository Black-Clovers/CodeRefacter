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

	@Override public void getEmployeeOutPut(ArrayList<Employee> employeeList) throws Exception {

		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println(
				"================================================================================================================");

		for (Employee employee : employeeList) {
			System.out.println(
					employee.getEmployeeID() + "\t" + employee.getFullName() + "\t\t" + employee.getAddress() + "\t"
							+ employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
							+ employee.getDesignation() + "\n");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
		}
	}

	@Override public void createTable() throws Exception {
		CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q2"));
		CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q1"));
	}

	@Override public void save(Employee employee) throws Exception {
		PreparedStatement ps = CrudUtil.getPreparedStatement(CrudUtil.getEmployeeQueryById("q3"),
				employee.getEmployeeID(), employee.getFullName(), employee.getAddress(), employee.getFacultyName(),
				employee.getDepartment(), employee.getDesignation());
		DBConnection.getInstance().getConnection().setAutoCommit(false);
		ps.addBatch();
		ps.executeBatch();
		DBConnection.getInstance().getConnection().commit();
	}

	@Override public boolean update(Employee employee) throws Exception {
		return CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q4"), employee.getFullName(),
				employee.getAddress(), employee.getFacultyName(), employee.getDepartment(), employee.getDesignation(),
				employee.getEmployeeID());
	}

	@Override public boolean delete(String id) throws Exception {
		return CrudUtil.executeUpdate(CrudUtil.getEmployeeQueryById("q6"), id);
	}

	@Override public Employee getByID(String id) throws Exception {
		ResultSet rst = CrudUtil.executeQuery(CrudUtil.getEmployeeQueryById("q5"), id);
		Employee employee = null;
		while (rst.next()) {
			employee = new Employee();
			employee.setEmployeeID(rst.getString(1));
			employee.setFullName(rst.getString(2));
			employee.setAddress(rst.getString(3));
			employee.setFacultyName(rst.getString(4));
			employee.setDepartment(rst.getString(5));
			employee.setDesignation(rst.getString(6));
		}
		return employee;
	}

	@Override public List<Employee> getAll() throws Exception {
		ResultSet rst = CrudUtil.executeQuery(CrudUtil.getEmployeeQueryById("q5"));
		ArrayList<Employee> allEmployees = new ArrayList<>();
		while (rst.next()) {
			Employee employee = new Employee();
			employee.setEmployeeID(rst.getString(1));
			employee.setFullName(rst.getString(2));
			employee.setAddress(rst.getString(3));
			employee.setFacultyName(rst.getString(4));
			employee.setDepartment(rst.getString(5));
			employee.setDesignation(rst.getString(6));
			allEmployees.add(employee);
		}
		getEmployeeOutPut(allEmployees);
		return allEmployees;
	}

}
