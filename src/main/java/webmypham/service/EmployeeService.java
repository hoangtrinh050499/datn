package webmypham.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.model.Employee;
import webmypham.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRipository;
	
	public Employee findOne(int id) {
		return employeeRipository.findOne(id);
	}
}
