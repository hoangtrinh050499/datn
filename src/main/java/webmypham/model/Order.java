package webmypham.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="idcustomer")
	private Customer Customer;
	@Column(name="orderdate")
	private String orderDate;
	@Column
	private String address;
	@Column
	private String status;
	@Column
	private String formofpayment;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, webmypham.model.Customer customer, String orderDate, String address, String status,
			String formofpayment) {
		super();
		this.id = id;
		Customer = customer;
		this.orderDate = orderDate;
		this.address = address;
		this.status = status;
		this.formofpayment = formofpayment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFormofpayment() {
		return formofpayment;
	}
	public void setFormofpayment(String formofpayment) {
		this.formofpayment = formofpayment;
	}
	
	
	
	
	
	
	
}
