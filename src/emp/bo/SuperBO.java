package emp.bo;

import emp.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SuperBO {
	public boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException, Exception;

	public boolean deleteEmployee(String id) throws ClassNotFoundException, SQLException, Exception;

	public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException, Exception;

	public Employee searchEmployee(String id) throws ClassNotFoundException, SQLException, Exception;

	public ArrayList<Employee> getAllEmployee() throws ClassNotFoundException, SQLException, Exception;
}
