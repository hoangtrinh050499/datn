package webmypham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private int idtitle;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(int id, String userName, String passWord, int idtitle) {
		super();
		this.id = id;
		this.username = userName;
		this.password = passWord;
		this.idtitle = idtitle;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return username;
	}


	public void setUserName(String userName) {
		this.username = userName;
	}


	public String getPassWord() {
		return password;
	}


	public void setPassWord(String passWord) {
		this.password = passWord;
	}


	public int getIdtitle() {
		return idtitle;
	}


	public void setIdtitle(int idtitle) {
		this.idtitle = idtitle;
	}
}
