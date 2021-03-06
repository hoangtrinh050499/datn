package webmypham.DTO;

import javax.persistence.Column;

public class CustomerDTO {

	private int id;
	private String name;

	private String email;

	private String phone;

	private String address;
	private int tongtienhang;
	private int tongtienno;
	
	
	
	public CustomerDTO(int id, String name, String email, String phone, String address, int tongtienhang,
			int tongtienno) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.tongtienhang = tongtienhang;
		this.tongtienno = tongtienno;
	}

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTongtienhang() {
		return tongtienhang;
	}

	public void setTongtienhang(int tongtienhang) {
		this.tongtienhang = tongtienhang;
	}

	public int getTongtienno() {
		return tongtienno;
	}

	public void setTongtienno(int tongtienno) {
		this.tongtienno = tongtienno;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
