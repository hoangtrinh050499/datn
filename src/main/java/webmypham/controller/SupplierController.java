package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webmypham.DTO.SupplierDTO;
import webmypham.model.Supplier;
import webmypham.service.SupplierService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = "/supplier")
	public List<SupplierDTO> getAll(){
		return supplierService.findAll();
	}
	
	@PostMapping(value="/supplier/insert")
	public void insert(@RequestBody SupplierDTO sup) {
		supplierService.save(sup);
	}
	
	@PutMapping(value="/supplier/update/{id}")
	public String update(@PathVariable("id") int id, @RequestBody SupplierDTO sup) {
		Supplier a = supplierService.findOne(id);
		if(a != null) {
			sup.setId(id);
			supplierService.save(sup);
			return "Update thành công";
		}
		return "Update không thành công";
	}
	
	@DeleteMapping(value="/supplier/delete/{id}")
	public String delete(@PathVariable("id")int id) {
		Supplier a = supplierService.findOne(id);
		if(a != null) {
			supplierService.delete(id);
			return "Delete thành công";
		}
		return "Delete không thành công";
	}
}
