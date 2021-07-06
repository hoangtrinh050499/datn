package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value ="SELECT * FROM customers where customers.phone=?1",nativeQuery = true)
	Customer findphoneProduct(String phone);
	
	@Query(value ="SELECT count(phone) FROM customers where customers.phone=?1",nativeQuery = true)
	int findcount(String phone);
	
	@Query(value ="SELECT id FROM customers ORDER BY customers.id DESC LIMIT 1",nativeQuery = true)
	int findIDcus();
	
}
