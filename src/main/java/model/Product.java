package model;

public class Product {
	private Integer ProductID;
	private String ProductName;
	private Integer ProductPrice;
	private Integer ProductStock;
	
	public Product(Integer productID, String productName, Integer productPrice, Integer productStock) {
		super();
		ProductID = productID;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductStock = productStock;
	}
	
	public Product(String productName, Integer productPrice, Integer productStock) {
		super();
		ProductName = productName;
		ProductPrice = productPrice;
		ProductStock = productStock;
	}

	public Product() {
		super();
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
	
	public Integer getProductPrice() {
		return ProductPrice;
	}
	
	public void setProductPrice(Integer productPrice) {
		ProductPrice = productPrice;
	}
	
	public Integer getProductStock() {
		return ProductStock;
	}
	
	public void setProductStock(Integer productStock) {
		ProductStock = productStock;
	}
	
}
