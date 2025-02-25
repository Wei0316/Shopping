package model;

import java.io.Serializable;

public class Employee implements Serializable{
	private Integer EmployeeID;
	private String EmployeeName;
	private String EmployeePosition;
	private String EmployeePhone;
	private String EmployeeAddress;
	private String EmployeeEmail;
	private String EmployeePassword;

	public Employee(Integer employeeID, String employeeName, String employeePosition, String employeePhone,
			String employeeAddress, String employeeEmail, String employeePassword) {
		super();
		EmployeeID = employeeID;
		EmployeeName = employeeName;
		EmployeePosition = employeePosition;
		EmployeePhone = employeePhone;
		EmployeeAddress = employeeAddress;
		EmployeeEmail = employeeEmail;
		EmployeePassword = employeePassword;
	}

	public Employee(String employeeName, String employeePosition, String employeePhone, String employeeAddress,
			String employeeEmail, String employeePassword) {
		super();
		EmployeeName = employeeName;
		EmployeePosition = employeePosition;
		EmployeePhone = employeePhone;
		EmployeeAddress = employeeAddress;
		EmployeeEmail = employeeEmail;
		EmployeePassword = employeePassword;
	}
	
	public Employee(String employeeName, String employeePhone, String employeeAddress,
			String employeeEmail, String employeePassword) {
		super();
		EmployeeName = employeeName;
		EmployeePhone = employeePhone;
		EmployeeAddress = employeeAddress;
		EmployeeEmail = employeeEmail;
		EmployeePassword = employeePassword;
	}

	public Employee() {
		super();
	}

	public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmployeePosition() {
		return EmployeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		EmployeePosition = employeePosition;
	}

	public String getEmployeePhone() {
		return EmployeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		EmployeePhone = employeePhone;
	}

	public String getEmployeeAddress() {
		return EmployeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		EmployeeAddress = employeeAddress;
	}

	public String getEmployeeEmail() {
		return EmployeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return EmployeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		EmployeePassword = employeePassword;
	}

}