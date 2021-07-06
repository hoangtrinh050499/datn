package webmypham.DTO;

import javax.persistence.Column;

public class AccountDTO {
	private int id;

	private String username;

	private String password;
	
	private int idtitle;

	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(int id, String username, String password, int idtitle) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.idtitle = idtitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdtitle() {
		return idtitle;
	}

	public void setIdtitle(int idtitle) {
		this.idtitle = idtitle;
	}
	
	
}
