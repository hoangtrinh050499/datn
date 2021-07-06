package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Skintype;
import webmypham.model.Trademark;

public interface SkintypeRipository extends JpaRepository<Skintype, Integer> {
	@Query(value = "select * from skintype where skintype.title=?1" , nativeQuery=true)
	Skintype getNameSkintype(String name);
}
