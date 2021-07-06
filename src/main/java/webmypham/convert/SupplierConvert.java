package webmypham.convert;

import org.springframework.stereotype.Component;

import webmypham.DTO.SupplierDTO;
import webmypham.model.Supplier;
@Component
public class SupplierConvert {

	public SupplierDTO mapSupplierEntityToDto(Supplier s) {
		SupplierDTO supplierdto = new SupplierDTO();
		supplierdto.setId(s.getId());
		supplierdto.setNamesupplier(s.getNameSupplier());
		supplierdto.setEmail(s.getEmail());
		supplierdto.setPhone(s.getPhone());
		supplierdto.setAddress(s.getAddress());
		return supplierdto;
	}
	
	public Supplier mapSupplierDtoToEntity(SupplierDTO s) {
		Supplier supplierdto = new Supplier();
		supplierdto.setId(s.getId());
		supplierdto.setNameSupplier(s.getNamesupplier());;
		supplierdto.setEmail(s.getEmail());
		supplierdto.setPhone(s.getPhone());
		supplierdto.setAddress(s.getAddress());
		return supplierdto;
	}
}
