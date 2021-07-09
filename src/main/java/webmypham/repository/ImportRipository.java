package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Import;

public interface ImportRipository extends JpaRepository<Import, Integer>{
	@Query(value ="SELECT id FROM imports ORDER BY id DESC LIMIT 1",nativeQuery = true)
	int findIDImport();
	
	@Query(value = "SELECT SUM(unitpriceimport) FROM importdetail, imports WHERE imports.id = importdetail.idbill AND Month(imports.date) = ?1",nativeQuery = true)
	int tongtienhang(int month);
	
	
	
			
	
}
