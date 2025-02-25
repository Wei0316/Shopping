package service.impl;

import java.util.List;

import dao.ipml.CustomerDaoImpl;
import model.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDaoImpl customerdaoimpl = new CustomerDaoImpl();

	@Override
	public Customer Login(String Email, String Password) {
		Customer customer = null;
		List<Customer> l = customerdaoimpl.selectCustomerByEmailAndPassword(Email, Password);
		if (!l.isEmpty()) {
			customer = l.get(0);
		}

		return customer;
	}

	@Override
	public Customer findPassword(String Email) {
		Customer customer = null;
		List<Customer> l = customerdaoimpl.selectCustomerPasswordByEmail(Email);
		if (!l.isEmpty()) {
			customer = l.get(0);
		}

		return customer;
	}

}
