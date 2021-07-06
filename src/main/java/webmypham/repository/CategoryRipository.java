package webmypham.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Category;
import webmypham.model.Composition;

public interface CategoryRipository extends JpaRepository<Category, Integer>{

	@Query(value = "select * from category where category.namecategory=?1" , nativeQuery=true)
	Category getNameCategory(String name);
	
	
	@Query(value = "select * from category where category.idtitlecategory=?1" , nativeQuery=true)
	List<Category> getCategory(int idtitlecategory);
}
