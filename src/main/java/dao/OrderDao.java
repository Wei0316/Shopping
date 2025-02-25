package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	void addOrder(Order order);

	List<Order> selectAllOrder();
	List<Order> selectOrderByDate(String startDate, String endDate);
	List<Order> selectOrderByCustomerID(Integer customerId);
	Integer selectOrderID(int CustomerID, String OrderTime);

}
