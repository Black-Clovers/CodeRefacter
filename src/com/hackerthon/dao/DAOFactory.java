package com.hackerthon.dao;

import com.hackerthon.dao.custom.impl.EmployeeDAOImpl;

public class DAOFactory {

	private static DAOFactory dAOFactory;// create a DAOFactory instance

	private DAOFactory() {// create a private constructor
	}

	public static DAOFactory getInstance() { // This method is used to get the instance of the DAOFactory class
		if (dAOFactory == null) {// check if the instance is null
			dAOFactory = new DAOFactory();// create a new instance
		}
		return dAOFactory;// return the instance
	}

	public SuperDAO getDAOType(DAOType types) { //create a method to get the DAO type
		if (types == DAOType.EMPLOYEE) {// check if the type is employee
			return new EmployeeDAOImpl();// return the employee DAO
		}
		return null;// return null
	}

	public enum DAOType { // create an enum class to get the type of DAO
		EMPLOYEE
	}
}
