package emp.dao;

import emp.dao.custom.impl.EmployeeDAOImpl;

public class DAOFactory {

	private static DAOFactory dAOFactory;

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		if (dAOFactory == null) {
			dAOFactory = new DAOFactory();
		}
		return dAOFactory;
	}

	public SuperDAO getDAOType(DAOType types) {
		if (types == DAOType.EMPLOYEE) {
			return new EmployeeDAOImpl();
		}
		return null;
	}

	public enum DAOType {
		EMPLOYEE
	}
}
