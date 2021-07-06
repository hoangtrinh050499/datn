package webmypham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Product_Composition;
import webmypham.model.product_category;

public interface Product_CategoryRepository extends JpaRepository<product_category, Integer> {

	
	@Query(value="select * from product_category WHERE product_category.idproduct=?1", nativeQuery = true)
	List<product_category> findAll(int id);
	
	@Query(value="select * from product_category WHERE product_category.idcategory=?1", nativeQuery = true)
	List<product_category> findcategory(int id);
	
	
}
