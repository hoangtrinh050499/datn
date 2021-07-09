package webmypham.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webmypham.DTO.CustomerClassDTO;
import webmypham.DTO.CustomerDTO;
import webmypham.model.Customer;

@Component
public class CustomerConvert {
	@Autowired
	AccountConvert accountconvert;

	public CustomerDTO mapCustomerEntityToDto(Customer cus,int tongtienhang,int tongtienno) {
		CustomerDTO cusdto = new CustomerDTO();
		cusdto.setId(cus.getId());
		cusdto.setName(cus.getName());
		cusdto.setEmail(cus.getEmail());
		cusdto.setPhone(cus.getPhone());
		cusdto.setAddress(cus.getAddress());
		cusdto.setTongtienhang(tongtienhang);
		cusdto.setTongtienno(tongtienno);
		return cusdto;
	}
	
	public Customer mapCustomerDtoToEntity(CustomerDTO cus) {
		Customer cusdto = new Customer();
		cusdto.setId(cus.getId());
		cusdto.setName(cus.getName());
		cusdto.setEmail(cus.getEmail());
		cusdto.setPhone(cus.getPhone());
		cusdto.setAddress(cus.getAddress());
		
		return cusdto;
	}
	
	// class customer
	public CustomerClassDTO mapCustomerclassEntityToDto(Customer cus) {
		CustomerClassDTO cusdto = new CustomerClassDTO();
		cusdto.setId(cus.getId());
		cusdto.setName(cus.getName());

		cusdto.setEmail(cus.getEmail());
		cusdto.setPhone(cus.getPhone());
		cusdto.setAddress(cus.getAddress());
		cusdto.setAccount(accountconvert.mapAccountEntityToDto(cus.getAccount()));
		return cusdto;
	}
	
	public Customer mapCustomerclassDtoToEntity(CustomerClassDTO cus) {
		Customer cusdto = new Customer();
		cusdto.setId(cus.getId());
		cusdto.setName(cus.getName());
		cusdto.setEmail(cus.getEmail());
		cusdto.setPhone(cus.getPhone());
		cusdto.setAddress(cus.getAddress());
		cusdto.setAccount(accountconvert.mapAccountDtoToEntity(cus.getAccount()));
		
		return cusdto;
	}
	
	

	
}
