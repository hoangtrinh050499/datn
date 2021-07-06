package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webmypham.DTO.ImportDTO;
import webmypham.DTO.ImportdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.convert.ImportConvert;
import webmypham.model.Import;
import webmypham.service.ImportService;
import webmypham.service.ImportdetailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImportController {

	@Autowired
	ImportService importService;
	@Autowired
	ImportConvert importConvert;
	
	@Autowired
	ImportdetailService importdetailService;
	
	
	@GetMapping(value ="/import")
	public List<ImportDTO> getAll(){
		return importService.findAll();
	}
	
	@PostMapping(value="/import/insert")
	public int insert(@RequestBody ImportDTO impdto) {
		importService.save(impdto);
		impdto.setId(importService.getID());
		Import imp = importConvert.mapImportDtoToEntity(impdto);
		for (ImportdetailDTO i : impdto.getImportdetaildto()) {
			importdetailService.save(i, impdto);
		}
		return importService.getID();
	}
	
	//detail
	@GetMapping(value ="/import/{id}")
	public List<ImportdetailDTO> getidbill(@PathVariable("id")int id){
		return importdetailService.getIDbill(id);
	}
	
	
}
