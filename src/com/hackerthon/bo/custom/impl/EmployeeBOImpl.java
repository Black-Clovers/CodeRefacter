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
			boolean isAdded = dao.save(employeeEn);
			if (!isAdded) {
				return false;
			}
		}
	}

	@Override public boolean deleteEmployee(String id) throws Exception {
		return dao.delete(id);
	}

	@Override public Employee searchEmployee(String id) throws Exception {
		return null;
	}

	@Override public ArrayList<Employee> getAllCustomers() throws Exception {
		return null;
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
