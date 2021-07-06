package webmypham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Order;
import webmypham.model.Products;

public interface OrderRepository extends JpaRepository<Order, Integer > {

	
	@Query(value="SELECT id FROM orders ORDER BY orders.id DESC LIMIT 1;", nativeQuery = true)
	int findorderlast();
	
	
}
