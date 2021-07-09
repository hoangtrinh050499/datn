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

import webmypham.DTO.AccountDTO;
import webmypham.DTO.CustomerClassDTO;
import webmypham.DTO.CustomerDTO;
import webmypham.model.Customer;
import webmypham.model.Employee;
import webmypham.service.AccountService;
import webmypham.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value="/customer")
	public List<CustomerDTO> getAll(){
		return customerService.findAll();
	}
	
	@GetMapping(value="/customer/findphone/{phone}")
	public Customer getphone(@PathVariable("phone") String phone){
		return customerService.findOnephone(phone);
	}
	
	@GetMapping(value="/customer/findcount/{phone}")
	public int getcount(@PathVariable("phone") String phone){
		return customerService.findcount(phone);
	}
	
	
	@PostMapping(value="/customer/insert")
	public void insert(@RequestBody CustomerDTO customer) {
		customerService.save(customer);
	}
	
	@PutMapping(value="/customer/update/{id}")
	public String update(@PathVariable("id") int id,@RequestBody CustomerDTO customer) {
		Customer cus = customerService.findOne(id);
		if(cus != null) {
			customer.setId(id);
			customerService.save(customer);
			return "Update thành công";
		}
		return "Update không thành công";
	}
	
	@PostMapping(value="/customer/dangki")
	public int dangki(@RequestBody CustomerClassDTO customer) {
		accountService.save(customer.getAccount());
		int id = accountService.findiddesc();
		customer.getAccount().setId(id);
		customerService.saveclass(customer);
		return customerService.findidcusdesc();
	}
	
	@GetMapping(value="/customer/find/dangki")
	public List<CustomerClassDTO> getAll1(){
		return customerService.findAll1();
	}
	
	
	
	//Employee
	
	@GetMapping(value = "/employee")
	public List<Employee> getALLEmp(){
		return customerService.findAllEmp();
	}
	
	@GetMapping(value = "/employee/{id}")
	public Employee getID(@PathVariable("id") int id) {
		return customerService.findOneEmp(id);
	}
	
	@PostMapping(value="/employee/insert")
	public void insertEmp(@RequestBody Employee emp) {
		customerService.save(emp);
	}
	
	@PutMapping(value = "/employee/update/{id}")
	public String updateEmp(@PathVariable("id") int id,@RequestBody Employee employee) {
		Employee emp = customerService.findOneEmp(id);
		if(emp != null) {
			employee.setId(id);
			customerService.save(employee);
			return "Update thành công";
		}
		return "Update không thành công";
	}
	
	@DeleteMapping(value="/employee/delete/{id}")
	public String deleteEmp(@PathVariable("id") int id) {
		Employee emp  = customerService.findOneEmp(id);
		if(emp != null) {
			customerService.delete(id);
			return "Delete thành công";
		}
		return "Delete không thành công";
	}
	
	
}
