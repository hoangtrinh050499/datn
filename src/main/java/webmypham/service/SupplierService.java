package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.SupplierDTO;
import webmypham.convert.SupplierConvert;
import webmypham.model.Supplier;
import webmypham.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierConvert supplierConvert;
	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<SupplierDTO> findAll(){
		List<SupplierDTO> supdto = new ArrayList<SupplierDTO>();
		for (Supplier i : supplierRepository.findAll()) {
			supdto.add(supplierConvert.mapSupplierEntityToDto(i));
		}
		return supdto;
	}
	public void save(SupplierDTO sup) {
		supplierRepository.save(supplierConvert.mapSupplierDtoToEntity(sup));
	}
	
	public Supplier findOne(int id) {
		return supplierRepository.findOne(id);
	}
	
	public void delete(int id) {
		supplierRepository.delete(id);
	}

}
