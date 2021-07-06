package webmypham.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Product_Composition;

public interface Product_CompositionRepository extends JpaRepository<Product_Composition, Integer>{

	@Query(value="select * from product_composition WHERE product_composition.idproduct=?1", nativeQuery = true)
	List<Product_Composition> findAll(int id);
	
	@Query(value="select * from product_composition WHERE product_composition.idcomposition=?1", nativeQuery = true)
	List<Product_Composition> findAllproducts(int id);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM product_composition WHERE product_composition.idproduct=?1", nativeQuery = true)
	void delete(int id);
	
	
}
