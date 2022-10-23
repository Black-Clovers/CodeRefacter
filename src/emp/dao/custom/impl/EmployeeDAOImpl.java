package emp.dao.custom.impl;

import emp.dao.custom.EmloyeeDAO;
import emp.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmloyeeDAO {
	@Override public boolean save(Employee employee) throws Exception {
		return false;
	}

	@Override public boolean update(Employee employee) throws Exception {
		return false;
	}

	@Override public boolean delete(String s) throws Exception {
		return false;
	}

	@Override public Employee getByID(String s) throws Exception {
		return null;
	}

	@Override public List<Employee> getAll() throws Exception {

		return null;
	}

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
}
