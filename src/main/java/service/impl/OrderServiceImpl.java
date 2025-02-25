package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.ipml.OrderDaoImpl;
import model.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

	public static void main(String[] args) {
		DefaultTableModel orderTable = new OrderServiceImpl().OrderTable("2025-2-21", "2025-2-24");
	}

	@Override
	public DefaultTableModel OrderTable() {
		List<Order> orderList = new OrderDaoImpl().selectAllOrder();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("訂單編號");
		model.addColumn("客戶姓名");
		model.addColumn("電話");
		model.addColumn("地址");
		model.addColumn("訂單時間");
		model.addColumn("總金額");

		model.setRowCount(0);
		for (Order order : orderList) {
			model.addRow(new Object[] { order.getOrderID(), order.getCustomerName(), order.getCustomerPhone(),
					order.getCustomerAddress(), order.getOrderTime(), order.getOrderTotal() });
		}

		return model;
	}

	@Override
	public DefaultTableModel OrderTable(String startDate, String endDate) {
		List<Order> orderList = new OrderDaoImpl().selectOrderByDate(startDate + " 00:00:00", endDate + " 23:59:59");

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("訂單編號");
		model.addColumn("客戶姓名");
		model.addColumn("電話");
		model.addColumn("地址");
		model.addColumn("訂單時間");
		model.addColumn("總金額");

		model.setRowCount(0);
		for (Order order : orderList) {
			model.addRow(new Object[] { order.getOrderID(), order.getCustomerName(), order.getCustomerPhone(),
					order.getCustomerAddress(), order.getOrderTime(), order.getOrderTotal() });
		}

		return model;
	}

	@Override
	public DefaultTableModel OrderTableByCustomerID(Integer customerID) {
		List<Order> orderList = new OrderDaoImpl().selectOrderByCustomerID(customerID);

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("訂單編號");
		model.addColumn("電話");
		model.addColumn("地址");
		model.addColumn("訂單時間");
		model.addColumn("總金額");

		model.setRowCount(0);
		for (Order order : orderList) {
			model.addRow(new Object[] { order.getOrderID(), order.getCustomerPhone(), order.getCustomerAddress(),
					order.getOrderTime(), order.getOrderTotal() });
		}

		return model;
	}
	
	public DefaultTableModel OrderTableByCustomerID(String startDate, String endDate) {
		List<Order> orderList = new OrderDaoImpl().selectOrderByDate(startDate + " 00:00:00", endDate + " 23:59:59");

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("訂單編號");
		model.addColumn("客戶姓名");
		model.addColumn("電話");
		model.addColumn("地址");
		model.addColumn("訂單時間");
		model.addColumn("總金額");

		model.setRowCount(0);
		for (Order order : orderList) {
			model.addRow(new Object[] { order.getOrderID(), order.getCustomerName(), order.getCustomerPhone(),
					order.getCustomerAddress(), order.getOrderTime(), order.getOrderTotal() });
		}

		return model;
	}
}
