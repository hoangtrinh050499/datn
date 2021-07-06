package webmypham.DTO;

import javax.persistence.Column;

public class SupplierDTO {

	private int id;
	private String namesupplier;
	private String email;
	private String phone;
	private String address;
	public SupplierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplierDTO(int id, String namesupplier, String email, String phone, String address) {
		super();
		this.id = id;
		this.namesupplier = namesupplier;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamesupplier() {
		return namesupplier;
	}
	public void setNamesupplier(String namesupplier) {
		this.namesupplier = namesupplier;
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
