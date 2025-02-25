package service;

import javax.swing.table.DefaultTableModel;

import model.Employee;

public interface EmployeeService {
	
	Employee Login(String Email, String Password);

	DefaultTableModel EmployeeSelectForTable();
	
}
