package dao;

import java.util.List;

import model.OrderDetail;

public interface OrderDetailDao {
	void addOrderDetail(OrderDetail orderDetail);
	
	List<OrderDetail> selectAllOrderDetail();
	List<OrderDetail> selectOrderDetailById(Integer OrderID);
	
}
