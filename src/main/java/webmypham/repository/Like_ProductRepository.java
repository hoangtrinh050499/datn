package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Like_Product;

public interface Like_ProductRepository extends JpaRepository<Like_Product, Integer>{
	
	@Query(value="SELECT COUNT(idaccount) FROM `like_product` WHERE idaccount=?1" , nativeQuery = true)
	int findcount(int id);
}
