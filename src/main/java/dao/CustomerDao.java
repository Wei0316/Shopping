package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	
	void addCustomer(Customer customer);

	List<Customer> selectAllCustomer();
	List<Customer> selectCustomerByEmailAndPassword(String Email,String Password);
	List<Customer> selectCustomerPasswordByEmail(String Email);
	Customer getCustomerByCustomerID(Integer CustomerID);

	void updateCustomer(Customer customer);

	void deleteCustomer(Integer CustomerID);
}
