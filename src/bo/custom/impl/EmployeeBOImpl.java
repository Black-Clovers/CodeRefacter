package bo.custom.impl;

import bo.custom.EmployeeBO;
import entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

	@Override public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException, Exception {
		return false;
	}

	@Override public boolean deleteEmployee(String id) throws ClassNotFoundException, SQLException, Exception {
		return false;
	}

	@Override public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException, Exception {
		return false;
	}

	@Override public Employee searchEmployee(String id) throws ClassNotFoundException, SQLException, Exception {
		return null;
	}

	@Override public ArrayList<Employee> getAllEmployee() throws ClassNotFoundException, SQLException, Exception {
		return null;
	}
}
