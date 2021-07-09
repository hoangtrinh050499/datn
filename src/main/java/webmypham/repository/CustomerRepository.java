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
	
	@Query(value ="SELECT SUM(orderdetails.quantity*orderdetails.price) FROM `orders`,orderdetails WHERE orders.id = orderdetails.idorder AND orders.status = 'Đã hoàn thành' AND orders.idcustomer = ?1",nativeQuery = true)
	int tongtienhang(int id);
	
	
	
	@Query(value ="SELECT SUM(orderdetails.quantity*orderdetails.price) FROM `orders`,orderdetails WHERE orders.id = orderdetails.idorder AND orders.status != 'Đã hoàn thành' AND orders.status != 'Đã hủy' AND orders.idcustomer =?1",nativeQuery = true)
	int tongtienlo(int id);
}
