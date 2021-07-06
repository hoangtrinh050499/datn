package webmypham.convert;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.ImportdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.model.Import;
import webmypham.model.Importdetail;
import webmypham.model.Products;
@Component
public class ImportdetailConvert {

	@Autowired
	ProductConverter productConvert;
	
	public ImportdetailDTO mapImportdetailEntityToDto(Importdetail importdetail) {
		ImportdetailDTO imp = new ImportdetailDTO();
		imp.setId(importdetail.getId());
		imp.setProduct(productConvert.mapProductclassEntityToDto(importdetail.getProduct()));
		imp.setNsx(importdetail.getNsx());
		imp.setExp(importdetail.getExp());
		imp.setQuantityimport(importdetail.getQuantityimport());
		imp.setUnitpriceimport(importdetail.getUnitpriceimport());
		imp.setUnitpricesell(importdetail.getUnitpricesell());
		imp.setThanhtien(importdetail.getQuantityimport()*importdetail.getUnitpriceimport());
		return imp;
	}
	
	public Importdetail mapImportDtoToEntity(ImportdetailDTO i, Import dtimport) {
		Importdetail imp = new Importdetail();
		imp.setId(i.getId());
		imp.setDtimport(dtimport);
		imp.setProduct(productConvert.mapProductclassDtoToEntity(i.getProduct()));
		imp.setNsx(i.getNsx());
		imp.setExp(i.getExp());
		imp.setQuantityimport(i.getQuantityimport());
		imp.setUnitpriceimport(i.getUnitpriceimport());
		imp.setQuantitysell(i.getQuantityimport());
		imp.setUnitpricesell(i.getUnitpricesell());
		return imp;
	}
}
