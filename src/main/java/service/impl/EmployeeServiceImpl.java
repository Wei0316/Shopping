package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.ipml.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDaoImpl employeedaoimpl = new EmployeeDaoImpl();

	@Override
	public Employee Login(String Email, String Password) {
		Employee employee = null;
		List<Employee> l = employeedaoimpl.selectEmployeeByEmailAndPassword(Email, Password);
		if (!l.isEmpty()) {
			employee = l.get(0);
		}

		return employee;
	}

	@Override
	public DefaultTableModel EmployeeSelectForTable() {
		List<Employee> employeeList = new EmployeeDaoImpl().selectAllEmployee();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("員工編號");
		model.addColumn("姓名");
		model.addColumn("職位");
		model.addColumn("電話");
		model.addColumn("地址");
		model.addColumn("電子郵件");
		model.addColumn("密碼");
		model.setRowCount(0);
		for (Employee employee : employeeList) {
			model.addRow(new Object[] { employee.getEmployeeID(), employee.getEmployeeName(),
					employee.getEmployeePosition(), employee.getEmployeePhone(), employee.getEmployeeAddress(),
					employee.getEmployeeEmail(), employee.getEmployeePassword() });
		}

		return model;
	}

}
