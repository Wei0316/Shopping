package dao.ipml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import model.Order;
import util.ClockTool;
import util.DBConnection;

public class OrderDaoImpl implements OrderDao {

	public static void main(String[] args) {
		List<Order> order = new OrderDaoImpl().selectOrderByDate("2025-2-22","2025-2-24");
		for (Order o : order) {
			System.out.print(o.getOrderTime());
		}

	}

	private static Connection connection = DBConnection.getDB();

	@Override
	public void addOrder(Order order) {
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("insert into orders(CustomerID,OrderTime,OrderTotal) values(?,?,?)");
			preparedstatement.setInt(1, order.getCustomerID());
			preparedstatement.setString(2, ClockTool.getTime());
			preparedstatement.setInt(3, order.getOrderTotal());

			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Order> selectAllOrder() {
		List<Order> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select *from orderlist");
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Order order = new Order();
				order.setOrderID(resultset.getInt("OrderID"));
				order.setCustomerName(resultset.getString("CustomerName"));
				order.setCustomerPhone(resultset.getString("CustomerPhone"));
				order.setCustomerAddress(resultset.getString("CustomerAddress"));
				order.setOrderTime(resultset.getString("OrderTime"));
				order.setOrderTotal(resultset.getInt("OrderTotal"));

				l.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Order> selectOrderByDate(String startDate, String endDate) {
		List<Order> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select *from orderlist where OrderTime between ? and ?");
			preparedstatement.setString(1, startDate);
			preparedstatement.setString(2, endDate);
			
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Order order = new Order();
				order.setOrderID(resultset.getInt("OrderID"));
				order.setCustomerName(resultset.getString("CustomerName"));
				order.setCustomerPhone(resultset.getString("CustomerPhone"));
				order.setCustomerAddress(resultset.getString("CustomerAddress"));
				order.setOrderTime(resultset.getString("OrderTime"));
				order.setOrderTotal(resultset.getInt("OrderTotal"));

				l.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Order> selectOrderByCustomerID(Integer customerID) {
		List<Order> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement("select *from orderlist where CustomerID=?");
			preparedstatement.setInt(1,customerID);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Order order = new Order();
				order.setOrderID(resultset.getInt("OrderID"));
				order.setCustomerPhone(resultset.getString("CustomerPhone"));
				order.setCustomerAddress(resultset.getString("CustomerAddress"));
				order.setOrderTime(resultset.getString("OrderTime"));
				order.setOrderTotal(resultset.getInt("OrderTotal"));

				l.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Integer selectOrderID(int CustomerID, String OrderTime) {
		Integer OrderID = null;
		try {
			PreparedStatement preparedstatement = connection
					.prepareStatement("select OrderID from orders where CustomerID=? and OrderTime=?");

			preparedstatement.setInt(1, CustomerID);
			preparedstatement.setString(2, OrderTime);

			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				OrderID = resultset.getInt("OrderID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OrderID;
	}

	

}
