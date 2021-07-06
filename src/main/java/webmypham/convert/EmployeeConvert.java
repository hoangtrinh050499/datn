package webmypham.convert;

import org.springframework.stereotype.Component;

import webmypham.DTO.EmployeeDTO;
import webmypham.model.Employee;

@Component
public class EmployeeConvert {

	public EmployeeDTO mapEmployeeEntityToDto(Employee emp) {
		EmployeeDTO empdto = new EmployeeDTO();
		empdto.setId(emp.getId());
		empdto.setFirstname(emp.getFirstname());
		empdto.setLastname(emp.getLastname());
		empdto.setImage(emp.getImage());
		empdto.setDate(emp.getDate());
		empdto.setAddress(emp.getAddress());
		empdto.setPhone(emp.getPhone());
		return empdto;
	}
	
	public Employee mapEmployeeDtoToEntity(EmployeeDTO emp) {
		Employee empdto = new Employee();
		empdto.setId(emp.getId());
		empdto.setFirstname(emp.getFirstname());
		empdto.setLastname(emp.getLastname());
		empdto.setImage(emp.getImage());
		empdto.setDate(emp.getDate());
		empdto.setAddress(emp.getAddress());
		empdto.setPhone(emp.getPhone());
		return empdto;
	}

}
