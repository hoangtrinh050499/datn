package webmypham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.AccountDTO;
import webmypham.DTO.CustomerClassDTO;
import webmypham.convert.AccountConvert;
import webmypham.convert.CustomerConvert;
import webmypham.model.Account;
import webmypham.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountConvert accountconvert;
	
	
	public AccountDTO checklogin(String username , String password) {
		try {
			return accountconvert.mapAccountEntityToDto(accountRepository.checklogin(username, password));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<AccountDTO> findAll(){
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		for (Account account : accountRepository.findAll()) {
			list.add(accountconvert.mapAccountEntityToDto(account));
		}
		return list;
	}
	
	public void save(AccountDTO account) {
		accountRepository.save(accountconvert.mapAccountDtoToEntity(account));
	}
	
	
	public int findiddesc() {
		return accountRepository.findIDaccount();
	}
	
}
