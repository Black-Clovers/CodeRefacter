package com.hackerthon.bo;

import com.hackerthon.bo.custom.impl.EmployeeBOImpl;

public class BOFactory {

	private static BOFactory bOFactory; // create a BOFactory instance

	private BOFactory() {// create a private constructor
	}

	public static BOFactory getInstance() {// This method is used to get the instance of the BOFactory class
		if (bOFactory == null) {// check if the instance is null
			bOFactory = new BOFactory();// create a new DAOFactory
		}
		return bOFactory;// return the DAOFactory
	}

	public SuperBO getBOType(BOType types) {// create a method to get the BO type
		if (types == BOType.EMPLOYEE) {// check if the type is employee
			return new EmployeeBOImpl();// return the employee BOImpl
		}
		return null;// return null
	}

	public enum BOType {// create an enum class to get the type of BO
		EMPLOYEE // create an enum type
	}

}
