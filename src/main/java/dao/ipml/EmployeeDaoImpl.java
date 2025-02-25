package dao.ipml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;
import util.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	public static void main(String[] args) {
		new EmployeeDaoImpl().updateEmployee(new Employee(3, "12ef", "ge54", "dwda1", "wda15", "wdad11", "dw5fw"));
		/*
		 * List<Employee> employee = new EmployeeDaoImpl().selectAllEmployee();
		 * for(Employee e : employee) { System.out.print(e.getEmployeeName()); }
		 */
	}

	private static Connection connection = DBConnection.getDB();

	@Override
	public void addEmployee(Employee employee) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"insert into employee(EmployeeName,EmployeePosition,EmployeePhone,EmployeeAddress,EmployeeEmail,Employeepassword) values(?,?,?,?,?,?)");
			preparedstatement.setString(1, employee.getEmployeeName());
			preparedstatement.setString(2, employee.getEmployeePosition());
			preparedstatement.setString(3, employee.getEmployeePhone());
			preparedstatement.setString(4, employee.getEmployeeAddress());
			preparedstatement.setString(5, employee.getEmployeeEmail());
			preparedstatement.setString(6, employee.getEmployeePassword());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> selectAllEmployee() {
		List<Employee> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select *from employee");
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(resultset.getInt("EmployeeID"));
				employee.setEmployeeName(resultset.getString("EmployeeName"));
				employee.setEmployeePosition(resultset.getString("EmployeePosition"));
				employee.setEmployeePhone(resultset.getString("EmployeePhone"));
				employee.setEmployeeAddress(resultset.getString("EmployeeAddress"));
				employee.setEmployeeEmail(resultset.getString("EmployeeEmail"));
				employee.setEmployeePassword(resultset.getString("EmployeePassword"));

				l.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Employee> selectEmployeeByEmailAndPassword(String Email, String Password) {
		List<Employee> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select *from employee where EmployeeEmail=? and EmployeePassword=?");
			preparedstatement.setString(1, Email);
			preparedstatement.setString(2, Password);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(resultset.getInt("EmployeeID"));
				employee.setEmployeeName(resultset.getString("EmployeeName"));
				employee.setEmployeePosition(resultset.getString("EmployeePosition"));
				employee.setEmployeePhone(resultset.getString("EmployeePhone"));
				employee.setEmployeeAddress(resultset.getString("EmployeeAddress"));
				employee.setEmployeeEmail(resultset.getString("EmployeeEmail"));
				employee.setEmployeePassword(resultset.getString("EmployeePassword"));

				l.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Employee getEmployeeByEmployeeID(Integer EmployeeID) {
		Employee employee = new Employee();
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select *from employee where EmployeeID=?");
			preparedstatement.setInt(1, EmployeeID);
			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				employee.setEmployeeID(resultset.getInt("EmployeeID"));
				employee.setEmployeeName(resultset.getString("EmployeeName"));
				employee.setEmployeePosition(resultset.getString("EmployeePosition"));
				employee.setEmployeePhone(resultset.getString("EmployeePhone"));
				employee.setEmployeeAddress(resultset.getString("EmployeeAddress"));
				employee.setEmployeeEmail(resultset.getString("EmployeeEmail"));
				employee.setEmployeePassword(resultset.getString("EmployeePassword"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"update employee set EmployeeName=?,EmployeePosition=?,EmployeePhone=?,EmployeeAddress=?,EmployeeEmail=?,EmployeePassword=? where EmployeeID=?");
			preparedstatement.setString(1, employee.getEmployeeName());
			preparedstatement.setString(2, employee.getEmployeePosition());
			preparedstatement.setString(3, employee.getEmployeePhone());
			preparedstatement.setString(4, employee.getEmployeeAddress());
			preparedstatement.setString(5, employee.getEmployeeEmail());
			preparedstatement.setString(6, employee.getEmployeePassword());
			preparedstatement.setInt(7, employee.getEmployeeID());
			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(Integer EmployeeID) {
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("delete from employee where EmployeeID=?");
			preparedstatement.setInt(1, EmployeeID);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
