package model;

import java.io.Serializable;

public class Customer implements Serializable{
	private Integer CustomerID;
	private String CustomerName;
	private String CustomerPhone;
	private String CustomerAddress;
	private String CustomerEmail;
	private String CustomerPassword;
	
	public Customer(Integer customerID, String customerName, String customerPhone, String customerAddress,
			String customerEmail, String customerPassword) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		CustomerPhone = customerPhone;
		CustomerAddress = customerAddress;
		CustomerEmail = customerEmail;
		CustomerPassword = customerPassword;
	}

	public Customer(String customerName, String customerPhone, String customerAddress, String customerEmail,
			String customerPassword) {
		super();
		CustomerName = customerName;
		CustomerPhone = customerPhone;
		CustomerAddress = customerAddress;
		CustomerEmail = customerEmail;
		CustomerPassword = customerPassword;
	}

	public Customer() {
		super();
	}

	public Integer getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerPhone() {
		return CustomerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return CustomerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}
	
}

