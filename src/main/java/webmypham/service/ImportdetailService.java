
package webmypham.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.ImportDTO;
import webmypham.DTO.ImportdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.convert.ImportConvert;
import webmypham.convert.ImportdetailConvert;
import webmypham.convert.ProductConverter;
import webmypham.model.Import;
import webmypham.model.Importdetail;
import webmypham.model.Products;
import webmypham.repository.ImportdetailRipository;

@Service
public class ImportdetailService {
	@Autowired
	ImportdetailConvert importdetailConvert;
	@Autowired
	ImportConvert importConvert;
	
	@Autowired
	ProductConverter productConvert;

	@Autowired
	ImportdetailRipository importdetailRipository;
	
	public int Sum(int id) {
		return importdetailRipository.getTongTien(id);
	}
	
	public List<ImportdetailDTO> getIDbill(int id){
		List<ImportdetailDTO> imps = new ArrayList<ImportdetailDTO>();
		for (Importdetail i : importdetailRipository.getimportdetail(id)) {
			imps.add(importdetailConvert.mapImportdetailEntityToDto(i));
		}
		return imps;
	}
	
	public void save(ImportdetailDTO impdetaildto , ImportDTO impdto) {
		Import imp = importConvert.mapImportDtoToEntity(impdto);
		Importdetail impdetail = importdetailConvert.mapImportDtoToEntity(impdetaildto, imp);
		importdetailRipository.insert(impdetail.getDtimport().getId(),impdetail.getProduct().getId(),impdetail.getNsx(),impdetail.getExp(),
				impdetail.getQuantityimport(),impdetail.getUnitpriceimport(),impdetail.getQuantitysell(),impdetail.getUnitpricesell());
	}
	
	public Integer findprice(int id){
		return importdetailRipository.findprice(id);
	}
	
	public List<ImportdetailDTO> caocap(){
		List<ImportdetailDTO> imps = new ArrayList<ImportdetailDTO>();
		for (Importdetail i : importdetailRipository.findcaocap()) {
			imps.add(importdetailConvert.mapImportdetailEntityToDto(i));
		}
		return imps;
	}
}
