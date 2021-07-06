package webmypham.DTO;

import java.util.List;

public class OrderDTO {

	private int id;
	private CustomerDTO cusdto;
	private String orderDate;
	private String address;
	private String status;
	private String formofpayment;
//	private List<cart_productDTO> cart;
//	private OrderdetailDTO ordetaildto;
	
	private double tongtien;
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int id, CustomerDTO cusdto, String orderDate, String address, String status, String formofpayment,
			double tongtien) {
		super();
		this.id = id;
		this.cusdto = cusdto;
		this.orderDate = orderDate;
		this.address = address;
		this.status = status;
		this.formofpayment = formofpayment;
		this.tongtien = tongtien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerDTO getCusdto() {
		return cusdto;
	}

	public void setCusdto(CustomerDTO cusdto) {
		this.cusdto = cusdto;
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

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	
	
	
	
	
}
