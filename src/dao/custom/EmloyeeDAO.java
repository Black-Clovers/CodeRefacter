package dao.custom;

import dao.CrudDAO;
import entity.Employee;

import java.util.ArrayList;

public interface EmloyeeDAO extends CrudDAO<Employee, String> {
	public void getEmployeeOutPut(ArrayList<Employee> employeeList) throws Exception;
}
