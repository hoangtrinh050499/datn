package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Category;
import webmypham.model.Trademark;

public interface TrademarkRipository extends JpaRepository<Trademark, Integer>{

	@Query(value = "select * from trademarks where trademarks.nametrademark=?1" , nativeQuery=true)
	Trademark getNameTrademark(String name);

}
