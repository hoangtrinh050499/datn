package webmypham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Order;
import webmypham.model.Products;

public interface OrderRepository extends JpaRepository<Order, Integer > {

	
	@Query(value="SELECT id FROM orders ORDER BY orders.id DESC LIMIT 1;", nativeQuery = true)
	int findorderlast();
	
		
	@Query(value = "SELECT SUM(orderdetails.price*orderdetails.quantity) FROM orders, orderdetails WHERE orderdetails.idorder = orders.id AND Month(orders.orderdate) = ?1 AND orders.status = 'Đã hoàn thành'",nativeQuery = true)
	int tongtienban(int month);	
	
	@Query(value="SELECT COUNT(*) FROM `orders` WHERE MONTH(orders.orderdate)=?1", nativeQuery = true)
	int tonghoadon(int month);
	
	
	@Query(value="SELECT COUNT(DISTINCT idcustomer) FROM orders WHERE MONTH(orders.orderdate) = ?1", nativeQuery = true)
	int tongkhachhang(int month);
	
	@Query(value="SELECT COUNT(*) FROM orders WHERE MONTH(orders.orderdate) = ?1 AND orders.status = 'Đã hoàn thành'", nativeQuery = true)
	int tongdonhanghoanthanh(int month);
	
	@Query(value="SELECT COUNT(*) FROM orders WHERE MONTH(orders.orderdate) = ?1 AND orders.status = 'Đã hủy'", nativeQuery = true)
	int tongdonhanghuy(int month);
	
}
