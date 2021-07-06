package webmypham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String namesupplier;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String address;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int id, String namesupplier, String email, String phone, String address) {
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
	public String getNameSupplier() {
		return namesupplier;
	}
	public void setNameSupplier(String namesupplier) {
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
