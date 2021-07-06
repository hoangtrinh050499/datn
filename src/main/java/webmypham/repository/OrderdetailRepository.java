package webmypham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Order;
import webmypham.model.Orderdetail;

public interface OrderdetailRepository extends JpaRepository<Orderdetail, Integer>{

	@Query(value="SELECT * FROM orders ORDER BY orders.id DESC LIMIT 1;", nativeQuery = true)
	Order findorderlast();
	
	@Query(value="SELECT SUM(orderdetails.quantity*orderdetails.price) FROM orderdetails WHERE orderdetails.idorder = ?1", nativeQuery = true)
	int findordersumprice(int id);
	
	@Query(value="SELECT * FROM orderdetails WHERE orderdetails.idorder = ?1", nativeQuery = true)
	List<Orderdetail> findorder(int id);
	
	
}
