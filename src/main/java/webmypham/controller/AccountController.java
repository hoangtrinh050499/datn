package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webmypham.DTO.AccountDTO;
import webmypham.service.AccountService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	
	@Autowired
	AccountService accountservice;
	
	@GetMapping(value="/login/{username}/{password}")
	public AccountDTO checklogin(@PathVariable("username")String username, @PathVariable("password")String password) {
		return accountservice.checklogin(username,password);
	}
	
	@GetMapping(value="/loginlist")
	public List<AccountDTO> checklogin() {
		return accountservice.findAll();
	}
	
}
