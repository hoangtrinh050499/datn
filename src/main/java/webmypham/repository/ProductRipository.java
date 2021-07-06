package webmypham.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import webmypham.DTO.ProductDTO;
import webmypham.model.ImageProduct;
import webmypham.model.Product_Composition;
import webmypham.model.Products;



public interface ProductRipository extends JpaRepository<Products,Integer> {

//	public static String name = "";
//
//	@Query("SELECT * FROM products where products.nameproduct LIKE '%"+name+"%'")
//	List<Products> findProduct();
	
	
	@Query(value ="SELECT id FROM products ORDER BY id DESC LIMIT 1",nativeQuery = true)
	int findIDProduct();
	
//	@Query(value ="SELECT MAX(unitpricesell) FROM importdetail WHERE idproduct=?1;",nativeQuery = true)
//	int findprice(int id);
	
	
//	@Query(value ="SELECT level from discount d INNER join product_discount pd on d.id = pd.iddiscount INNER JOIN products p on pd.idproduct = ?1 WHERE d.start = '?2'",nativeQuery = true)
//	int finddiscount(int id,LocalDate date);
	
	
	
	
	@Query(value="select * from products WHERE products.idtrademark=?1", nativeQuery = true)
	List<Products> findAllproducts(int id);
	
	@Query(value="select * from products WHERE products.idcategory=?1", nativeQuery = true)
	List<Products> findAllproductscategory(int id);
	
}


