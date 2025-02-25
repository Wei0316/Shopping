package service;

import model.Customer;

public interface CustomerService {
	Customer Login(String Email, String Password);
	
	Customer findPassword(String Email);
}
