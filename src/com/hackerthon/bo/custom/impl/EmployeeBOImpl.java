package com.hackerthon.bo.custom.impl;

import com.hackerthon.bo.custom.EmployeeBO;
import com.hackerthon.dao.DAOFactory;
import com.hackerthon.dao.custom.EmployeeDAO;
import com.hackerthon.entity.Employee;
import com.hackerthon.utils.FileConverter;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeBOImpl implements EmployeeBO {

	private final ArrayList<Employee> employees = new ArrayList<Employee>();
	EmployeeDAO dao = (EmployeeDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.EMPLOYEE);

	@Override public void createEmployeeTable() throws Exception {
		dao.createTable();
	}

	@Override public boolean addEmployee() throws Exception {
		for (int i = 0; i < employees.size(); i++) {
			Employee employeeEn = employees.get(i);
			return dao.save(employeeEn);

		}
		return false;
	}

	@Override public boolean deleteEmployee(String id) throws Exception {
		return dao.delete(id);
	}

	@Override public Employee searchEmployee(String id) throws Exception {
		Employee searchEmployee = dao.getByID(id);
		Employee employee = new Employee();
		employee.setEmployeeID(searchEmployee.getEmployeeID());
		employee.setFullName(searchEmployee.getFullName());
		employee.setAddress(searchEmployee.getAddress());
		employee.setDepartment(searchEmployee.getDepartment());
		employee.setFacultyName(searchEmployee.getFacultyName());
		employee.setDesignation(searchEmployee.getDesignation());
		return employee;
	}

	@Override public ArrayList<Employee> getAllEmployee() throws Exception {
		ArrayList<Employee> allEmployee = new ArrayList<>();
		ArrayList<Employee> all = (ArrayList<Employee>) dao.getAll();
		for (Employee a : all) {
			Employee employee = new Employee();
			employee.setEmployeeID(a.getEmployeeID());
			employee.setFullName(a.getFullName());
			employee.setAddress(a.getAddress());
			employee.setFacultyName(a.getFacultyName());
			employee.setDepartment(a.getDepartment());
			employee.setDesignation(a.getDesignation());
			allEmployee.add(employee);
		}
		return allEmployee;
	}

	@Override public void loadAllEmployees() throws Exception {
		int pathSize = FileConverter.getXmlXPaths().size();
		for (int i = 0; i < pathSize; i++) {
			Map<String, String> employeeList = FileConverter.getXmlXPaths().get(i);
			Employee employee = new Employee();
			employee.setEmployeeID(employeeList.get("XpathEmployeeIDKey"));
			employee.setFullName(employeeList.get("XpathEmployeeNameKey"));
			employee.setAddress(employeeList.get("XpathEmployeeAddressKey"));
			employee.setFacultyName(employeeList.get("XpathFacultyNameKey"));
			employee.setDepartment(employeeList.get("XpathDepartmentKey"));
			employee.setDesignation(employeeList.get("XpathDesignationKey"));
			employees.add(employee);
			System.out.println(employee + "\n");
		}
	}
}
