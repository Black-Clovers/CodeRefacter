package emp.dao.custom;

import emp.dao.CrudDAO;
import emp.entity.Employee;

import java.util.ArrayList;

public interface EmloyeeDAO extends CrudDAO<Employee, String> {
	public void getEmployeeOutPut(ArrayList<Employee> employeeList) throws Exception;
}
