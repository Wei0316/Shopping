package dao.ipml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDetailDao;
import model.OrderDetail;
import util.DBConnection;

public class OrderDetailDaoImpl implements OrderDetailDao {
	public static void main(String[] args) {
		new OrderDetailDaoImpl().addOrderDetail(new OrderDetail(1, 1, 8, 4));

	}

	private static Connection connection = DBConnection.getDB();

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(
					"insert into orderdetail(OrderID,ProductID,ProductQuantity,ProductPrice) values(?,?,?,?)");
			preparedstatement.setInt(1, orderDetail.getOrderID());
			preparedstatement.setInt(2, orderDetail.getProductID());
			preparedstatement.setInt(3, orderDetail.getProductQuantity());
			preparedstatement.setInt(4, orderDetail.getProductPrice());

			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<OrderDetail> selectAllOrderDetail() {
		List<OrderDetail> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select *from orderdetaillist");

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderDetailID(resultset.getInt("OrderDetailID"));
				orderDetail.setOrderID(resultset.getInt("OrderID"));
				orderDetail.setProductName(resultset.getString("ProductName"));
				orderDetail.setProductOnePrice(resultset.getInt("ProductPrice"));
				orderDetail.setProductQuantity(resultset.getInt("ProductQuantity"));
				orderDetail.setProductPrice(resultset.getInt("Total"));

				l.add(orderDetail);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<OrderDetail> selectOrderDetailById(Integer OrderID) {
		List<OrderDetail> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select *from orderdetaillist where OrderID=?");
			preparedstatement.setInt(1, OrderID);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setProductName(resultset.getString("ProductName"));
				orderDetail.setProductOnePrice(resultset.getInt("ProductPrice"));
				orderDetail.setProductQuantity(resultset.getInt("ProductQuantity"));
				orderDetail.setProductPrice(resultset.getInt("Total"));

				l.add(orderDetail);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
