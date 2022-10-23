package emp.bo;

import emp.bo.custom.impl.EmployeeBOImpl;

public class BOFactory {

	private static BOFactory bOFactory;

	private BOFactory() {
	}

	public static BOFactory getInstance() {
		if (bOFactory == null) {
			bOFactory = new BOFactory();
		}
		return bOFactory;
	}

	public SuperBO getBOType(BOType types) {
		if (types == BOType.EMPLOYEE) {
			return new EmployeeBOImpl();
		}
		return null;
	}

	public enum BOType {
		EMPLOYEE
	}
}
