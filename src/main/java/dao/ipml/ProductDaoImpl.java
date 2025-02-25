package dao.ipml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Product;
import util.DBConnection;

public class ProductDaoImpl implements ProductDao {
	public static void main(String[] args) {
		// new ProductDaoImpl().updateProduct(new Product(2, "ORANGE", 4, 4));

		System.out.print(new ProductDaoImpl().selectProductID("rr"));
		/*
		 * List<Product> product = new ProductDaoImpl().selectAllProduct(); for (Product
		 * p : product) { System.out.println(p.getProductPrice()); }
		 */
	}

	private static Connection connection = DBConnection.getDB();

	@Override
	public void addProduct(Product product) {
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("insert into product(ProductName,ProductPrice,ProductStock) values(?,?,?)");
			preparedstatement.setString(1, product.getProductName());
			preparedstatement.setInt(2, product.getProductPrice());
			preparedstatement.setInt(3, product.getProductStock());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> selectAllProduct() {
		List<Product> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select *from product");
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Product product = new Product();
				product.setProductID(resultset.getInt("ProductID"));
				product.setProductName(resultset.getString("ProductName"));
				product.setProductPrice(resultset.getInt("ProductPrice"));
				product.setProductStock(resultset.getInt("ProductStock"));

				l.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Integer selectProductPrice(String ProductName) {
		Integer productPrice = null;
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select ProductPrice from product where ProductName=?");
			preparedstatement.setString(1, ProductName);
			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				productPrice = resultset.getInt("ProductPrice");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productPrice;
	}
	
	@Override
	public Integer selectProductID(String ProductName) {
		Integer productID = null;
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select ProductID from product where ProductName=?");
			preparedstatement.setString(1, ProductName);
			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				productID = resultset.getInt("ProductID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productID;
	}
	
	@Override
	public Integer selectProductStock(Integer ProductID) {
		Integer ProductStock = null;
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select ProductStock from product where ProductID=?");
			preparedstatement.setInt(1, ProductID);
			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				ProductStock = resultset.getInt("ProductStock");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ProductStock;
	}

	@Override
	public void updateProduct(Product product) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"update product set ProductName=?,ProductPrice=?,ProductStock=? where ProductID=?");
			preparedstatement.setString(1, product.getProductName());
			preparedstatement.setInt(2, product.getProductPrice());
			preparedstatement.setInt(3, product.getProductStock());
			preparedstatement.setInt(4, product.getProductID());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProduct(Integer ProductID) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("delete from product where ProductID=?");
			preparedstatement.setInt(1, ProductID);
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	

}
