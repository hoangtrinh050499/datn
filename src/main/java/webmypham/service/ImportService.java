package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.ImportDTO;
import webmypham.DTO.ImportdetailDTO;
import webmypham.convert.ImportConvert;
import webmypham.convert.ImportdetailConvert;
import webmypham.model.Employee;
import webmypham.model.Import;
import webmypham.model.Importdetail;
import webmypham.model.Supplier;
import webmypham.repository.ImportRipository;
import webmypham.repository.ImportdetailRipository;

@Service
public class ImportService {

	
	
	@Autowired
	ImportConvert importConvert;
	
	@Autowired
	ImportdetailConvert importdetailConvert;
	@Autowired
	ImportdetailService importdetailService;

	@Autowired
	ImportRipository importRipository;
	
	
	public List<ImportDTO> findAll(){
		List<ImportDTO> importdtos = new ArrayList<ImportDTO>();
		for(Import i :  importRipository.findAll()) {
			List<ImportdetailDTO> importdetailDTO = importdetailService.getIDbill(i.getId());
			int sum = importdetailService.Sum(i.getId());
			importdtos.add(importConvert.mapImportEntityToDto(i,importdetailDTO,sum));
		}
		return importdtos; 
	}
	
	public void save(ImportDTO imp) {
		importRipository.save(importConvert.mapImportDtoToEntity(imp));
//		imp.setId(importRipository.findIDImport());
//		for (ImportdetailDTO i : imp.getImportdetaildto()) {
//			importdetailService.save(i, imp);
//		}
	}
	
	public int getID() {
		return importRipository.findIDImport();
	}
	
}
