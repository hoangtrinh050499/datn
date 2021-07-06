package webmypham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.CategoryTitle;

public interface CategoryTitlieRepository extends JpaRepository<CategoryTitle, Integer>{
	@Query(value="select * from titlecategory WHERE titlecategory.title=?1", nativeQuery = true)
	CategoryTitle findByCategoryTitle(String title);
	
	@Query(value="select * from titlecategory WHERE titlecategory.id=?1", nativeQuery = true)
	CategoryTitle findByidCategoryTitle(int title);
	
}
