package webmypham.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import webmypham.model.Product_Skintype;

public interface Product_SkintypeRepository extends JpaRepository<Product_Skintype, Integer> {

	@Query(value="select * from product_skintype WHERE product_skintype.idproduct=?1", nativeQuery = true)
	List<Product_Skintype> findAll(int id);
	
	@Query(value="select * from product_skintype WHERE product_skintype.idskintype=?1", nativeQuery = true)
	List<Product_Skintype> findprroducts(int id);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM product_skintype WHERE product_skintype.idproduct=?1", nativeQuery = true)
	void delete(int id);
}
