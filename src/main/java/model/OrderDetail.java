package model;

public class OrderDetail {
	public Integer OrderDetailID;
	public Integer OrderID;
	public Integer ProductID;
	public String ProductName;
	public Integer ProductOnePrice;
	public Integer ProductQuantity;
	public Integer ProductPrice;

	public OrderDetail(Integer orderID, String productName, Integer productOnePrice, Integer productQuantity,
			Integer productPrice) {
		super();
		OrderID = orderID;
		ProductName = productName;
		ProductOnePrice = productOnePrice;
		ProductQuantity = productQuantity;
		ProductPrice = productPrice;
	}

	public OrderDetail(Integer orderDetailID, Integer orderID, Integer productID, Integer productQuantity,
			Integer productPrice) {
		super();
		OrderDetailID = orderDetailID;
		OrderID = orderID;
		ProductID = productID;
		ProductQuantity = productQuantity;
		ProductPrice = productPrice;
	}

	public OrderDetail(Integer orderID, Integer productID, Integer productQuantity, Integer productPrice) {
		super();
		OrderID = orderID;
		ProductID = productID;
		ProductQuantity = productQuantity;
		ProductPrice = productPrice;
	}

	public OrderDetail() {
		super();
	}

	public Integer getOrderDetailID() {
		return OrderDetailID;
	}

	public void setOrderDetailID(Integer orderDetailID) {
		OrderDetailID = orderDetailID;
	}

	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Integer getProductOnePrice() {
		return ProductOnePrice;
	}

	public void setProductOnePrice(Integer productOnePrice) {
		ProductOnePrice = productOnePrice;
	}

	public Integer getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		ProductQuantity = productQuantity;
	}

	public Integer getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(Integer productPrice) {
		ProductPrice = productPrice;
	}

}
