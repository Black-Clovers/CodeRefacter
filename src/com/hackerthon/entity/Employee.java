package com.hackerthon.entity;

public class Employee {//Employee class
	private String employeeID;// create a variable to store employeeID
	private String fullName;// create a variable to store fullName
	private String address;// create a variable to store address
	private String facultyName;// create a variable to store facultyName
	private String department;// create a variable to store department
	private String designation;// create a variable to store designation

	public String getEmployeeID() {// create a method to get employeeID

		return employeeID;// return employeeID
	}

	public void setEmployeeID(String employeeID) {// create a method to set employeeID

		this.employeeID = employeeID;// set employeeID
	}

	public String getFullName() {// create a method to get fullName
		return fullName;// return fullName
	}

	public void setFullName(String fullName) {// create a method to set fullName
		this.fullName = fullName;// set fullName
	}

	public String getAddress() {// create a method to get address

		return address;// return address
	}

	public void setAddress(String address) {// create a method to set address

		this.address = address;// set address
	}

	public String getFacultyName() {// create a method to get facultyName

		return facultyName;// return facultyName
	}

	public void setFacultyName(String facultyName) {// create a method to set facultyName

		this.facultyName = facultyName;// set facultyName
	}

	public String getDepartment() {// create a method to get department

		return department;// return department
	}

	public void setDepartment(String department) {// create a method to set department

		this.department = department;// set department
	}

	public String getDesignation() {// create a method to get designation

		return designation;// return designation
	}

	public void setDesignation(String designation) {// create a method to set designation

		this.designation = designation;// set designation
	}

	@Override public String toString() {// create a method to print the details of employee
		return "Employee{" + "employeeID='" + employeeID + '\'' + ", fullName='" + fullName + '\'' + ", address='"
				+ address + '\'' + ", facultyName='" + facultyName + '\'' + ", department='" + department + '\''
				+ ", designation='" + designation + '\'' + '}';// return the details of employee
	}
}