package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.CustomerClassDTO;
import webmypham.DTO.CustomerDTO;
import webmypham.convert.CustomerConvert;
import webmypham.model.Customer;
import webmypham.model.Employee;
import webmypham.repository.CustomerRepository;
import webmypham.repository.EmployeeRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	CustomerConvert customerConvert;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<CustomerDTO> findAll(){
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		int tienhang;
		int tienlo ;
		for (Customer customer : customerRepository.findAll()) {
			try {
				tienhang = customerRepository.tongtienhang(customer.getId());
				tienlo = customerRepository.tongtienlo(customer.getId());
			} catch (Exception e) {
				// TODO: handle exception
				tienhang = 0;
				tienlo = 0;
			}
			
			list.add(customerConvert.mapCustomerEntityToDto(customer,tienhang ,tienlo
					));
		}
		return list;
	}
	
	public Customer findOne(int id) {
		return customerRepository.findOne(id);
	}
	
	public Customer findOnephone(String phone) {
		return customerRepository.findphoneProduct(phone);
	}
	
	public int findcount(String phone) {
		return customerRepository.findcount(phone);
	}
	
	public void save(CustomerDTO customer) {
		customerRepository.save(customerConvert.mapCustomerDtoToEntity(customer));
		
		
	}
	public void saveclass(CustomerClassDTO account) {
		customerRepository.save(customerConvert.mapCustomerclassDtoToEntity(account));
	}
	
	public List<CustomerClassDTO> findAll1(){
		List<CustomerClassDTO> list = new ArrayList<CustomerClassDTO>();
		for (Customer customer : customerRepository.findAll()) {
			list.add(customerConvert.mapCustomerclassEntityToDto(customer));
		}
		
		return list;
	}
	
	public int findidcusdesc() {
		return customerRepository.findIDcus();
	}
	
	
	//Employee
	
	public List<Employee> findAllEmp(){
		return employeeRepository.findAll();
	}
	
	public Employee findOneEmp(int id) {
		return employeeRepository.findOne(id);
	}
	
	public void save(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public void delete(int id) {
		employeeRepository.delete(id);
	}
	
}
