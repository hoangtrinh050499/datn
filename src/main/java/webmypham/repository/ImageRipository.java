package webmypham.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webmypham.model.ImageProduct;
import webmypham.model.Products;

@Repository
public interface ImageRipository extends JpaRepository<ImageProduct, Integer>{
	
//	@Query("SELECT img FROM ImageProduct img where img.idproduct=:product")
//	List<ImageProduct> findByImageproduct(@Param("product")Products product);
//	
//	@Query("SELECT img FROM ImageProduct img where img.idproduct=:product and limit 0,1")
//	ImageProduct findOneImageProduct(@Param("product")Products product);
	
	@Query(value="select * from imageproducts WHERE imageproducts.idproduct=?1", nativeQuery = true)
	List<ImageProduct> findByImageproduct(Products id);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM imageproducts WHERE imageproducts.idproduct=?1", nativeQuery = true)
	void delete(int id);
	
}
