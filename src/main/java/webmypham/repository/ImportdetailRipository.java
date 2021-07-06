package webmypham.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import webmypham.model.Importdetail;
import webmypham.model.Products;

public interface ImportdetailRipository extends JpaRepository<Importdetail, Integer> {

	@Query(value="select sum(quantityimport*unitpriceimport) from importdetail where importdetail.idbill=?1", nativeQuery= true)
	int getTongTien(int id);
	
	@Query(value="select * from importdetail where importdetail.idbill=?1", nativeQuery= true)
	List<Importdetail> getimportdetail(int id);
	
	@Modifying
	@Transactional
	@Query(value="insert INTO importdetail(idbill,idproduct,nsx,exp,quantityimport,unitpriceimport,quantitysell,unitpricesell) values(?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery= true)
	void insert( int idbill,int idproduct,String nsx,String exp,
			int quantityimport,int unitpriceimport,int quantitysell,int unitpricesell);
	
	   
	@Query(value ="select max(unitpricesell) from importdetail WHERE importdetail.idproduct=?1",nativeQuery = true)
	Integer findprice(int pro);
	
	
//	@Query(value="SELECT id,idbill,idproduct,nsx,exp,quantityimport,unitpriceimport,quantitysell,MAX(unitpricesell) as unitpricesell FROM importdetail WHERE unitpricesell>250000 GROUP BY idproduct ;", nativeQuery = true)
//	List<Importdetail> findcaocap();
//	
	
	@Query(value="SELECT ANY_VALUE(rw.id) as id,ANY_VALUE(rw.idproduct) as idproduct,ANY_VALUE(rw.idbill) as idbill,ANY_VALUE(rw.nsx) as nsx\r\n" + 
			",ANY_VALUE(rw.exp) as exp,ANY_VALUE(rw.quantityimport) as quantityimport,\r\n" + 
			"ANY_VALUE(rw.unitpriceimport) as unitpriceimport,ANY_VALUE(rw.quantitysell) as quantitysell,\r\n" + 
			"MAX(rw.unitpricesell) as unitpricesell FROM importdetail as rw where unitpricesell > 250000\r\n" + 
			"group by idproduct;", nativeQuery = true)
	List<Importdetail> findcaocap();
	
	
}
