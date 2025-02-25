package service.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.ipml.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Override
	public DefaultTableModel ProductSelectForTable() {
		List<Product> productList = new ProductDaoImpl().selectAllProduct();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("商品編號");
		model.addColumn("商品名稱");
		model.addColumn("單價");
		model.addColumn("庫存");
		
		model.setRowCount(0);
		for (Product product : productList) {
			model.addRow(new Object[] { product.getProductID(), product.getProductName(),
					product.getProductPrice(), product.getProductStock() });
		}

		return model;
	}

}
