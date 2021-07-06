package webmypham.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import webmypham.DTO.AccountDTO;
import webmypham.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query(value="select * from account where account.username =?1 and account.password =?2 ", nativeQuery = true)
	Account checklogin(String username, String pass);
	
	@Query(value ="SELECT id FROM account ORDER BY account.id DESC LIMIT 1",nativeQuery = true)
	int findIDaccount();
	
}
