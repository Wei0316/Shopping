package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;


import dao.ipml.OrderDetailDaoImpl;

import model.OrderDetail;
import service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{

	@Override
	public DefaultTableModel OrderDetailTable(Integer OrderID) {
		List<OrderDetail> orderDetailList = new OrderDetailDaoImpl().selectOrderDetailById(OrderID);

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("商品名稱");
		model.addColumn("商品單價");
		model.addColumn("數量");
		model.addColumn("金額");
		

		model.setRowCount(0);
		for (OrderDetail orderDeatil : orderDetailList) {
			model.addRow(new Object[] { orderDeatil.getProductName(), orderDeatil.getProductOnePrice(), orderDeatil.getProductQuantity(),
					orderDeatil.getProductPrice() });
		}

		return model;
	}

}
