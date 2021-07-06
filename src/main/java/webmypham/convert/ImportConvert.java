package webmypham.convert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.ImportDTO;
import webmypham.DTO.ImportdetailDTO;
import webmypham.model.Employee;
import webmypham.model.Import;
import webmypham.model.Importdetail;
import webmypham.model.Supplier;
import webmypham.service.ImportdetailService;
@Component
public class ImportConvert {
	@Autowired
	EmployeeConvert empConvert;
	@Autowired
	SupplierConvert supConvert;
	@Autowired
	ImportdetailService importdetailService;
	
	
	public ImportDTO mapImportEntityToDto(Import imp,List<ImportdetailDTO> importdetaildtos,int sum) {
		ImportDTO importdto = new ImportDTO();
		importdto.setId(imp.getId());
		importdto.setEmployee(empConvert.mapEmployeeEntityToDto(imp.getEmployee()));
		importdto.setDate(imp.getDate());
		importdto.setSupplier(supConvert.mapSupplierEntityToDto(imp.getSupplier()));
		importdto.setTongtien(sum);
		importdto.setImportdetaildto(importdetaildtos);
		return importdto;
	}
	
	public Import mapImportDtoToEntity(ImportDTO importdto) {
		Import imp = new Import();
		
		imp.setId(importdto.getId());
		imp.setEmployee(empConvert.mapEmployeeDtoToEntity(importdto.getEmployee()));
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = formatter2.parse(importdto.getDate());
		
		imp.setDate(importdto.getDate());
		imp.setSupplier(supConvert.mapSupplierDtoToEntity(importdto.getSupplier()));
		return imp;
	}
	
}
