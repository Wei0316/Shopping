package service;

import javax.swing.table.DefaultTableModel;

public interface OrderService {
	DefaultTableModel OrderTable();
	DefaultTableModel OrderTable(String startDate,String endDate);
	DefaultTableModel OrderTableByCustomerID(Integer customerID);
	DefaultTableModel OrderTableByCustomerID(String startDate, String endDate);

}
