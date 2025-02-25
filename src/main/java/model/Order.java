package model;

public class Order {
	public Integer OrderID;
	public Integer CustomerID;
	public String customerName;
	public String customerPhone;
	public String customerAddress;
	public String OrderTime;
	public Integer OrderTotal;

	public Order(Integer orderID, String customerName, String customerPhone, String customerAddress, String orderTime,
			Integer orderTotal) {
		super();
		OrderID = orderID;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		OrderTime = orderTime;
		OrderTotal = orderTotal;
	}

	public Order(Integer orderID, Integer customerID, String orderTime, Integer orderTotal) {
		super();
		OrderID = orderID;
		CustomerID = customerID;
		OrderTime = orderTime;
		OrderTotal = orderTotal;
	}

	public Order(Integer customerID, Integer orderTotal) {
		super();
		CustomerID = customerID;
		OrderTotal = orderTotal;
	}

	public Order() {
		super();
	}

	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public Integer getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}

	public Integer getOrderTotal() {
		return OrderTotal;
	}

	public void setOrderTotal(Integer orderTotal) {
		OrderTotal = orderTotal;
	}

}