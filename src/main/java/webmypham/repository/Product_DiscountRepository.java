package webmypham.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Product_Discount;

public interface Product_DiscountRepository extends JpaRepository<Product_Discount, Integer>{

//	@Query(value ="SELECT * from product_discount WHERE end >= '?1'",nativeQuery = true)
//	List<Product_Discount> findlistdiscount(LocalDate date);
	
	@Query(value ="SELECT level from discount d INNER join product_discount pd on d.id = pd.iddiscount INNER JOIN products p on pd.idproduct = ?1 WHERE pd.start<=?2 and pd.end >= ?2 LIMIT 1",nativeQuery = true)
	Integer finddiscount(int id,String date);
	
}
