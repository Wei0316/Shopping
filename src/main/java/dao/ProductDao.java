package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	
	List<Product> selectAllProduct();
	Integer selectProductPrice(String ProductName);
	Integer selectProductID(String ProductName);
	Integer selectProductStock(Integer ProductID);

	void updateProduct(Product product);

	void deleteProduct(Integer ProductID);
	
}
