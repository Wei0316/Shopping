package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	void addEmployee(Employee employee);

	List<Employee> selectAllEmployee();

	List<Employee> selectEmployeeByEmailAndPassword(String Email, String Password);
	
	Employee getEmployeeByEmployeeID(Integer EmployeeID);

	void updateEmployee(Employee employee);

	void deleteEmployee(Integer EmployeeID);

}
