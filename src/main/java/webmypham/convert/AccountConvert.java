package webmypham.convert;

import org.springframework.stereotype.Component;

import webmypham.DTO.AccountDTO;
import webmypham.model.Account;

@Component
public class AccountConvert {

	
	public AccountDTO mapAccountEntityToDto(Account account) {
		AccountDTO accountdto = new AccountDTO();
		accountdto.setId(account.getId());
		accountdto.setUsername(account.getUserName());
		accountdto.setPassword(account.getPassWord());
		accountdto.setIdtitle(account.getIdtitle());
		return accountdto;
	}
	
	public Account mapAccountDtoToEntity(AccountDTO accountdto) {
		Account account = new Account();
		account.setId(accountdto.getId());
		account.setUserName(accountdto.getUsername());
		account.setPassWord(accountdto.getPassword());
		account.setIdtitle(accountdto.getIdtitle());
		return account;
	}
	
}
