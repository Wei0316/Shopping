package dao.ipml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import model.Customer;
import util.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	public static void main(String[] args) {

		new CustomerDaoImpl().updateCustomer(new Customer(14, "375", "458", "4812", "fefe", "fead"));

		/*
		 * List<Customer> customer = new
		 * CustomerDaoImpl().selectCustomerPasswordByEmail("GG@123"); for (Customer c :
		 * customer) { System.out.println(c.getCustomerPassword()); }
		 */
	}

	private static Connection connection = DBConnection.getDB();

	@Override
	public void addCustomer(Customer customer) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"insert into customer(CustomerName,CustomerPhone,CustomerAddress,CustomerEmail,CustomerPassword) values(?,?,?,?,?)");
			preparedstatement.setString(1, customer.getCustomerName());
			preparedstatement.setString(2, customer.getCustomerPhone());
			preparedstatement.setString(3, customer.getCustomerAddress());
			preparedstatement.setString(4, customer.getCustomerEmail());
			preparedstatement.setString(5, customer.getCustomerPassword());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> selectAllCustomer() {
		List<Customer> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select *from customer");
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(resultset.getInt("CustomerID"));
				customer.setCustomerName(resultset.getString("CustomerName"));
				customer.setCustomerPhone(resultset.getString("CustomerPhone"));
				customer.setCustomerAddress(resultset.getString("CustomerAddress"));
				customer.setCustomerEmail(resultset.getString("CustomerEmail"));
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));

				l.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Customer> selectCustomerByEmailAndPassword(String Email, String Password) {
		List<Customer> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select *from customer where CustomerEmail=? and CustomerPassword=?");
			preparedstatement.setString(1, Email);
			preparedstatement.setString(2, Password);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(resultset.getInt("CustomerID"));
				customer.setCustomerName(resultset.getString("CustomerName"));
				customer.setCustomerPhone(resultset.getString("CustomerPhone"));
				customer.setCustomerAddress(resultset.getString("CustomerAddress"));
				customer.setCustomerEmail(resultset.getString("CustomerEmail"));
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));

				l.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Customer> selectCustomerPasswordByEmail(String Email) {
		List<Customer> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select CustomerPassword from customer where CustomerEmail=?");
			preparedstatement.setString(1, Email);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Customer customer = new Customer();
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));

				l.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Customer getCustomerByCustomerID(Integer CustomerID) {
		Customer customer = new Customer();
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select *from customer where CustomerID=?");
			preparedstatement.setInt(1, CustomerID);
			ResultSet resultset = preparedstatement.executeQuery();

			if(resultset.next()) {
				customer.setCustomerID(resultset.getInt("CustomerID"));
				customer.setCustomerName(resultset.getString("CustomerName"));
				customer.setCustomerPhone(resultset.getString("CustomerPhone"));
				customer.setCustomerAddress(resultset.getString("CustomerAddress"));
				customer.setCustomerEmail(resultset.getString("CustomerEmail"));
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"update customer set CustomerName=?,CustomerPhone=?,CustomerAddress=?,CustomerEmail=?,CustomerPassword=? where CustomerID=?");
			preparedstatement.setString(1, customer.getCustomerName());
			preparedstatement.setString(2, customer.getCustomerPhone());
			preparedstatement.setString(3, customer.getCustomerAddress());
			preparedstatement.setString(4, customer.getCustomerEmail());
			preparedstatement.setString(5, customer.getCustomerPassword());
			preparedstatement.setInt(6, customer.getCustomerID());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(Integer CustomerID) {
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("delete from customer where CustomerID=?");
			preparedstatement.setInt(1, CustomerID);
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
